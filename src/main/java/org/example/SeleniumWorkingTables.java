package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumWorkingTables {
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
    public void scrollToPracticeForm () {
        //SELECT & SCROLL Forms
        WebElement elements = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Elements']"));
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(jsScript,elements);
        elements.click();

        //SELECT & SCROLL Practice Form
        WebElement webElements = driver.findElement(By.xpath("//li[@id='item-3']//span[text()='Web Tables']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElements);
        webElements.click();

        //SELECT & SCROLL Edit button
        WebElement editButton = driver.findElement(By.xpath("//span[@id='edit-record-2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", editButton);
        editButton.click();

        //SELECT & SCROLL Age field
        WebElement ageField = driver.findElement(By.xpath("//form[@id='userForm']//input[@id='age']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ageField);
        ageField.clear();
        ageField.sendKeys("39");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //SELECT & SCROLL Submit button
        WebElement button = driver.findElement(By.xpath("//form[@id='userForm']//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();

        //  //form[@id='userForm']//input[@id='age']
        // //form[@id='userForm']//button[@id='submit']



    }
}
