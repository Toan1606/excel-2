package com.eric.excel.service.excel;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Sheet;

public interface IColumnService {
    public Column createColumn();

    void autosizeColumn(Sheet sheet, int numberOfColumns);
}
