package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumFirstTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void loginIntoApplication() throws InterruptedException {
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("//div[@id='app']//h6[text()='Dashboard']")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);


    }
}
