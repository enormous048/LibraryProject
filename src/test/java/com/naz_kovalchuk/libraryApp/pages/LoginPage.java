package com.naz_kovalchuk.libraryApp.pages;

import com.naz_kovalchuk.libraryApp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"inputEmail\"]")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id=\"inputPassword\"]")
    public WebElement passwordInput;


    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;


}
