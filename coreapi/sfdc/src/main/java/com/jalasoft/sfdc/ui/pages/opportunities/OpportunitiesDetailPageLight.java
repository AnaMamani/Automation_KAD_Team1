package com.jalasoft.sfdc.ui.pages.opportunities;


import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.jalasoft.sfdc.entities.Opportunities;
/**
 * Handles OpportunitiesDetailPageLight extends of the
 * {@Link OpportunitiesDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

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

     *
     * @param opportunities information.
     * @return
     */
    @Override
    public boolean isSuccessCreateOpportunity(Opportunities opportunities) {
        return false;
    }

    /**
     * verify that an opportunities is create
     * @return Opportunity name created
     */
    @Override
    public String getOpportunityCreated() {

        return null;
    }
}
