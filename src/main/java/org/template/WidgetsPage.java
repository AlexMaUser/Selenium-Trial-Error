package org.template;

import org.openqa.selenium.By;

public class WidgetsPage extends HomePage {
    private By selectMenuItem = By.xpath("//li[@id='item-8']//span[text()='Select Menu']");
    private By datePickerMenuItem = By.xpath("//li[@id='item-2']//span[text()='Date Picker']");

    public SelectMenuPage clickSelectMenu() {
        JavaScriptUtility.scrollToElementJS(selectMenuItem);
        click(selectMenuItem);
        return new SelectMenuPage();
    }

    public DatePickerMenuPage clickDatePicker() {
        JavaScriptUtility.scrollToElementJS(datePickerMenuItem);
        click(datePickerMenuItem);
        return new DatePickerMenuPage();
    }
}
