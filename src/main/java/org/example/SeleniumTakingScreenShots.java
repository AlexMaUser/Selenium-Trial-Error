package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumTakingScreenShots {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void takeFailResultScreenShot(ITestResult testResult) {
        if(ITestResult.FAILURE == testResult.getStatus()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
            String timestamp = LocalDateTime.now().format(formatter);

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/" + timestamp + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void testScreenShots() {
        //SELECT & SCROLL Forms
        WebElement goToForms = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Forms']"));
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(jsScript,goToForms);
        goToForms.click();

        //SELECT & SCROLL Practice Form
        WebElement practiceForm = driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Practice Form']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", practiceForm);
        practiceForm.click();

        //SELECT & SCROLL Submit button
        WebElement button = driver.findElement(By.xpath("//form[@id='userForm']//button[@id='submit']"));
        button.click();
    }
}
