package org.sd.test.productTestCases;

import org.sd.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.sd.extentReport.ExtentListeners.testReport;

public class BackPack_TC extends BaseTest {


    @Test(description = "BackPack Order")
    public void verifyBackPack_TC() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddSauceLabsBackpackProductToCart();
        yourCartPage.checkOutOrder();
        checkoutInfoPage.fillCheckoutDetails();
        checkoutOverviewPage.completeOrder();
        Assert.assertTrue(orderCompletePage.verifyOrderCompletion());
        testReport.get().info("BackPack ordered Successfully");
    }
}
