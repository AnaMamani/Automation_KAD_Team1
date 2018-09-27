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
    @FindBy(id = "opp3")
    WebElement opportunityNameTxt;

    //@FindBy(xpath = "//span[@class='dateFormat']")
    @FindBy(id = "opp9")
    WebElement closeDateTxt;

    @FindBy(xpath = "//select[@id='opp11']")
    WebElement clickStage;

    @FindBy(xpath = "//input[@title='Save']")
    WebElement btnSave;

    @FindBy(id = "opp4")
    private WebElement accountNameOpportunityTxt;

    @FindBy(xpath = "//*[@value='Share']")
    private WebElement auxToOpportunityId;

   // private static final String STAGE_LBL = "//select[@id='opp11']/option[contains(text(),'%s')]";

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(btnSave));
    }

    /**
     * setting and create a new OpportunitiesDetailPage.
     *
     * @param opportunity all information
     * @return OpportunitiesDetailPageClassic
     */
    @Override
    public OpportunitiesDetailPage createOpportunity(Opportunities opportunity) {
        log.info("createOpportunity : set the field");
        driverTools.setInputField(opportunityNameTxt, opportunity.getOpportunityName());
        driverTools.clickElement(clickStage);
       // driverTools.isElementDisplayed(By.xpath(String.format(STAGE_LBL,opportunity.getStage())));
        driverTools.clickElement(By.xpath(" //select[@id='opp11']/option[contains(text(),'" + opportunity.getStage() + "')]"));
        driverTools.setInputField(closeDateTxt, opportunity.getCloseDate());
        driverTools.setInputField(accountNameOpportunityTxt, opportunity.getAccountName());
        driverTools.clickElement(btnSave);
        wait.until(ExpectedConditions.visibilityOf(auxToOpportunityId));
        saveOpportunityId(driver.getCurrentUrl(),opportunity);
        return new OpportunitiesDetailPageClassic();
    }
    /**
     * @param currentUrl url.
     * @param opportunity opportunity.
     */
    private void saveOpportunityId(String currentUrl, Opportunities opportunity) {
        String[] url=currentUrl.split("/");
        opportunity.setId(url[url.length-1]);
        System.out.println("ID: "+url[url.length-1]+" THIS IS THE OPPORTUNITY ID");
    }

}
