package com.naz_kovalchuk.libraryApp.pages;

import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartanFirstPage {


    public SpartanFirstPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//i[@class=\"fas fa-users\"]")
    public WebElement webDataLink;

}
