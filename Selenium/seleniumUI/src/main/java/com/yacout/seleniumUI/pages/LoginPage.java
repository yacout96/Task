package com.yacout.seleniumUI.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yacout.seleniumUI.objects.LoginPageLocators;

public class LoginPage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private LoginPageLocators loginPageLocators;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		loginPageLocators =  new LoginPageLocators();
	}
	
	// Sign in with emai and password taken, then verify name appears after login
	public void signIn(String email,String password, String name) {
		WebElement emailLoc = driver.findElement(loginPageLocators.emailField);
		
		wait.until(ExpectedConditions.visibilityOf(emailLoc));
		emailLoc.sendKeys(email);
		emailLoc.sendKeys(Keys.ENTER);
		
		WebElement passwordLoc = driver.findElement(loginPageLocators.passwordField);
		wait.until(ExpectedConditions.visibilityOf(passwordLoc));
		passwordLoc.sendKeys(password);
		passwordLoc.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1' and contains(text(),'"+ name +"')]"))));
	}

}
