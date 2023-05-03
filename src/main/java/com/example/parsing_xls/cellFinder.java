package com.example.parsing_xls;

public class cellFinder {
    private int Sheet;
    private String CellAdress;
    Type Celltype;

    public cellFinder(int sheet, String cellAdress, Type type) {
        Sheet = sheet;
        CellAdress = cellAdress;
        Celltype = type;
    }

    public Type getCelltype() {
        return Celltype;
    }

    public void setCelltype(Type celltype) {
        Celltype = celltype;
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

    enum Type {
        TOWNNAME,
        NUMOFPROPERTY,
        NUMOFTAXES
    }
}
