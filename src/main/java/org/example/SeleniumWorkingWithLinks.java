package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumWorkingWithLinks {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testLinks() {
        //SCROLL & SELECT Elements
        WebElement elements = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements);
        elements.click();

        //SCROLL & SELECT Links
        WebElement links = driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", links);
        links.click();

        //SCROLL & SELECT link bad request
        WebElement badLink = driver.findElement(By.id("bad-request"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", badLink);
        badLink.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //SCROLL & SELECT bad request message
        WebElement message = driver.findElement(By.id("linkResponse"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", message);
        String errorMessage = message.getText();
        Assert.assertTrue(errorMessage.contains("400") && errorMessage.contains("Bad Request"));

    }
}
