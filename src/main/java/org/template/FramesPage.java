package org.template;

import org.openqa.selenium.By;

public class FramesPage extends Alerts_Frames_WindowsPage {
    private By textInFrame = By.id("sampleHeading");
    private String iFrameBigBox = "frame1";
    private By header = By.xpath("//div[@id='framesWrapper']//h1[text()='Frames']");
    private By iFrameSmallBox = By.xpath("//div[@id='frame2Wrapper']//iframe[@id='frame2']");

    public String getHeaderFramesText() {
        return find(header).getText();
    }

    private void switchToBigBox() {
//        driver.switchTo().frame(iFrameBigBox);
        SwitchToUtility.switchFrameString(iFrameBigBox);
    }

    private void switchToSmallBox() {
//        SwitchToUtility.switchToFrameIndex(1);
        SwitchToUtility.switchToFrameElement(find(iFrameSmallBox));
    }

    public String getTextInBigFrame() {
        driver.switchTo().frame("frame1");
        String bigFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bigFrameText);
        SwitchToUtility.switchToDefaultContent();
//        driver.switchTo().defaultContent();
        return bigFrameText;
    }

    public String getTextInSmallFrame() {
        switchToSmallBox();
        String smallFrameText = find(textInFrame).getText();
        System.out.println("Small frame text " + smallFrameText);
        SwitchToUtility.switchToDefaultContent();
        return smallFrameText;
    }
}
