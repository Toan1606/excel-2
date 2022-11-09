package com.eric.excel.service.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface IWorkbookService {
    public Workbook createWorkbook();

    public Workbook createWorkbookFromPath(String path) throws IOException;
}
