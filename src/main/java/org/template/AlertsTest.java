package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AlertsTest extends BaseTestTwo {

    public void testInformationAlert() {
        String expectedAlertText = "You clicked a button";
        var alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickInformationAlertButton();
        Assert.assertEquals(SwitchToUtility.getAlertText(), expectedAlertText, "\n Wrong message, do not match \n");

        SwitchToUtility.acceptAlert();
    }

    public void testConfirmationAlert() {
        var alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickConfirmationAlertButton();
        SwitchToUtility.dismissAlert();
        String confirmationResult = alertsPage.getConfirmationResult();
        String expectedConfirmationResult = "You selected Cancel";

        Assert.assertEquals(confirmationResult, expectedConfirmationResult, "You didn't clicked cancel");
    }

    public void testPromptAlert() {
        String alertText = "Selenium with Java";
        String expectedResult = "You entered " + alertText;

        var alertsPage = homePage.goToAlertsFramesWindowsCard().clickAlerts();
        alertsPage.clickPromptAlertButton();
        SwitchToUtility.setAlertText(alertText);
        SwitchToUtility.acceptAlert();
        String actualResult = alertsPage.getPromptAlertResult();
        Assert.assertEquals(actualResult, expectedResult, "Actual & Expect Results do not match");
    }
}
