package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;

public class CheckoutOverviewPage extends Base {
    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement finishButton;

    public void completeOrder(){
        clickElement(finishButton);
    }
}
