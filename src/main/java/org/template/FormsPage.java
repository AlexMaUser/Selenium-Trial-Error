package org.template;

import org.openqa.selenium.By;

public class FormsPage extends HomePage {
    private By practiceForm = By.xpath("//li[@id='item-0']//span[text()='Practice Form']");

    public PracticeFormPage clickPracticeForm() {
        JavaScriptUtility.scrollToElementJS(practiceForm);
        click(practiceForm);
        return new PracticeFormPage();
    }
}
