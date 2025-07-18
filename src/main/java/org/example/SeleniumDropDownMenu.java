package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumDropDownMenu {
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void testDropDown() {
        //SCROLL & SELECT Widgets
        WebElement widgets = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", widgets);
        widgets.click();

        //SCROLL & SELECT Select menu
        WebElement selectMenu = driver.findElement(By.xpath("//li[@id='item-8']//span[text()='Select Menu']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", selectMenu);
        selectMenu.click();

        //SCROLL & SELECT cars
        WebElement cars = driver.findElement(By.id("cars"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cars);

        Select select = new Select(cars);
        select.selectByVisibleText("Volvo");
        select.selectByIndex(1);
        select.selectByVisibleText("Audi");
        select.selectByIndex(2);

        select.deselectByIndex(1);
    }
}
