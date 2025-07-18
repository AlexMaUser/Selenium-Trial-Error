package org.template;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By alertsFramesWindowsCard = By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']");

    public FormsPage goToForms() {
        JavaScriptUtility.scrollToElementJS(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public ElementsPage goToElements() {
        JavaScriptUtility.scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets() {
        JavaScriptUtility.scrollToElementJS(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }

    public Alerts_Frames_WindowsPage goToAlertsFramesWindowsCard() {
        JavaScriptUtility.scrollToElementJS(alertsFramesWindowsCard);
        click(alertsFramesWindowsCard);
        return new Alerts_Frames_WindowsPage();
    }
}
