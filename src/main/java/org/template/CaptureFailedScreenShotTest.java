package org.template;

import org.testng.annotations.Test;

public class CaptureFailedScreenShotTest extends BaseTestTwo {
    @Test
    public void testClickingSubmitButtonWithoutJSExecutor() {
        var practiceFormPage = homePage.goToForms().clickPracticeForm();
        practiceFormPage.clickSubmitButton();
    }
}
