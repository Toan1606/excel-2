package com.eric.excel.service.excel;

import com.eric.excel.model.Book;
import com.eric.excel.service.IFileService;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public interface IExcelService extends IFileService {

    public List<Book> createDummyBookData();

    public void writeHeader(Sheet sheet, int rowIndex);

}
