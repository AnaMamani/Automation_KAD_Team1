package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesDetailPageLight extends OpportunitiesDetailPage {

    @FindBy(xpath = "//a[@title='Show one more action']")
    private WebElement showMoreActionQuotes;
    @FindBy(xpath = "//a[@title='New Quote']")
    private WebElement clickNewBtnQuotes;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Click of Button quotes for fill
     *
     * @return QuotesFormPage
     */
    @Override
    public QuotesFormPage clickQuotesNew() {
        return null;
    }
}
