package com.jalasoft.sfdc.ui.pages.opportunities;
/**
 * Handles the OpportunitiesListPageLight extends of the
 * {@Link OpportunitiesListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class OpportunitiesListPageLight extends OpportunitiesListPage {
    /**
     * This method perform an action and create a new OpportunitiesFormPage.
     *
     * @return a new OpportunitiesFormPage.
     */
    @Override
    public OpportunitiesFormPage clickNewOpportunities() {
        driverTools.clickElement(newBtn);
        return new OpportunitiesFormPageLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
