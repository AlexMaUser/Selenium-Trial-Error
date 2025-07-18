package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickButton();

        String actualMessage = loginPage.getErrorMessage();
        Assert.assertFalse(actualMessage.contains("Epic sadface"));
    }
}
