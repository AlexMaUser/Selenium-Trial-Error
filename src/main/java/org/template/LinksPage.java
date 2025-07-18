package org.template;

import org.openqa.selenium.By;

public class LinksPage extends ElementsPage {
    private By badRequestLink = By.id("bad-request");
    private By responseLink = By.id("linkResponse");

    public void clickBadRequestLink() {
        JavaScriptUtility.scrollToElementJS(badRequestLink);
        click(badRequestLink);
    }

    public String getResponse() {
        delay(2000);
        return find(responseLink).getText();
    }
}
