package com.example.parsing_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main() throws IOException {
        InputStream input = new FileInputStream("D:\\Test\\TestText.txt");
        int i;
        while((i=input.read())!=-1){

            System.out.print((char)i);
    }
}}
