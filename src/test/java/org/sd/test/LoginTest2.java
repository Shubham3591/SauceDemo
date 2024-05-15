package org.sd.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.sd.baseTest.BaseTest;
import org.sd.pages.LoginPage;
import org.sd.utilities.utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest {


    @DataProvider()
    public Object[][] getLoginTestData() throws InvalidFormatException {
        Object data[][] = utils.getTestData("LoginCredentials");
        return data;
    }

    @Test(  dataProvider = "getLoginTestData", description = "Login Feature-dataProvider Case")
    public void testLogin(String username, String Password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        // System.out.println("The thread ID  is "+ Thread.currentThread().getId());
        loginPage.login(username,Password);
        Assert.assertEquals(getDriver().getTitle(), "Swag Labs");
        System.out.println(loginPage.verifyProductIsDisplayed());
        // Add assertions or further test steps
    }

}
