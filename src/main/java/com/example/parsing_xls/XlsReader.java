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
        //Подключение к базе данных
        DatabaseWriter.main();

        List<cellFinder> cellFinders = List.of(
                new cellFinder(1, "E14", cellFinder.Type.TOWNNAME),
                new cellFinder(2, "C28", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder(2, "C36", cellFinder.Type.NUMOFTAXES),
                new cellFinder(3,"C29", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder(3,"C37", cellFinder.Type.NUMOFTAXES),
                new cellFinder(4,"K52", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder(4,"K66", cellFinder.Type.NUMOFTAXES)
        );
        FileInputStream inputStream = new FileInputStream("D:\\Test\\Test2.xls");
        Workbook workbook = null;
        workbook = WorkbookFactory.create(inputStream);

        //Начальное положение итератора листов

        DataFormatter dataFormatter = new DataFormatter();

        Workbook finalWorkbook = workbook;
        cellFinders.forEach(cellFinder -> {
            var x = finalWorkbook.getSheetAt(cellFinder.getSheet()-1);
            CellReference cellReference = new CellReference(cellFinder.getCellAdress());
            Row row = x.getRow(cellReference.getRow());
            Cell cell = row.getCell(cellReference.getCol());
            String cellValue = dataFormatter.formatCellValue(cell);

            System.out.print(cellValue);

            switch(cellFinder.getCelltype()){
                case TOWNNAME -> {
                    System.out.println(" - название населенного пункта");
                }
                case NUMOFPROPERTY -> {
                    System.out.println(" - количество имущества, по которому предъявлен налог к уплате");
                }
                case NUMOFTAXES -> {
                    System.out.println(" - сумма налога, подлежащая уплате в бюджет");
                }
            }
            DatabaseWriter.outputCells.add(new outputCell(cellFinder.getSheet(),cellFinder.getCellAdress(),cellValue,cellFinder.getCelltype()));
            System.out.println("Successfully added cell to output");
        });
        DatabaseWriter.QueryExecute();
    }
}