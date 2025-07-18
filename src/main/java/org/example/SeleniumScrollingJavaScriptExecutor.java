package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumScrollingJavaScriptExecutor {
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
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void scrollIntoView() {
        WebElement goToForms = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Forms']"));
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(jsScript,goToForms);
        goToForms.click();
    }
}
