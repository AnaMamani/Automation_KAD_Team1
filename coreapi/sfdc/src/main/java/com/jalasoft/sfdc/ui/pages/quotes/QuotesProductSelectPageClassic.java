package com.jalasoft.sfdc.ui.pages.quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesProductSelectPageClassic extends QuotesProductSelectPage {

    @FindBy(xpath = "//input[@title='Select']")
    private WebElement selectPQBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(selectPQBtn));
    }

    /**
     * for select of product in quotes
     *
     * @param productName String
     * @return QuotesAddItemsPage
     */
    @Override
    public QuotesAddItemsPage selectProductQuote(String productName) {
        driverTools.clickElement((By.xpath("//span[text()= '"+productName+"']/../../../../child::td/child::div/child::input")));
        driverTools.clickElement(selectPQBtn);
        return new QuotesAddItemsPageClassic() ;
    }
}
