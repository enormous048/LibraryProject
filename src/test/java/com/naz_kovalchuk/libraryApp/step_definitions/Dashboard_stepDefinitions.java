package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.AppPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_stepDefinitions {

    AppPage pageObj = new AppPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
    }
    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        pageObj.usernameInput.sendKeys(username);
        pageObj.passwordInput.sendKeys(password);

        pageObj.signInButton.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        Assert.assertTrue(pageObj.board.isDisplayed());
    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        String actualUserCount = pageObj.usersCount.getText().toString();
        String expectedUserCount = int1+"";

        Assert.assertEquals(expectedUserCount, actualUserCount);
    }


}
