## Selenium Video Game Price Scraper

**Description:**

This project automates shopping scenarios from a specific E-commerce website using Selenium WebDriver. It can simulate multiple features such as filtering by options or sorting. It uses Maven, Java, TestNG and Eclipse IDE to support the framework. 

**Structure:**

The project follows Page Object Model (POM) design pattern. The structure is as follows:
  - Classes for different pages can be found under com.yacout.SeleniumUI.pages
  - Classes for different tests can be found under com.yacout.SeleniumUI.tests
  - Objects for different pages can be found under com.yacout.SeleniumUI.objects
  - resources directory with Utilities class, webdrivers and testdata.properties file
 

**Features:**

  - Simulates adding multiple items to shopping carts that falls within certain filters, then proceeding with payments

**Usage:**

The project tests can be run using maven, either using command line "mvn test" or by running and adding maven command in the goals (Make sure to clean and build the project)

**Prerequisites:**

  - Java installed
  - WebDriver for your browser (e.g., ChromeDriver for Chrome)
  - Selenium WebDriver libraries (download from [https://www.selenium.dev/documentation/webdriver/](https://www.google.com/url?sa=E&source=gmail&q=https://www.selenium.dev/documentation/webdriver/))
  - Eclipse IDE (Or Similar)
  - Check POM.xml for versions

**Steps:**

1.  **Project Setup:**
      - Clone this repository or download the project files.
      - Ensure you have the necessary Selenium libraries added to your project's build path.
      - Replace the placeholder values in `testdata.properties` for the website URL, name, email and password.
2.  **Running the Script:**
      - Open a terminal or command prompt and navigate to the project directory.
      - Run the main class (e.g., `java com.yacout.seleniumUI.tests.AmazonTest`).
      - Alternatively, right click on project >> Run As >> Maven Build >> Add Maven command in goals. 
      - The script will navigate to the website, apply filters, scrape prices, and add items below the threshold to the cart, then proceed with the payments.


**Contribution:**

Feel free to fork the repository and contribute improvements or add new features. Consider following the existing coding style and conventions within the code.



**Author:**

Yacout