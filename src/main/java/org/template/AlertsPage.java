package org.template;

import org.openqa.selenium.By;

public class AlertsPage extends Alerts_Frames_WindowsPage {
    private By informationAlertButton = By.id("alertButton");
    private By confirmationAlertButton = By.id("confirmButton");
    private By confirmationMessage = By.id("confirmResult");
    private By promptAlertButton = By.xpath("//button[@id='promtButton']");
    private By promptResult = By.xpath("//span[@id='promptResult']");

    public String getPromptAlertResult() {
        return find(promptResult).getText();
    }

    public void clickInformationAlertButton() {
        click(informationAlertButton);
    }

    public void clickConfirmationAlertButton() {
        click(confirmationAlertButton);
    }

    public String getConfirmationResult() {
        return  find(confirmationMessage).getText();
    }

    public void clickPromptAlertButton() {
        click(promptAlertButton);
    }
}
