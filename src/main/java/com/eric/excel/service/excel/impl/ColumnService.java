package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.IColumnService;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

@Service
public class ColumnService implements IColumnService {
    @Override
    public Column createColumn() {
        return null;
    }

    @Override
    public void autosizeColumn(Sheet sheet, int numberOfColumns) {
        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex ++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
}
