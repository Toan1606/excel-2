package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.ICellStyleService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

@Service
public class CellStyleService implements ICellStyleService {

    public Font getFontForCellStyle(Sheet sheet) {
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());
        return font;
    }

    public short getColorHeaderForCellStyle() {
        return IndexedColors.BLUE.getIndex();
    }

    public short getColorBodyForCellStyle() {
        return IndexedColors.WHITE.getIndex();
    }

    public BorderStyle getBorderForCellStyle() {
        return BorderStyle.THIN;
    }

    public FillPatternType getFillPatternType() {
        return FillPatternType.SOLID_FOREGROUND;
    }

    public CellStyle getCommonCellStyle(Sheet sheet) {
        // 1. get cell style
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        // 2. get properties
        //  2.1 get font
        Font font = getFontForCellStyle(sheet);

        //  2.2 get border
        FillPatternType fillPatternType = getFillPatternType();
        //  2.3 get fill pattern type
        BorderStyle borderStyle = getBorderForCellStyle();

        // 3. set properties
        //  3.1 set font
        cellStyle.setFont(font);

        //  3.2 set pattern
        cellStyle.setFillPattern(fillPatternType);
        //  3.3 set border bottom
        cellStyle.setBorderBottom(borderStyle);
        return cellStyle;
    }

    @Override
    public CellStyle getCellStyleFromSheetForHeader(Sheet sheet) {
        // 1. get cell style
        CellStyle cellStyle = getCommonCellStyle(sheet);
        // 2. get color
        short color = getColorHeaderForCellStyle();
        // 3. set color
        cellStyle.setFillBackgroundColor(color);
        return cellStyle;
    }

    @Override
    public CellStyle getCellStyleFromSheet(Sheet sheet) {
        // 1. get cell style
        CellStyle cellStyle = getCommonCellStyle(sheet);
        // 2. get color
        short color = getColorBodyForCellStyle();
        // 3. set color
        cellStyle.setFillBackgroundColor(color);
        return cellStyle;
    }
}
