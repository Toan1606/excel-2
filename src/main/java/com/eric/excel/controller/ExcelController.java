package com.eric.excel.controller;

import com.eric.excel.service.excel.IExcelService;
import com.eric.excel.service.excel.impl.ExcelFileService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/excel")
public class ExcelController {

    private final IExcelService excelService;

    public ExcelController(@Qualifier("excelFileService") ExcelFileService excelFileService) {
        this.excelService = excelFileService;
    }

    @GetMapping
    public ResponseEntity<String> excel() {
        return ResponseEntity.ok("Excel Rest API");
    }

    @PostMapping("/write")
    public ResponseEntity<String> workbook() {
        excelService.writeFile("/excel_file");
        return ResponseEntity.ok("Write Excel Success !!!");
    }
}
