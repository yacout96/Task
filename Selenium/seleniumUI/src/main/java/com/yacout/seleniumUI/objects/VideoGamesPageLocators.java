package com.yacout.seleniumUI.objects;

import org.openqa.selenium.By;

public class VideoGamesPageLocators {
	// Contains locators for all objects in the Video Games page
	
    public final By freeShippingFilter = By.xpath("//input[@aria-labelledby='Free Shipping']");
    public final By sortDropdown = By.xpath("//span[@id='a-autoid-0-announce']");
    public final String itemsPrices = "//div[@role='listitem']//span[@class='a-price-whole']";
    public final By nextPageButton = By.xpath("//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']");
    public final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    public final By listItems = By.xpath("//div[@role='listitem']");
    public final By goToCartButton = By.xpath("//a[@id='nav-cart']");
}
