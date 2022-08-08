package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.AppPage;
import com.naz_kovalchuk.libraryApp.utility.Driver;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPage_stepDefinitions {


    AppPage pageObj = new AppPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://library2.cydeo.com/login.html");
    }


    @When("user enters librarian username {string}")
    public void user_enters_librarian_username(String string) {
        pageObj.usernameInput.sendKeys(string);
    }
    @When("user enters librarian password {string}")
    public void user_enters_librarian_password(String string) {
        pageObj.passwordInput.sendKeys(string);
    }



    @When("user enters student username {string}")
    public void user_enters_student_username(String string) {
        pageObj.usernameInput.sendKeys(string);
    }
    @When("user enters student password {string}")
    public void user_enters_student_password(String string) {
        pageObj.passwordInput.sendKeys(string);
    }


    @Then("user should see the dashboard")
    public void userLibrarian_should_see_the_dashboard() {
        pageObj.signInButton.click();

        Assert.assertTrue(pageObj.board.isDisplayed());


    }




}
