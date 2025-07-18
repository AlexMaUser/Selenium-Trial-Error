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

public class SeleniumCheckBoxes {
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
        WebElement goToForms = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Forms']"));
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(jsScript,goToForms);
        goToForms.click();

        //SELECT & SCROLL Practice Form
        WebElement practiceForm = driver.findElement(By.xpath("//li[@id='item-0']//span[text()='Practice Form']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", practiceForm);
        practiceForm.click();


        //SELECT Hobbies sports  reading  music
        WebElement sportsElement = driver.findElement(By.id("hobbies-checkbox-1"));
        if(!sportsElement.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sportsElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsElement);
        }

        WebElement readingElement = driver.findElement(By.id("hobbies-checkbox-2"));
        if(!readingElement.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", readingElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readingElement);
        }

        WebElement musicElement = driver.findElement(By.id("hobbies-checkbox-3"));
        if(!musicElement.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", musicElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", musicElement);
        }

        if(readingElement.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", readingElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", readingElement);
        }

        boolean isReadingSelected = readingElement.isSelected();
        Assert.assertFalse(isReadingSelected, "\n Reading is selected \n");
    }
}
