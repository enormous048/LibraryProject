package com.naz_kovalchuk.libraryApp.utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    public static int randow(int min, int max){


        return (int) (Math.random() * (max - min + 1)) + min;

    }

    public static void main(String[] args) throws IOException {


        //Make file input stream
        String path = "SampleData.xlsx";
        FileInputStream file = new FileInputStream(path);

        //Load WorkBook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get sheet
        XSSFSheet sheet = workbook.getSheet("Employees");

        //Create new cell
        XSSFCell cellNew  = sheet.getRow(0).createCell(3);
        cellNew.setCellValue("Salary");




        for (int eachRaw = 1; eachRaw<=sheet.getPhysicalNumberOfRows()-1; eachRaw++){

            XSSFCell cell = sheet.getRow(eachRaw).createCell(3);
            cell.setCellValue(randow(50000, 120000));

        }

        for (int eachRaw = 0; eachRaw<=sheet.getLastRowNum(); eachRaw++){
            if (sheet.getRow(eachRaw).getCell(0).toString().equals("Max")){

                XSSFCell surname = sheet.getRow(eachRaw).createCell(1);
                surname.setCellValue("Brothers");
                //OR
                sheet.getRow(eachRaw).getCell(1).setCellValue("Brothers2");

            }
        }



        //SAVE CHANGES

        //Write to excel file
        FileOutputStream outFile = new FileOutputStream(path);
        workbook.write(outFile);

        //Close streams
        file.close();
        outFile.close();
        workbook.close();
    }

}
