package com.example.parsing_xls;

public class outputCell {
    private String FileAdress;
    private int Sheet;
    private String CellAdress;
    private String CellValue;
    cellFinder.Type Celltype;

    public outputCell(String fileAdress, int sheet, String cellAdress, String cellValue, cellFinder.Type celltype) {
        FileAdress = fileAdress;
        Sheet = sheet;
        CellAdress = cellAdress;
        CellValue = cellValue;
        Celltype = celltype;
    }

    public String getFileAdress() {
        return FileAdress;
    }

    public void setFileAdress(String fileAdress) {
        FileAdress = fileAdress;
    }

    public int getSheet() {
        return Sheet;
    }

    public void setSheet(int sheet) {
        Sheet = sheet;
    }

    public String getCellAdress() {
        return CellAdress;
    }

    public void setCellAdress(String cellAdress) {
        CellAdress = cellAdress;
    }

    public String getCellValue() {
        return CellValue;
    }

    public void setCellValue(String cellValue) {
        CellValue = cellValue;
    }

    public cellFinder.Type getCelltype() {
        return Celltype;
    }

    public void setCelltype(cellFinder.Type celltype) {
        Celltype = celltype;
    }
}
