package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;

public class YourCartPage extends Base {

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//*[@class='btn_action checkout_button' and text()='CHECKOUT']")
    private WebElement checkoutButton;


    @FindBy(xpath = "//a[text()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[text()='REMOVE']")
    private WebElement removeButton;

    public void checkOutOrder(){
        clickElement(checkoutButton);
    }
}
