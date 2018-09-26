package com.jalasoft.sfdc.ui.pages.opportunities;


import com.jalasoft.sfdc.entities.Opportunities;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPage;
import com.jalasoft.sfdc.ui.pages.quotes.QuotesFormPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles OpportunitiesDetailPageClassic extends of the
 * {@Link OpportunitiesDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class OpportunitiesDetailPageClassic extends OpportunitiesDetailPage {
    @FindBy(xpath = "//input[@value='New Quote']")
    private WebElement clickNewBtnQuotes;
    //PageFactory of selenium.
   @FindBy(xpath = "//h2[@class='pageDescription']")
    private WebElement  opportunityNameCreatedTxt;

   @FindBy(id="opp3_ileinner")
   private WebElement oppotunityNameTxt;

   @FindBy(id="opp11_ileinner")
   private WebElement opportunityStageTxt;

   @FindBy(xpath = "//td[@class='dataCol inlineEditWrite']/div[@id='opp9_ileinner']")
   private  WebElement cloceDateTxt;

    /**
     * verify that an opportunities is create
     * @param opportunities information.
     * @return is successfully or not successfully
     */
    @Override
    public boolean isSuccessCreateOpportunity(Opportunities opportunities) {

        System.out.println(opportunities.getCloseDate()+"+++++++++++DAte");
        System.out.println(cloceDateTxt.getText()+"+++++++++++++++++date");

        return opportunities.getOpportunityName().equals(oppotunityNameTxt.getText()) &&
                opportunities.getStage().equals(opportunityStageTxt.getText());
                //&&
                //opportunities.getCloseDate().equals(cloceDateTxt.getText());
    }

    /**
     * method get opportunity Created validator.
     * @return string opportunity name.
     */
    @Override
    public String getOpportunityCreated() {
        log.info("getOpportunityCreated: " + opportunityNameCreatedTxt.getText());

        return opportunityNameCreatedTxt.getText().trim();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(opportunityNameCreatedTxt));
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
