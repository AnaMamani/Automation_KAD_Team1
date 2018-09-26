package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.entities.Opportunities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles the opportunities form Page Classic extends of the
 * {@Link OpportunitiesFormPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class OpportunitiesFormPageClassic extends OpportunitiesFormPage {
    //PageFactory of selenium.
    @FindBy(id="opp3")
    WebElement opportunityNameTxt;

    //@FindBy(xpath = "//span[@class='dateFormat']")
    @FindBy(id = "opp9")
    WebElement closeDateTxt;

    @FindBy(xpath = "//select[@id='opp11']")
    WebElement clickStage;

    @FindBy(xpath = "//input[@title='Save']")
    WebElement clickBtnSave;

    @FindBy(id = "opp4")
    private WebElement accountNameOpportunityTxt;

    @FindBy(xpath = "//img[@class='lookupIcon']")
    private WebElement iconShearchAccount;

    /**
     *setting and create a new OpportunitiesDetailPage.
     * @param opportunity all information
     * @return OpportunitiesDetailPageClassic
     */
    @Override
    public OpportunitiesDetailPage createOpportunity(Opportunities opportunity) {
        log.info("createOpportunity : Enter");
        driverTools.setInputField(opportunityNameTxt,opportunity.getOpportunityName());
        driverTools.clickElement(clickStage);
        driverTools.clickElement(By.xpath(" //select[@id='opp11']/option[contains(text(),'"+opportunity.getStage()+"')]"));
        driverTools.setInputField(closeDateTxt,opportunity.getCloseDate());



        //driverTools.setInputField(accountNameOpportunityTxt,);
        //driverTools.clickElement(iconShearchAccount);

        driverTools.clickElement(clickBtnSave);



        return new OpportunitiesDetailPageClassic();
    }
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(opportunityNameTxt));
    }
}
