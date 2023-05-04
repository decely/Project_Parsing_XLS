package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;


public class XlsReader {
    public static List<outputCell> SearchEngine(List<String> FileAddress) throws IOException {

        List<cellFinder> cellFinders = List.of(
                new cellFinder("D:\\Test\\Test2.xls",1, "E14", cellFinder.Type.TOWNNAME),
                new cellFinder("D:\\Test\\Test2.xls",2, "C28", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder("D:\\Test\\Test2.xls",2, "C36", cellFinder.Type.NUMOFTAXES),
                new cellFinder("D:\\Test\\Test2.xls",3,"C29", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder("D:\\Test\\Test2.xls",3,"C37", cellFinder.Type.NUMOFTAXES),
                new cellFinder("D:\\Test\\Test2.xls",4,"K52", cellFinder.Type.NUMOFPROPERTY),
                new cellFinder("D:\\Test\\ChildFolder\\Test3.xls",4,"K66", cellFinder.Type.NUMOFTAXES)
        );
        List<outputCell> outputCells = new ArrayList<>();
        FileAddress.forEach(filePath -> {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Workbook workbook;
            try {
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Workbook finalWorkbook = workbook;

            DataFormatter dataFormatter = new DataFormatter();

            cellFinders.stream()
                    .filter(cellFinder -> cellFinder.getFileAdress().equals(filePath))
                    .forEach(cellFinder -> {
                var x = finalWorkbook.getSheetAt(cellFinder.getSheet() - 1);
                CellReference cellReference = new CellReference(cellFinder.getCellAdress());
                Row row = x.getRow(cellReference.getRow());
                Cell cell = row.getCell(cellReference.getCol());
                String cellValue = dataFormatter.formatCellValue(cell);

                System.out.print(cellValue);

                switch (cellFinder.getCelltype()) {
                    case TOWNNAME -> System.out.println(" - название населенного пункта");
                    case NUMOFPROPERTY -> System.out.println(" - количество имущества, по которому предъявлен налог к уплате");
                    case NUMOFTAXES -> System.out.println(" - сумма налога, подлежащая уплате в бюджет");
                }
                outputCells.add(new outputCell(cellFinder.getSheet(), cellFinder.getCellAdress(), cellValue, cellFinder.getCelltype()));
            });
            System.out.println("\n" + filePath + " Read Successful \n");
        });
        return (outputCells);
    }
}