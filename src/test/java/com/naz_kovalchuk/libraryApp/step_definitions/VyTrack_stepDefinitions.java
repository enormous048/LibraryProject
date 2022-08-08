package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.VyTackLoginPage;
import com.naz_kovalchuk.libraryApp.pages.VyTrackMainPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VyTrack_stepDefinitions {


    VyTrackMainPage pageObj2 = new VyTrackMainPage();
    VyTackLoginPage pageObj = new VyTackLoginPage();

    @Given("User is on VyTrack login page")
    public void user_is_on_vy_track_login_page() {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    }

    @Then("User logins with different data, sees expected name and surname, logouts")
    public void user_logins_with_different_data_sees_expected_name_and_surname_logouts() throws IOException, InterruptedException {
        FileInputStream file =new FileInputStream("TestData.xlsx");

        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet("data");



        for(int eachRow = 1; eachRow<=sheet.getLastRowNum(); eachRow++){

            String username = sheet.getRow(eachRow).getCell(0).toString();
            String password = sheet.getRow(eachRow).getCell(1).toString();
            try {
                pageObj.login(username, password);

            }catch (NoSuchElementException e){}



            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            wait.until(ExpectedConditions.attributeToBe(pageObj2.loaderToBeInvisible, "class", "loader-mask"));



            String expectedFullname = sheet.getRow(eachRow).getCell(2).toString() +" "+sheet.getRow(eachRow).getCell(3).toString();
            expectedFullname = expectedFullname.trim();

            String actualFullname = pageObj2.nameSurname.getText();

            if (actualFullname.equals(expectedFullname)){
                System.out.println("PASSED");
            }else {
                System.out.println("FAILED: actual: \""+actualFullname+"\" | expected: \""+expectedFullname +"\"");
            }



            pageObj2.nameSurname.click();
            wait.until(ExpectedConditions.elementToBeClickable(pageObj2.logoutButton));
            pageObj2.logoutButton.click();

            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

    }

}
