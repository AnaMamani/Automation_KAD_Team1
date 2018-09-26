package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.ListBasePage;

public abstract class ProductListPriceBook extends ListBasePage {

    /**
     * @param price it is the price of product.
     * @return the new ProductDetailPage page.
     */
    public abstract ProductDetailPage addPriceBook(String price);
}
