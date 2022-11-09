package com.eric.excel.service.excel.impl;

import com.eric.excel.service.excel.IWorkbookService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WorkbookService implements IWorkbookService {
    @Override
    public Workbook createWorkbook() {
        Workbook workbook = new XSSFWorkbook();
        return workbook;
    }

    @Override
    public Workbook createWorkbookFromPath(String path) throws IOException {
        Workbook workbook = new XSSFWorkbook(path);
        return workbook;
    }
}
