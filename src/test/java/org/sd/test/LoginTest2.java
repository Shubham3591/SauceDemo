package org.sd.test;

import org.sd.baseTest.BaseTest;
import org.sd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest {



    @Test
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
       // System.out.println("The thread ID  is "+ Thread.currentThread().getId());
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);
        Assert.assertEquals(getDriver().getTitle(), "Swag Labs");
        System.out.println(loginPage.verifyProductIsDisplayed());


        // Add assertions or further test steps

    }

}
