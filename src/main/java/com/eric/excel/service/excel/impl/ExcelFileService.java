package com.eric.excel.service.excel.impl;

import com.eric.excel.model.Book;
import com.eric.excel.service.excel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ExcelFileService implements IExcelService {

    private final IWorkbookService workbookService;

    private final ISheetService sheetService;

    private final ICellStyleService cellStyleService;

    private final IRowService rowService;

    private final IColumnService columnService;

    private final ICellService cellService;

    private final int ROW_HEADER_INDEX = 0;

    private final int COLUM_INDEX_ID = 0;

    private final int COLUM_INDEX_TITLE = 1;

    private final int COLUMN_INDEX_PRICE = 2;

    private final int COLUMN_INDEX_QUANTITY = 3;

    private static int rowIndex = 1;

    private final int COLUMN_INDEX_TOTAL = 4;

    public ExcelFileService(@Qualifier("workbookService") WorkbookService workbookService,
                            @Qualifier("cellStyleService") CellStyleService cellStyleService,
                            @Qualifier("rowService") RowService rowService,
                            @Qualifier("sheetService") SheetService sheetService,
                            @Qualifier("cellService") ICellService cellService,
                            @Qualifier("columnService") IColumnService columnService) {
        this.workbookService = workbookService;
        this.cellStyleService = cellStyleService;
        this.rowService = rowService;
        this.sheetService = sheetService;
        this.cellService = cellService;
        this.columnService = columnService;
    }

    private final String[] TITLES = {"Spider-Man: Into the Spider-Verse", "Dr. No"
            , "Anne with an E"
            , "Jessica Jones", "Black Sails"
            , "Counterpart", "The Pink Panther"
            , "Guardians of the Galaxy Vol. 2"
            , "Vertigo"
            , "JCVD"};

    @Override
    public List<Book> createDummyBookData() {
        Random random = new Random();
        List<Book> bookList = new ArrayList<Book>();
        for(int index = 0; index < 10; index++) {
            double price = Math.random();
            Book book = new Book.Builder()
                    .id(random.nextLong())
                    .title(TITLES[index])
                    .quantity(index)
                    .price(new BigDecimal(price))
                    .totalMoney(new BigDecimal(index * price))
                    .build();
        }
        return bookList;
    }

    @Override
    public void writeHeader(Sheet sheet, int rowIndex) {

    }

    public Map<Integer, String> configHeader() {
        Map<Integer, String> headers = new HashMap<>();
        headers.put(COLUM_INDEX_ID, "Id");
        headers.put(COLUM_INDEX_TITLE, "Title");
        headers.put(COLUMN_INDEX_PRICE, "Price");
        headers.put(COLUMN_INDEX_QUANTITY, "Quantity");
        headers.put(COLUMN_INDEX_TOTAL, "Total");
        return headers;
    }

    public Map<Integer, String> configBody(Book book) {
        Map<Integer, String> bodies = new HashMap<>();
        bodies.put(COLUM_INDEX_ID, book.getId().toString());
        bodies.put(COLUM_INDEX_TITLE, book.getTitle());
        bodies.put(COLUMN_INDEX_PRICE, book.getPrice().toString());
        bodies.put(COLUMN_INDEX_QUANTITY, book.getQuantity().toString());
        bodies.put(COLUMN_INDEX_TOTAL, book.getTotalMoney().toString());
        return bodies;
    }

    public void writeHeader(Sheet sheet) {
        CellStyle cellStyle = cellStyleService.getCellStyleFromSheetForHeader(sheet);
        Row row = rowService.createRowFromSheetByIndex(sheet, ROW_HEADER_INDEX);
        Map<Integer, String> headers = configHeader();
        cellService.writeHeader(sheet, headers, ROW_HEADER_INDEX, cellStyle);
    }

    public void writeBody(Sheet sheet, List<Book> bookList) {
        for (Book book : bookList) {
            Map<Integer, String> bodies = configBody(book);
            Row rowData = sheet.createRow(rowIndex);
            rowService.writeBody(rowData, bodies);
            rowIndex++;
        }
    }

    public void writeFooter(Sheet sheet, int rowIndex) {
        Row row = rowService.createRowFromSheetByIndex(sheet, rowIndex);
        Cell cell = cellService.createCellFromRowByColumnIndexWithFormula(row, COLUMN_INDEX_TOTAL, CellType.FORMULA);
        cell.setCellFormula("SUM(E2:E6)");
    }

    private void createOutputFile(Workbook workbook, String excelPath)  {
        try(OutputStream os = new FileOutputStream(excelPath)) {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String filePath) {
        // B1. Create dummy data
        List<Book> bookList = createDummyBookData();
        // B2. Create excel file
        // B2.1 Create workbook
        Workbook workbook = workbookService.createWorkbook();
        // B2.2 Create sheet
        Sheet sheet = sheetService.createSheetFromWorkbook(workbook);
        // B2.3 Write header
        writeHeader(sheet);
        // B2.4 Write Data
        //  B2.4.1 Create row - rowDate is 1 because header is 0
        writeBody(sheet, bookList);
        // B3.1 Write footer
        writeFooter(sheet, rowIndex);
        // B4.1 Auto resize column width
        int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        columnService.autosizeColumn(sheet, numberOfColumns);
        // B5.1 Create excel
        createOutputFile(workbook, filePath);
    }

    @Override
    public void readFile(String filePath) {

    }
}