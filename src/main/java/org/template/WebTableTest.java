package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTestTwo {
    @Test
    public void testWebTable() {
        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit("alden@example.com");
        webTablePage.setAge("34");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge("alden@example.com");
        String expectedAge = "34";
        Assert.assertEquals(actualAge, expectedAge, "\n ages don't match \n");

    }
}
