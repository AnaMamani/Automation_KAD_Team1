package com.jalasoft.sfdc.ui.pages.quotes;

import com.jalasoft.sfdc.entities.Quote;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 *  class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 9/24/2018
 */
public class QuotesFormPageClassic extends QuotesFormPage {

    @FindBy(id = "Name")
    private WebElement quoteNameTxt ;

    @FindBy(id = "ExpirationDate")
    private WebElement quoteExpirationDate;

    @FindBy(id = "Status")
    private WebElement quoteStatusSelect;

    @FindBy(id = "Description")
    private WebElement quoteDescriptionTxt;

    @FindBy(id = "Tax")
    private WebElement quoteTaxTxt;

    @FindBy(id = "ShippingHandling")
    private WebElement quoteShippingAndHandlingTxt ;

    @FindBy(xpath = "//td[@id='topButtonRow']/input[@value=' Save ']")
    private WebElement saveBtn;


    /**
     * for create a Quote
     *
     * @param quoteName
     * @return QuotesDetailPage
     */
    @Override
    public QuotesDetailPage createQuote(String quoteName) {
        driverTools.setInputField(quoteNameTxt, quoteName);
        driverTools.clickElement(saveBtn);
        return new QuotesDetailPageClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
