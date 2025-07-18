package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTestTwo {
    @Test
    public void testCheckBox() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportsHubbyCheckBox();
        formsPage.clickReadingHubbyCheckBox();
        formsPage.clickMusicHubbyCheckBox();
        formsPage.unclickReadingHubbyCheckBox();

        boolean isReadingSelected = formsPage.isReadingSelected();
        Assert.assertFalse(isReadingSelected, "Is Selected");
    }
}
