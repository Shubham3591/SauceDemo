package org.sd.baseTest;

import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;
import org.sd.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Base {

    public  org.sd.pages.LoginPage loginPage;
    public  org.sd.pages.ProductsPage productsPage;
    public  org.sd.pages.CheckoutInfoPage checkoutInfoPage;
    public  org.sd.pages.CheckoutOverviewPage checkoutOverviewPage;
    public  org.sd.pages.OrderCompletePage orderCompletePage;
    public  org.sd.pages.YourCartPage yourCartPage;

    @BeforeClass
    public void setUp() {
        launchApp("Chrome");
        PageFactoryInit();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        unload();
    }


    protected void PageFactoryInit () {

        loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
        checkoutInfoPage = PageFactory.initElements(getDriver(), CheckoutInfoPage.class);
        checkoutOverviewPage = PageFactory.initElements(getDriver(), CheckoutOverviewPage.class);
        orderCompletePage = PageFactory.initElements(getDriver(), OrderCompletePage.class);
        productsPage = PageFactory.initElements(getDriver(), ProductsPage.class);
        yourCartPage = PageFactory.initElements(getDriver(), YourCartPage.class);
    }
}
