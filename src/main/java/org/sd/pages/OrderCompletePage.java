package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;

public class OrderCompletePage extends Base {

    @FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
    private WebElement completionText;


    public OrderCompletePage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean verifyOrderCompletion() {
        String expectedText = completionText.getText();

        return completionText.isDisplayed();
    }


}
