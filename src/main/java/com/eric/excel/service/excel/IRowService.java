package com.eric.excel.service.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Map;

public interface IRowService {
    public Row getRowFromSheetByIndex(Sheet sheet, int rowIndex);

    public Row createRowFromSheetByIndex(Sheet sheet, int rowIndex);

    void writeBody(Row rowData, Map<Integer, String> bodies);
}
