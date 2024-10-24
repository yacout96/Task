package com.yacout.seleniumUI.objects;

import org.openqa.selenium.By;

public class CartPageLocators {
	// Contains locators for all objects in the Cart page
	
    public final By activeCart = By.xpath("//div[@data-name='Active Items']");
    public final By cartElements = By.xpath("//div[@data-csa-c-type='item']");
    public final By totalPrice = By.xpath("//div[@id='sc-buy-box']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");
    public final By proceedToBuyButton = By.xpath("//input[@name='proceedToRetailCheckout']");
    public final By changePaymentMethodButton = By.xpath("//a[@aria-label='Change payment method']");
    public final By chooseCashPaymentRadio = By.xpath("//input[@id='pp-WlWmGd-241']");
}
