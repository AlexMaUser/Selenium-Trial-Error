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

public class SeleniumWorkingWithDates {
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
    public void testWorkingWithDates() {
        //SCROLL & SELECT Widgets
        WebElement widgets = driver.findElement(By.xpath("//div[@id='app']//h5[text()='Widgets']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", widgets);
        widgets.click();

        //SCROLL & SELECT DatePicker
        WebElement datePicker = driver.findElement(By.xpath("//li[@id='item-2']//span[text()='Date Picker']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", datePicker);
        datePicker.click();

        //SCROLL & SELECT datePickerMonthYearInput
        WebElement datePickerMonthYear = driver.findElement(By.id("datePickerMonthYearInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", datePickerMonthYear);
        datePickerMonthYear.click();

        //SCROLL & SELECT month
        WebElement monthPicker = driver.findElement(By.className("react-datepicker__month-select"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", monthPicker);
        Select select = new Select(monthPicker);
        select.selectByIndex(11);

        //SCROLL & SELECT year
        WebElement yearPicker = driver.findElement(By.className("react-datepicker__year-select"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", yearPicker);
        select = new Select(yearPicker);
        select.selectByValue("2025");

        //SCROLL & SELECT day
        WebElement dayPicker = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')][text()='31']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dayPicker);
        dayPicker.click();

        String actualDate = datePickerMonthYear.getDomAttribute("value");
        System.out.println("->>>>>>>>>>>>>>>>>>>> " + actualDate);
    }
}
