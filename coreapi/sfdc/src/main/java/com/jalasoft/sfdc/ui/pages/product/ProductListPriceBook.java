package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.ListBasePage;

/**
 * Product Steps class.
 *
 * @author Denis Camacho.
 * @since 9/18/2018
 */

public abstract class ProductListPriceBook extends ListBasePage {

    /**
     * @param price it is the price of product.
     * @return the new ProductDetailPage page.
     */
    public abstract ProductDetailPage addPriceBook(String price);
}
