package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;


public class XlsReader {
    public static List<outputCell> SearchEngine(FileInputStream FileStream, List<cellFinder> cellFinders) throws IOException {
        List<outputCell> outputCells = new ArrayList<>();
            Workbook workbook;
            try {
                workbook = WorkbookFactory.create(FileStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Workbook finalWorkbook = workbook;

            DataFormatter dataFormatter = new DataFormatter();

            cellFinders.stream()
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
        return (outputCells);
    }
}