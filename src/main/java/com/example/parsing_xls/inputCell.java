package com.example.parsing_xls;

public class inputCell {
    private String FileAdress;
    private int Sheet;
    private String CellAdress;
    cellFinder.Type Celltype;

    public inputCell(String fileAdress, int sheet, String cellAdress, cellFinder.Type celltype) {
        FileAdress = fileAdress;
        Sheet = sheet;
        CellAdress = cellAdress;
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


    public cellFinder.Type getCelltype() {
        return Celltype;
    }

    public void setCelltype(cellFinder.Type celltype) {
        Celltype = celltype;
    }
}
