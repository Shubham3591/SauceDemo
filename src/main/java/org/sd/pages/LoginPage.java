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

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackProduct;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    // Method to perform login
    public void login(String username, String password) throws InterruptedException {
        getDriver().navigate().refresh();
        Type(usernameInput, username);
        Type(passwordInput, password);

        click(loginButton);
    }

    public boolean verifyProductIsDisplayed(){
        return sauceLabsBackpackProduct.isDisplayed();
    }
}
