package org.sd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sd.driverFactory.Base;

import static org.sd.extentReport.ExtentListeners.testReport;


public class LoginPage extends Base {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackProduct;

    /*public LoginPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }*/

    // Method to perform login
    public void login(String username, String password) {
        Type(usernameInput, username);
        Type(passwordInput, password);
        clickElement(loginButton);
        testReport.get().info("Successfully LoggedIn to App");
    }

    public boolean verifyProductIsDisplayed(){
        return sauceLabsBackpackProduct.isDisplayed();
    }
}
