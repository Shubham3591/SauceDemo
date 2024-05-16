package org.sd.test.generalisedTestCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.sd.baseTest.BaseTest;
import org.sd.utilities.utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseTest {


    @DataProvider
    public Object[][] getLoginTestData() throws InvalidFormatException {
        Object data[][] = utils.getTestData("LoginCredentials");
        return data;
    }


    @Test(enabled = false, dataProvider ="getLoginTestData", description = "Login Feature-Positive Case")
    public void testLogin(String username, String Password) throws InterruptedException {
       /* LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, Password);
        Assert.assertEquals(getDriver().getTitle(), "Swag Labs");
        System.out.println(loginPage.verifyProductIsDisplayed());*/
        // Add assertions or further test steps
    }
}
