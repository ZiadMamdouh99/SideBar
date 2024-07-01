package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SideBar {
    public static void main(String[] args) throws InterruptedException {
        // Set the path for the chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Convertedin\\IdeaProjects\\sidebartask\\src\\test\\java\\chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://app-stg.converted.in/dashboard/home");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Call the login method
        login(driver, "shanelzstore@gmail.com", "pzq6TGHF7t");

        // Select the store
        selectStore(driver);


        Thread.sleep(10000); // 10 seconds

        // Use JavaScript to get the shadow root element
        WebElement shadowHost = driver.findElement(By.tagName("convertedin-sidebar"));
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost);

        // Find the social media tab within the shadow root and click it
        WebElement socialMediaTab = shadowRoot.findElement(By.cssSelector("#p-accordiontab-1"));
        socialMediaTab.click();



    }

    public static void login(WebDriver driver, String email, String password) {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("form-action"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public static void selectStore(WebDriver driver) {
        WebElement selectStoreElement = driver.findElement(By.className("border-1"));
        selectStoreElement.click();

        selectStoreElement.submit();
    }
}
