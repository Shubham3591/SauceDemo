package org.sd.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.sd.extentReport.ExtentListeners.testReport;

public class Base {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }

    protected void launchApp(String browserName) {
        // String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver.set(new InternetExplorerDriver());
        }
        //Maximize the screen
        getDriver().manage().window().maximize();
        //Delete all the cookies
        getDriver().manage().deleteAllCookies();
        //Implicit TimeOuts
        getDriver().get("https://www.saucedemo.com/v1/index.html");
    }


    public static void click(WebElement Element) {
        wait(Element);
        Element.click();
        testReport.get().info("Clicked on " +Element.getAccessibleName());
    }

    public static void Type(WebElement Element, String sendKeyData) {
        wait(Element);
        Element.clear();
        Element.sendKeys(sendKeyData);
        testReport.get().info("Typed " +sendKeyData+" on " +Element.getAccessibleName());
    }

    public static void wait(WebElement Element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Element));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }
}
