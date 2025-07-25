package org.template;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickButton() {
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage loginIntoApplication (String username, String password) {
        setUsername(username);
        setPassword(password);

        return clickButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
