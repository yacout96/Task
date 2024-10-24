package com.yacout.seleniumUI.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yacout.seleniumUI.pages.CartPage;
import com.yacout.seleniumUI.pages.HomePage;
import com.yacout.seleniumUI.pages.LoginPage;
import com.yacout.seleniumUI.pages.VideoGamesPage;

import resources.Utilities;


public class AmazonTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private VideoGamesPage videoGamesPage;
    private CartPage cartPage;
    private String baseURL, email, name, password, browser;

    @BeforeTest // Set up details of the driver, browser and other data to be used across all tests
    public void setUp() {
    	// Read from properties file (Please set you values before running)
        Properties testData;
		try {
			testData = Utilities.loadTestData();
	        baseURL = testData.getProperty("BaseURL");
	        email = testData.getProperty("Email");
	        password = testData.getProperty("Password");
	        name = testData.getProperty("Name");
	        browser = testData.getProperty("Browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.setProperty("webdriver.http.factory", "jdk-http-client");
    	
    	if(browser == "Chrome") {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\11796\\Desktop\\New folder\\Selenium\\seleniumUI\\src\\test\\java\\resources\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--disable-gpu");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
    	}
        // Set implicit wait for all actions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
        homePage = new HomePage(driver);
        loginPage =  new LoginPage(driver);
        videoGamesPage = new VideoGamesPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test // End to end test based on task given
    public void test01() throws InterruptedException {
    	homePage.goToSignIn();
    	loginPage.signIn(email, password, name);
    	homePage.goToCategory("Video Games");
    	videoGamesPage.filterBy("Free Shipping");
    	videoGamesPage.filterBy("New");
    	videoGamesPage.sortBy("Price: High to Low");
    	int[] addedItems = videoGamesPage.selectProductsLessThan(15000);
    	System.out.println("Total Items >> "+ addedItems[0] + " Total Price >> " + addedItems[1]);
    	homePage.goToCart();
    	cartPage.checkAddedItems(addedItems[0]);
    	cartPage.checkTotalPrice(addedItems[1]);
    	cartPage.proceedToBuy();
//    	Cash on delivery is not available for payments over 25k EGP, this step would be invalid
//    	cartPage.changePaymentMethod("Cash");
    }
    
    @AfterMethod // Close driver instance
    public void close() {
    	driver.close();
    	driver.quit();
    }
    
}
