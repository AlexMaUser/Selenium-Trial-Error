package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTestTwo {
    @Test
    public void testModalDialog() {
        var alertsPage = homePage.goToAlertsFramesWindowsCard();
        var modalDialogsPage = alertsPage.clickModalDialogs();
        modalDialogsPage.clickSmallModalButton();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualText = modalDialogsPage.getSmallModalText();
        System.out.println("TEXT:       " + actualText);

        Assert.assertTrue(actualText.contains("small modal"), "\n The message does not contain small modal\n");
        modalDialogsPage.clickCloseButton();
    }
}
