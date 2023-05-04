package com.example.parsing_xls;

import java.util.ArrayList;
import java.util.List;

public class FormingCellFinder {

    public static List<cellFinder> form(List<inputCell> input, String x) {
        List<cellFinder> cellFinders = new ArrayList<>();
        input.stream()
                .filter(inputCell -> inputCell.getFileAdress().equals(x))
                .forEach(inputCell -> {
                    cellFinders.add(new cellFinder(inputCell.getSheet(),inputCell.getCellAdress(),inputCell.getCelltype()));
                });
        return cellFinders;
    }
}
