package com.yacout.seleniumUI.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yacout.seleniumUI.objects.VideoGamesPageLocators;

public class VideoGamesPage {

	private WebDriverWait wait;
	private WebDriver driver;
	private VideoGamesPageLocators videoGamesPageLocators;

	public VideoGamesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		videoGamesPageLocators =  new VideoGamesPageLocators();
	}

	// Use the input to filter results
	public void filterBy(String filter) throws InterruptedException {
		switch (filter) {
		case "Free Shipping":
			WebElement freeShipping = driver.findElement(videoGamesPageLocators.freeShippingFilter);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", freeShipping);
			break;
		case "New":
			WebElement newFilter = driver.findElement(By.xpath("//span[text()='New']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", newFilter);
			break;
		default:
			break;
		}
	}

	// Use the input to sort the results
	public void sortBy(String sort) throws InterruptedException {
		driver.findElement(videoGamesPageLocators.sortDropdown).click();
		driver.findElement(By.xpath("//li[@role='option']//a[text()='" + sort + "']")).click();
	}

	// Select Products with price less than threshold and add to cart
	public int[] selectProductsLessThan(int threshold) throws InterruptedException {
		return getElementValues(videoGamesPageLocators.itemsPrices, threshold,0,0);
	}

	// Click next page
	public void nextPage() {
		driver.findElement(videoGamesPageLocators.nextPageButton).click();
	}
	
	// Add item to cart
	public void addToCart(WebElement item) {
		item.click();
		driver.findElement(videoGamesPageLocators.addToCartButton).click();
		driver.navigate().back();
		driver.navigate().back();
	}

	// Go through results and add items less than threshold to cart
	public int[] getElementValues(String locator, int threshold,int addedItems,int totalPrice) throws InterruptedException {
		new Actions(driver).moveToElement(driver.findElement(videoGamesPageLocators.listItems)).perform();
	    List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		System.out.println(elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Checking Price >> "+elements.get(i).getText());
			if (Integer.parseInt((elements.get(i).getText()).replace(",", "")) < threshold) {
				System.out.println("Adding To Cart >> "+elements.get(i).getText());
				addToCart(elements.get(i));
				new Actions(driver).moveToElement(driver.findElement(videoGamesPageLocators.listItems)).perform();
				elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
				addedItems ++;
				totalPrice += Integer.parseInt((elements.get(i).getText()).replace(",", ""));
			}
		}
		if(addedItems == 0) {
			nextPage();
			getElementValues(locator,threshold,addedItems,totalPrice);
		}
		int[] res = {addedItems,totalPrice};
		return res;
	}
	

}
