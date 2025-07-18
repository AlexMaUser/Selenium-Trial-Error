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

public class SeleniumSwitchToAlert {
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
    public void testAlerts() {
        //SELECT & SCROLL Alerts..
        WebElement alerts = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alerts);
        alerts.click();

        //SELECT & SCROLL Alerts
        WebElement alertsSection = driver.findElement(By.xpath("//li[@id='item-1']//span[text()='Alerts']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alertsSection);
        alertsSection.click();

        //SELECT & SCROLL Alert button
        WebElement alert1 = driver.findElement(By.id("alertButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alert1);
        alert1.click();

        // switch and verify
        String alertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You clicked a button";

        Assert.assertEquals(alertText, expectedAlertText, "\n Wrong message, do not match \n");
        driver.switchTo().alert().accept();

        //SELECT & SCROLL Confirm button
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        driver.switchTo().alert().dismiss();

        //Confirmation Message
        WebElement confirmationMessage = driver.findElement( By.id("confirmResult"));
        String confirmationTextMessage = confirmationMessage.getText();
        String expectedConfirmationResult = "You selected Cancel";
        Assert.assertEquals(confirmationTextMessage, expectedConfirmationResult, "You didn't clicked cancel");

    }
}
