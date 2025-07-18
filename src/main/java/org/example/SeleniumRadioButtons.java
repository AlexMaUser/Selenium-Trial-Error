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

public class SeleniumRadioButtons {
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

        //SCROLL & SELECT Female radio button
        WebElement femaleRadioButton = driver.findElement(By.id("gender-radio-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", femaleRadioButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", femaleRadioButton);

        boolean isSelected = femaleRadioButton.isSelected();
        Assert.assertTrue(isSelected, "\n Female button not selected");

    }
}
