package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/18/2018
 */
public abstract class ProductPriceBookPage extends BasePage {

    /**
     * @param standard it is the category of product.
     * @return the new ProductListPriceBook page.
     */
    public abstract ProductListPriceBook selectPriceBook(String standard);

}
