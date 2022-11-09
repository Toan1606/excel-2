package com.eric.excel.service.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;

public interface ICellStyleService {
    public CellStyle getCellStyleFromSheetForHeader(Sheet sheet);

    public CellStyle getCellStyleFromSheet(Sheet sheet);
}
