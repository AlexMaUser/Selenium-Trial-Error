package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ScrollSelectDropDownTest extends BaseTestTwo {
    @Test
    public void testMultiSelectorDropDown() {
        var selectMenuPage = homePage.goToWidgets().clickSelectMenu();
        selectMenuPage.selectStandardMulti("Volvo");
        selectMenuPage.selectStandardMulti(1);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.selectStandardMulti(2);

        selectMenuPage.deselectStandardMulti("saab");
        List<String> actualSelectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo"));
        Assert.assertFalse(actualSelectedOptions.contains("Saab"));
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"));

    }
}
