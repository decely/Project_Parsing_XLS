package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;


public class XlsReader {
    public static void main() throws IOException {

        //Чтение файла с помощью Workbook
        FileInputStream inputStream = new FileInputStream("D:\\Test\\Test2.xls");
        Workbook workbook = null;
        workbook = WorkbookFactory.create(inputStream);
        //Workbook workbook = new XSSFWorkbook(inputStream);
        //Объявление итератора листов
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();

        //Начальное положение итератора листов
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nЧтение файла XLS через итератор\n");

        //Цикл чтения листов
        while (sheetIterator.hasNext()) {
            sheet = sheetIterator.next();
            Iterator<Row> rowIterator = sheet.rowIterator();
            System.out.println("=> " + sheet.getSheetName());

            //Цикл чтения строк
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

            //Цикл чтения ячеек
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);

                    //Вывод прочитанной ячейки в консоль
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }
        }
    }
}