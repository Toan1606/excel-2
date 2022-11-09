package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.ICellService;
import com.eric.excel.service.excel.ICellStyleService;
import com.eric.excel.service.excel.IRowService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CellService implements ICellService {

    private final IRowService rowService;

    public CellService(@Qualifier("rowService") RowService rowService) {
        this.rowService = rowService;
    }

    @Override
    public Cell createCellFromRowByColumIndex(Row row, int columnIndex) {
        Cell cell = row.createCell(columnIndex);
        return cell;
    }

    @Override
    public Cell getCellFromRowByColumnIndex(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return cell;
    }

    @Override
    public Cell createCellFromRowByColumnIndexWithFormula(Row row, int columnIndex, CellType cellType) {
        Cell cell = row.createCell(columnIndex, CellType.FORMULA);
        return cell;
    }

    @Override
    public void writeHeader(Sheet sheet, Map<Integer, String> headers, final int ROW_HEADER_INDEX, CellStyle cellStyle) {
        Row row = rowService.createRowFromSheetByIndex(sheet, ROW_HEADER_INDEX);
        for (Map.Entry<Integer, String> header : headers.entrySet()) {
            Integer columnIndex = header.getKey();
            String rowName = header.getValue();
            Cell cell = row.createCell(columnIndex);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(rowName);
        }
    }
}
