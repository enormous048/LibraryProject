package com.naz_kovalchuk.libraryApp.utility;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    // Workbook > Worksheet > Raw > Cell

    // XSSFWorkbook > XSSFSheet > XSSFRaw > XSSFCell


    public static void main(String[] args) throws IOException {

        String path = "SampleData.xlsx";

        //To read a file we nned to load it to file input stream
        FileInputStream file = new FileInputStream(path);

        //Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Create a sheet
        XSSFSheet sheet = workbook.getSheet("Employees");

        //To access cells, firstly go to raw than cells  //Indexes start from zero
        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(1).getCell(1));



        //Tells number of raws in worksheet( size() ), нормальний рахунок від 1, Empty raws are excluded.
        int countRaws = sheet.getPhysicalNumberOfRows();
        System.out.println("countRaws = " + countRaws);

        //Starts from 0, empty raws are included.
        int lastRaw = sheet.getLastRowNum();
        System.out.println("Last Row num "+lastRaw);

        //Нормальний рахунок від 1, Empty cells are excluded.
        int countCells = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("countCells = " + countCells);

        //Нормальний рахунок від 1, Empty cells are included.
        int lastCell = sheet.getRow(0).getLastCellNum();
        System.out.println("lastCell = " + lastCell);



        for (int rowNum = 0; rowNum<=countRaws-1; rowNum++){

            for (int cellNum = 0; cellNum<sheet.getRow(rowNum).getLastCellNum(); cellNum++){

                if(sheet.getRow(rowNum).getCell(cellNum).toString().equals("PO")){
                    System.out.println("Raw num: "+rowNum+"  |  Cell num: "+ cellNum+"  |  Result: "+sheet.getRow(rowNum).getCell(cellNum));
                }

            }

        }

        //If name is Andrew, print his job title
        for (int rowNum = 0; rowNum<=countRaws-1; rowNum++){

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Andrew")){
                System.out.println(sheet.getRow(rowNum).getCell(0+2));
            }

        }



    }

}
