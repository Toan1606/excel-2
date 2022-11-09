package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.ISheetService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service
public class SheetService implements ISheetService {
    @Override
    public Sheet createSheetFromWorkbook(Workbook workbook) {
        Sheet sheet = workbook.createSheet();
        return sheet;
    }

    @Override
    public Sheet createSheetFromWorkbookByName(Workbook workbook, String sheetName) {
        Sheet sheet = workbook.createSheet(sheetName);
        return sheet;
    }

    @Override
    public Sheet getSheetFromWorkbookByIndex(Workbook workbook, int sheetIndex) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        return sheet;
    }
}
