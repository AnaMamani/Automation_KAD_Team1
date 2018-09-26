package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class ProductPriceBookPage extends BasePage {

    /**
     * @param standard it is the category of product.
     * @return the new ProductListPriceBook page.
     */
    public abstract ProductListPriceBook selectPriceBook(String standard);

}
