package com.cydeo.pages;



import com.trycloud.utilities.ConfigurationReader;
import java.sql.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-for")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;


    public void login(){
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginButton.click();
    }

    public void login(String username,String password){

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);

    }




}
