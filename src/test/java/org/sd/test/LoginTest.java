package org.sd.test;


import org.sd.baseTest.BaseTest;

import org.sd.driverFactory.Base;
import org.sd.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        System.out.println("The thread ID  is "+ Thread.currentThread().getId());
        loginPage.login("yourusername", "yourpassword");
        System.out.println(getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(),"Swag Labs");
        // Add assertions or further test steps

    }

}
