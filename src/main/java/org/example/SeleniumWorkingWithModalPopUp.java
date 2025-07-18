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

public class SeleniumWorkingWithModalPopUp {
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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void testPopUps() {
        //SELECT & SCROLL Alerts..
        WebElement alerts = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alerts);
        alerts.click();

        //SELECT & SCROLL Modal Dialogs
        WebElement modalDialogs = driver.findElement(By.xpath("//li[@id='item-4']//span[text()='Modal Dialogs']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", modalDialogs);
        modalDialogs.click();

        //SELECT & SCROLL Small modal button
        WebElement smallModal = driver.findElement(By.id("showSmallModal"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", smallModal);
        smallModal.click();

        //SELECT & SCROLL Small modal text
        WebElement smallModalText = driver.findElement(By.xpath("//div[contains(text(),'small modal')]"));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualText = smallModalText.getText();
        System.out.println("TEXT:       " + actualText);

        Assert.assertTrue(actualText.contains("small modal"), "\n The message does not contain small modal\n");


        //SELECT & SCROLL close button
        WebElement smallCloseButton = driver.findElement(By.id("closeSmallModal"));
        smallCloseButton.click();
    }
}
