package org.sd.test.generalisedTestCases;


import org.sd.baseTest.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(enabled = false, description = "Login Feature-Negative Case")
    public void testLogin() throws InterruptedException {
       /* LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .login("124", "1234");
        Assert.assertEquals(getDriver().getTitle(), "123");*/
        //System.out.println(loginPage.verifyProductIsDisplayed());
    }
}
