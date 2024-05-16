package org.sd.test.productTestCases;

import org.sd.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.sd.extentReport.ExtentListeners.testReport;

public class Tshirt_TC extends BaseTest {
    
    @Test(description = "T-Shirt order")
    public void verifyT_Shirt_TC(){
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddTShirtProductToCart();
        yourCartPage.checkOutOrder();
        checkoutInfoPage.fillCheckoutDetails();
        checkoutOverviewPage.completeOrder();
        Assert.assertTrue(orderCompletePage.verifyOrderCompletion());
        testReport.get().info("TShirt ordered Successfully");
    }
}
