package com.yacout.seleniumUI.objects;

import org.openqa.selenium.By;

public class HomePageLocators {
	// Contains locators for all objects in the Home page
	
    public final By signInElement = By.id("nav-link-accountList");
    public final By signInVerificationElement = By.xpath("//div[@class='rhf-state-signin']//span[@class='action-inner']");
    public final By signInButton = By.xpath("//div[@class='rhf-state-signin']//span[@class='action-inner']");
    public final By sideMenu = By.xpath("//a[@id='nav-hamburger-menu']");
    public final By moreCategoriesButton = By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']");
    public final By videoGamesPageVerificationElement = By.xpath("//b[text()='Video Games']");
    public final By goToCartButton = By.xpath("//a[@id='nav-cart']");
}
