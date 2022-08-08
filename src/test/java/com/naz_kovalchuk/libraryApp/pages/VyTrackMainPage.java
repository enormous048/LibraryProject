package com.naz_kovalchuk.libraryApp.pages;

import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackMainPage{

    public VyTrackMainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[@id=\"user-menu\"]")
    public WebElement nameSurname;

    @FindBy(xpath = "//body/div[4]")
    public WebElement loaderToBeInvisible;

    @FindBy(xpath = "//a[@href=\"/user/logout\"]")
    public WebElement logoutButton;
}
