package com.yacout.seleniumUI.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yacout.seleniumUI.objects.HomePageLocators;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private HomePageLocators homePageLocators;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		homePageLocators = new HomePageLocators();

	}


	// Go to sign in at the buttom of the page and click on it
	public void goToSignIn() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(homePageLocators.signInVerificationElement));
		WebElement accountPage = driver
				.findElement(homePageLocators.signInButton);
		accountPage.click();
	}

	// Go to a the category taken as a variable
	public void goToCategory(String category) throws InterruptedException {
		driver.findElement(homePageLocators.sideMenu).click();
		driver.findElement(homePageLocators.moreCategoriesButton).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='hmenu-item']//div[text()='" + category + "']")));
		driver.findElement(By.xpath("//a[@class='hmenu-item']//div[text()='" + category + "']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='hmenu-item' and text()='All " + category + "']")));

		WebElement allValues = driver
				.findElement(By.xpath("//a[@class='hmenu-item' and text()='All " + category + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", allValues);

		wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLocators.videoGamesPageVerificationElement));
	}

	// Click on the cart
	public void goToCart() {
		driver.findElement(homePageLocators.goToCartButton).click();
	}
}