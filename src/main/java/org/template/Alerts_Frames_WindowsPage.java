package org.template;

import org.openqa.selenium.By;

public class Alerts_Frames_WindowsPage extends HomePage {
    private By modalDialogsMenuItem = By.xpath("//li[@id='item-4']//span[text()='Modal Dialogs']");
    private By alertsMenuItem = By.xpath("//li[@id='item-1']//span[text()='Alerts']");
    private By framesMenuItem = By.xpath("//li[@id='item-2']//span[text()='Frames']");

    public FramesPage clickFrames() {
        JavaScriptUtility.scrollToElementJS(framesMenuItem);
        click(framesMenuItem);
        return new FramesPage();
    }

    public ModalDialogsPage clickModalDialogs() {
        JavaScriptUtility.scrollToElementJS(modalDialogsMenuItem);
        click(modalDialogsMenuItem);
        return new ModalDialogsPage();
    }

    public AlertsPage clickAlerts() {
        JavaScriptUtility.scrollToElementJS(alertsMenuItem);
        click(alertsMenuItem);
        return new AlertsPage();
    }
}
