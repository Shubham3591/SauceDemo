package org.sd.driverFactory;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.sd.extentReport.ExtentListeners.testReport;


public class Base {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Faker faker = new Faker();




    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
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
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        getDriver().get("https://www.saucedemo.com/v1/index.html");

    }


    public void clickElement(WebElement Element) {
        wait(Element);
        testReport.get().info("Click :: " + Element.getAccessibleName() + " ");
        Element.click();
    }

    public void Type(WebElement Element, String sendKeyData) {
        wait(Element);
        Element.clear();
        Element.sendKeys(sendKeyData);
        testReport.get().info("Enter :: " + sendKeyData + " on " + Element.getAccessibleName()+" field");
    }

    public void wait(WebElement Element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Element));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void readText(WebElement Element){
        wait(Element);
        Element.getText();
        testReport.get().info("Element displayed is "+Element.getText());
    }

}
