package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPge = loginPage.loginIntoApplication("standard_user", "secret_sauce");
        Assert.assertTrue(productsPge.isProductsDisplayed());
    }
}
