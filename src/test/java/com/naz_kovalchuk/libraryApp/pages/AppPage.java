package com.naz_kovalchuk.libraryApp.pages;

import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppPage extends LoginPage{


    public AppPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"navbar-brand\"]")
    public WebElement board;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashBoardLink;

    @FindBy(xpath = "//h2[.='660']")
    public WebElement usersCount;

    @FindBy(xpath = "//a[@id=\"navbarDropdown\"]/span")
    public WebElement userNameOnTop;

}
