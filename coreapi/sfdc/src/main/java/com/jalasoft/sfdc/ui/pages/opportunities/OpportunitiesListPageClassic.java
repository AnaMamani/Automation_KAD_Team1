package com.jalasoft.sfdc.ui.pages.opportunities;

public class OpportunitiesListPageClassic extends OpportunitiesListPage {
    @Override
    public OpportunitiesForm clickNewOpportunities() {
        driverTools.clickElement(newBtn);
        return new OpportunitiesFormClassic();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
