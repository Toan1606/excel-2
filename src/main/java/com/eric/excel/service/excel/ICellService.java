package com.eric.excel.service.excel;

import org.apache.poi.ss.usermodel.*;

import java.util.Map;

public interface ICellService {

    public Cell createCellFromRowByColumIndex(Row row, int columnIndex);

    public Cell getCellFromRowByColumnIndex(Row row, int columnIndex);

    public Cell createCellFromRowByColumnIndexWithFormula(Row row, int columnIndex, CellType cellType);

    public void writeHeader(Sheet sheet, Map<Integer, String> headers, int ROW_HEADER_INDEX, CellStyle cellStyle);
}
