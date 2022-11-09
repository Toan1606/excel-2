package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.IRowService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class RowService implements IRowService {

    @Override
    public Row getRowFromSheetByIndex(Sheet sheet, int rowIndex) {
        Row row = sheet.getRow(rowIndex);
        return row;
    }

    @Override
    public Row createRowFromSheetByIndex(Sheet sheet, int rowIndex) {
        Row row = sheet.createRow(rowIndex);
        return row;
    }

    @Override
    public void writeBody(Row rowData, Map<Integer, String> bodies) {
        for (Map.Entry<Integer, String> body : bodies.entrySet()) {
            Integer index = body.getKey();
            String value = body.getValue();
            Cell cell = rowData.createCell(index);
            cell.setCellValue(value);
        }
    }
}
