package com.naz_kovalchuk.libraryApp.step_definitions;

import com.naz_kovalchuk.libraryApp.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Columns_stepDefinitions {

    UsersPage pageObj = new UsersPage();


    @Given("I click on Users link")
    public void i_click_on_users_link() {
        pageObj.usersLink.click();
    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedHeaders) {

        List<String> actualHeaders = new ArrayList<>();

        for (WebElement columnHeader : pageObj.columnHeaders) {
            actualHeaders.add(columnHeader.getText());
        }

        Assert.assertEquals(expectedHeaders, actualHeaders);


    }


}
