package com.naz_kovalchuk.libraryApp.pages;

import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpartanMainPage {

    public SpartanMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"name\"]")
    public WebElement nameInput;


    @FindBy(xpath = "//select[@id=\"gender\"]")
    public WebElement dropdownGender;

    @FindBy(xpath = "//button[@id=\"search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@id=\"total_up_count\"]")
    public WebElement searchResult;
}
