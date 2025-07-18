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

public class SeleniumSwitchingFrames {
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
    public void testSwitchFrames() {
        //SELECT & SCROLL Alerts..
        WebElement alerts = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", alerts);
        alerts.click();

        //SELECT & SCROLL Frames
        WebElement frames = driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Frames']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", frames);
        frames.click();

        //SWITCH to frames
        driver.switchTo().frame("frame1");
        String bigFrameText = driver.findElement(By.tagName("body")).getText();

        //SWTICH out
        driver.switchTo().defaultContent();


        String expectedBigBox = "This is a sample page";
        Assert.assertEquals(bigFrameText, expectedBigBox, "Wrong text");

        //SCROLL FRAMES
        String actualHeaderText = driver.findElement(By.xpath("//div[@id='framesWrapper']//h1[text()='Frames']")).getText();
        String expectedHeaderText = "Frames";
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Wrong Text");
    }
}
