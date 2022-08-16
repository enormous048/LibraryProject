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
    @FindBy(xpath = "//h2[@id=\"user_count\"]")
    public WebElement usersCount;
    @FindBy(xpath = "//h2[@id=\"book_count\"]")
    public WebElement bookCount;
    @FindBy(xpath = "//a[@id=\"navbarDropdown\"]/span")
    public WebElement userNameOnTop;






    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashBoardLink;

    @FindBy(xpath = "(//span[@class=\"title\"])[3]")
    public WebElement booksLink;


    @FindBy(xpath = "//a[@data-toggle=\"modal\"]")
    public WebElement addBookButton;

    @FindBy(xpath = "//input[@placeholder=\"Book Name\"]")
    public WebElement inputBookName;

    @FindBy(xpath = "//input[@placeholder=\"Author\"]")
    public WebElement inputAuthorName;

    @FindBy(xpath = "//input[@placeholder=\"ISBN\"]")
    public WebElement isbnInput;

    @FindBy(xpath = "//input[@placeholder=\"Year\"]")
    public WebElement inputYear;

    @FindBy(xpath = "//select[@id=\"book_group_id\"]")
    public WebElement bookCategoryDropdown;

    @FindBy(xpath = "//textarea[@id=\"description\"]")
    public WebElement bookDescription;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement bookSubmitButton;




}
