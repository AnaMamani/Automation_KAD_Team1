package com.jalasoft.sfdc.ui.pages.opportunities;

import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles the OpportunitiesListPageClassic extends of the
 * {@Link OpportunitiesListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class OpportunitiesListPageClassic extends OpportunitiesListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * This method perform an action and create a new OpportunitiesFormPage.
     *
     * @return a new OpportunitiesFormPage.
     */
    @Override
    public OpportunitiesFormPage clickNewOpportunities() {
        driverTools.clickElement(newBtn);
        return new OpportunitiesFormPageClassic();
    }


}
