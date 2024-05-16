package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;

public class CheckoutInfoPage extends Base {

    public CheckoutInfoPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@class='btn_primary cart_button' and @value='CONTINUE']")
    private WebElement continueButton;

    public void fillCheckoutDetails(){
        Type(firstName, faker.name().firstName());
        Type(lastName, faker.name().lastName());
        Type(postalCode, faker.address().zipCode());
        clickElement(continueButton);
    }
}
