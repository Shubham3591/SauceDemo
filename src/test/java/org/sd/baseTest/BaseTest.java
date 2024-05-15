package org.sd.baseTest;

import org.sd.driverFactory.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Base {
    @BeforeClass
    public void setUp() {
        launchApp("Chrome");
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
