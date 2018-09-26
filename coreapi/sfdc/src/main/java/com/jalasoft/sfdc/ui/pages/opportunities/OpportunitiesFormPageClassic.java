package com.jalasoft.sfdc.ui.pages.opportunities;

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

    @FindBy(xpath = "//span[@class='dateFormat']")
    WebElement clickDate;

    @FindBy(xpath = "//select[@id='opp11']")
    WebElement clickStage;

    @FindBy(xpath = "//input[@title='Save']")
    WebElement clickBtnSave;

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
        driverTools.clickElement(clickDate);
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
