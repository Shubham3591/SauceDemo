package org.sd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sd.driverFactory.Base;

public class ProductsPage extends Base {

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpack;

    @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
    private WebElement tShirtProduct;


    @FindBy(xpath = "//*[text()='ADD TO CART']")
    private WebElement AddToCartButton;


    @FindBy(xpath = "//*[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='inventory_details_name']")
    private WebElement productNameText;



    public void AddSauceLabsBackpackProductToCart(){
        clickElement(sauceLabsBackpack);
        readText(productNameText);
        clickElement(AddToCartButton);
        clickElement(cartIcon);
    }

    public void AddTShirtProductToCart(){
        clickElement(tShirtProduct);
        readText(productNameText);
        clickElement(AddToCartButton);
        clickElement(cartIcon);
    }


}
