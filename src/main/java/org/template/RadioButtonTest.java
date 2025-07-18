package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTestTwo {
    @Test
    public void testRadioButton() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();
        boolean isFemaleSelected = formsPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleSelected, "\n Female button not selected");
    }
}
