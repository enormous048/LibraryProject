package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.SpartanFirstPage;
import com.naz_kovalchuk.libraryApp.pages.SpartanMainPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import java.sql.*;

public class SpartanJunitTest {




    @Test
    public void test() throws SQLException {
        SpartanFirstPage pageObj = new SpartanFirstPage();
        SpartanMainPage mainpageObj = new SpartanMainPage();


        //This part is to get number of spartans from UI
        Driver.getDriver().get("http://3.87.108.86:8000/");
        pageObj.webDataLink.click();
        mainpageObj.nameInput.sendKeys("a");
        Select select = new Select(mainpageObj.dropdownGender);
        select.selectByIndex(1);
        mainpageObj.searchButton.click();



        String expected = mainpageObj.searchResult.getText();
        expected = expected.substring(expected.lastIndexOf(":")+2);

        Driver.closeDriver();


        //This part is to get number of spartans from DataBase
        String url = "jdbc:oracle:thin:@3.87.108.86:1521:XE";
        String username = "SP";
        String password = "SP";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM SPARTANS WHERE GENDER = 'Male' AND LOWER(NAME) LIKE '%a%'");
        resultSet.first();



        String actual = String.valueOf( resultSet.getInt(1) );
        Assert.assertEquals(expected, actual);

        System.out.println("Test passed.\n" +
                "Expected: "+ expected + "\nActual: "+ actual);


        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test2() throws SQLException {
        SpartanFirstPage pageObj = new SpartanFirstPage();
        SpartanMainPage mainpageObj = new SpartanMainPage();
        //This part is to get number of spartans from UI
        Driver.getDriver().get("http://3.87.108.86:8000/");
        pageObj.webDataLink.click();
        mainpageObj.nameInput.sendKeys("a");
        Select select = new Select(mainpageObj.dropdownGender);
        select.selectByIndex(2);
        mainpageObj.searchButton.click();



        String expected = mainpageObj.searchResult.getText();
        expected = expected.substring(expected.lastIndexOf(":")+2);

        Driver.closeDriver();


        //This part is to get number of spartans from DataBase
        String url = "jdbc:oracle:thin:@3.87.108.86:1521:XE";
        String username = "SP";
        String password = "SP";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM SPARTANS WHERE GENDER = 'Female' AND LOWER(NAME) LIKE '%a%'");
        resultSet.first();



        String actual = String.valueOf( resultSet.getInt(1) );
        Assert.assertEquals(expected, actual);

        System.out.println("Test passed.\n" +
                "Expected: "+ expected + "\nActual: "+ actual);
    }

}
