package org.sd.test;


import org.sd.baseTest.BaseTest;

import org.sd.driverFactory.Base;
import org.sd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("124", "1234");
        Assert.assertEquals(getDriver().getTitle(), "123");
        //System.out.println(loginPage.verifyProductIsDisplayed());
    }


}
