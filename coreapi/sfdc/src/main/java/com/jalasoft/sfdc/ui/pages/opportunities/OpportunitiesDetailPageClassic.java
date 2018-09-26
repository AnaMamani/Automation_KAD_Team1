package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPage;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesDetailPageClassic extends OpportunitiesDetailPage {

    @FindBy(xpath = "//input[@value='New Quote']")
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
        driverTools.clickElement(clickNewBtnQuotes);
        return new QuotesFormPageClassic();
    }
}
