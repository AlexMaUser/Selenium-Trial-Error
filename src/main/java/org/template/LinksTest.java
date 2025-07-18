package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTestTwo {

    @Test
    public void testLinks() {
        var linksPage = homePage.goToElements().clickLinks();
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();
        Assert.assertTrue(actualResponse.contains("400") && actualResponse.contains("Bad Request"));
    }
}
