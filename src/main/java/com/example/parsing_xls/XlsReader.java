package com.example.parsing_xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XlsReader {
    public static void main() throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\Test\\Test.xls");

        Workbook workbook = null;
        workbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                        System.out.print(cell.getStringCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
}