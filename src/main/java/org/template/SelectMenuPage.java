package org.template;

import org.openqa.selenium.By;

import java.util.List;

public class SelectMenuPage extends WidgetsPage {
    private By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text) {
        JavaScriptUtility.scrollToElementJS(standardMultiSelect);
//        Select select = new Select(find(standardMultiSelect));
//        select.selectByVisibleText(text);

        DropDownUtility.selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMulti(int index) {
        JavaScriptUtility.scrollToElementJS(standardMultiSelect);
        DropDownUtility.selectByIndex(standardMultiSelect, index);
    }
    public void deselectStandardMulti(String value) {
        JavaScriptUtility.scrollToElementJS(standardMultiSelect);
        DropDownUtility.deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedStandardMultiOptions() {
        return DropDownUtility.getAllSelectedOptions(standardMultiSelect);
    }
}
