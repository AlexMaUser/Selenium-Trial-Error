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

public class SeleniumSwitchToPromptAlert {
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
    public void testAlertsPrompt() {
        //SELECT & SCROLL Alerts..
        WebElement alerts = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alerts);
        alerts.click();

        //SELECT & SCROLL Alerts
        WebElement alertsSection = driver.findElement(By.xpath("//li[@id='item-1']//span[text()='Alerts']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alertsSection);
        alertsSection.click();

        //SELECT Prompt alert button;
        WebElement alertPromptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        alertPromptButton.click();

        //SEND prompt text
        driver.switchTo().alert().sendKeys("Selenium with Java");
        driver.switchTo().alert().accept();

        String alertText = "Selenium with Java";
        String expectedResult = "You entered " + alertText;

        String actualResult = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        Assert.assertEquals(actualResult, expectedResult, "Actual & Expect Results do not match");
    }
}
