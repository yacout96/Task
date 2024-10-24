package com.yacout.seleniumUI.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.yacout.seleniumUI.objects.CartPageLocators;

public class CartPage {

	private WebDriverWait wait;
	private WebDriver driver;
	private CartPageLocators cartPageLocators;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		cartPageLocators = new CartPageLocators();
	}

	// Verify Elements in cart are same number or more than that added in previous steps
	public void checkAddedItems(int number) {
		new Actions(driver).moveToElement(driver.findElement(cartPageLocators.activeCart)).perform();
		List<WebElement> elements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartPageLocators.cartElements));
		System.out.println("Number of Added Items are >> " + elements.size());
		Assert.assertTrue(elements.size() >= number);
	}

	// Verify total price in cart is same or more than total of the items added in previous steps
	public void checkTotalPrice(int price) {
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='sc-buy-box']"))).perform();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(cartPageLocators.totalPrice));
		System.out.println("Total Price is >>" + element.getText());
		Assert.assertTrue(Float.parseFloat((element.getText()).replace("EGP ", "").replace(",", "")) >= price);
	}

	// Click proceed to buy
	public void proceedToBuy() {
		driver.findElement(cartPageLocators.proceedToBuyButton).click();
	}

	// Change to payment method
	public void changePaymentMethod(String type) {
		driver.findElement(cartPageLocators.changePaymentMethodButton).click();
		switch(type) {
		case "Cash":
			driver.findElement(cartPageLocators.chooseCashPaymentRadio).click();
			break;
		default:
			break;
		}
	}

}
