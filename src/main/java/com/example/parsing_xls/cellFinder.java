package com.example.parsing_xls;

public class cellFinder {
    private int Sheet;
    private String CellAdress;

    public cellFinder(int sheet, String cellAdress) {
        Sheet = sheet;
        CellAdress = cellAdress;
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
}
