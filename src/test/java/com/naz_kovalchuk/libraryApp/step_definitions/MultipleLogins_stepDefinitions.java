package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.AppPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MultipleLogins_stepDefinitions {

    AppPage pageObj = new AppPage();
    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedHolder) throws InterruptedException {

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait( Driver.getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(pageObj.userNameOnTop, expectedHolder));


        String actualHolder = pageObj.userNameOnTop.getText();
        System.out.println(actualHolder);
        Assert.assertEquals(expectedHolder, actualHolder);



    }
}
