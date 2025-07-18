package org.template;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    public By productsHeader = By.xpath("//span[text()='Products']");

    public boolean isProductsDisplayed () {
        return find(productsHeader).isDisplayed();
    }
}
