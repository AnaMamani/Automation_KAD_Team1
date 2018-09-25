package com.jalasoft.sfdc.ui.pages.opportunities;

public class OpportunitiesListPageLight extends OpportunitiesListPage {
    @Override
    public OpportunitiesForm clickNewOpportunities() {
        driverTools.clickElement(newBtn);
        return new OpportunitiesFormLight();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
