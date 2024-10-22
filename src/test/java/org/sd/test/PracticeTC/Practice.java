package org.sd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Practice {

    @Test
    public void checkBrokenLinks() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        int responseCode;
        int brokenLinkCount = 0;

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No. of Links " + links.size());

        for (WebElement ele : links) {
            String url = ele.getAttribute("href");

            URL u = new URL(url);

            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.connect();

            responseCode = huc.getResponseCode();

            if (responseCode >= 400) {
                System.out.println(url);
                brokenLinkCount++;
            }
        }
        System.out.println(brokenLinkCount);
        driver.close();

    }


    @Test
    public void googleSearchTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("APjFqb")).sendKeys("Testing");
        Thread.sleep(3000);
        List<WebElement> lst = driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));

        for (WebElement ele : lst) {
            if (ele.getText().equalsIgnoreCase("testing types")) {
                ele.click();
                break;
            }
        }
        driver.close();
    }


    @Test
    public static void Test123() {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Select s = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

        List<WebElement> lst = s.getOptions();

        for (WebElement ele : lst) {
            System.out.println(ele.getText());

            if (ele.getText().equalsIgnoreCase("Price (low to high)")) {
                ele.click();
                break;
            }
        }

    }

    /**
     *
     */

    @Test
    public void addLargestPriceItemInCart(){
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> AllPricelist= driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double largePrice=0;

        for(WebElement ele: AllPricelist){

            double price= Double.parseDouble(ele.getText().replace('$', ' '));

            if(price>largePrice){
                largePrice=price;
            }
        }
        System.out.println(largePrice);

        String xpath="//div[normalize-space()='$"+largePrice+"']/following-sibling::button[text()='Add to cart']";
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("successfully clicked");
    }
}
