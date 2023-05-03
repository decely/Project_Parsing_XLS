package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;


public class XlsReader {
    public static void SearchEngine() throws IOException {
        List<cellFinder> cellFinders = List.of(
                new cellFinder(1, "E14"),
                new cellFinder(2, "C28"),
                new cellFinder(2, "C36"),
                new cellFinder(3,"C29"),
                new cellFinder(3,"C37"),
                new cellFinder(4,"K52"),
                new cellFinder(4,"K66")
        );
        FileInputStream inputStream = new FileInputStream("D:\\Test\\Test2.xls");
        Workbook workbook = null;
        workbook = WorkbookFactory.create(inputStream);
        //Workbook workbook = new XSSFWorkbook(inputStream);
        //Объявление итератора листов
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();

        //Начальное положение итератора листов
        final Sheet[] sheet = {workbook.getSheetAt(0)};

        DataFormatter dataFormatter = new DataFormatter();

        Workbook finalWorkbook = workbook;
        cellFinders.forEach(cellFinder -> {
            sheet[0] = finalWorkbook.getSheetAt(cellFinder.getSheet()-1);
            CellReference cellReference = new CellReference(cellFinder.getCellAdress());
            Row row = sheet[0].getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());
            String cellValue = dataFormatter.formatCellValue(cell);
            System.out.println(cellValue);
        });
    }
}