package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTestTwo {
    @Test
    public void testFramesBigBox() {
        var framesPage = homePage.goToAlertsFramesWindowsCard().clickFrames();
        String actualBigBoxText = framesPage.getTextInBigFrame();
        String expectedBigBox = "This is a sample page";
        Assert.assertEquals(actualBigBoxText, expectedBigBox, "Wrong text");

        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeaderText = "Frames";
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Wrong Text");
    }

    @Test
    public void testFramesSmallBox() {
        var framesPage = homePage.goToAlertsFramesWindowsCard().clickFrames();
        String actualSmallBoxText = framesPage.getTextInSmallFrame();
        String expectedSmallBoxText = "This is a sample page";
        Assert.assertEquals(actualSmallBoxText, expectedSmallBoxText, "Wrong message");
        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeadText = "Frames";
        Assert.assertEquals(actualHeaderText, expectedHeadText, "Wrong text");

    }
}
