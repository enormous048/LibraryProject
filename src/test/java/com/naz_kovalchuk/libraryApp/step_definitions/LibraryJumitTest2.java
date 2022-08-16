package com.naz_kovalchuk.libraryApp.step_definitions;

import com.github.javafaker.Faker;
import com.naz_kovalchuk.libraryApp.pages.AppPage;
import com.naz_kovalchuk.libraryApp.pages.LoginPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class LibraryJumitTest2 {

    LoginPage pageObj = new LoginPage();
    AppPage appPageObj = new AppPage();


    @Test
    public void test() throws SQLException {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");

        pageObj.usernameInput.sendKeys("librarian22@library");
        pageObj.passwordInput.sendKeys("JUXl6dnx");
        pageObj.signInButton.click();

        appPageObj.booksLink.click();
        appPageObj.addBookButton.click();

        Faker faker = new Faker();
        appPageObj.inputBookName.sendKeys(faker.book().title());
        appPageObj.inputAuthorName.sendKeys(faker.book().author());
        appPageObj.inputYear.sendKeys(faker.numerify("1###"));
        appPageObj.isbnInput.sendKeys(faker.numerify("#####"));

        Select select = new Select(appPageObj.bookCategoryDropdown);
        select.selectByIndex( Integer.parseInt(faker.numerify("#")) );

        appPageObj.bookDescription.sendKeys(faker.chuckNorris().fact());
        appPageObj.bookSubmitButton.click();


        Driver.getDriver().navigate().back();

        String expected = appPageObj.bookCount.getText();
        Driver.closeDriver();



        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM books");
        resultSet.first();

        String actual = String.valueOf(resultSet.getInt(1));

        Assert.assertEquals(expected, actual);


        resultSet.close();
        statement.close();
        connection.close();

    }


}
