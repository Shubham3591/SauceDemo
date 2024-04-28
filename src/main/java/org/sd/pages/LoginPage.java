package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;


public class LoginPage extends Base {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    // Method to perform login
    public void login(String username, String password) {
        Type(usernameInput, username);
        Type(passwordInput, password);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(loginButton);
    }
}
