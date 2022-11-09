package com.eric.excel.service.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface ISheetService {

    public Sheet createSheetFromWorkbook(Workbook workbook);

    public Sheet createSheetFromWorkbookByName(Workbook workbook, String sheetName);

    public Sheet getSheetFromWorkbookByIndex(Workbook workbook, int sheetIndex);
}
