package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunities;
/**
 * Handles OpportunitiesDetailPageLight extends of the
 * {@Link OpportunitiesDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class OpportunitiesDetailPageLight extends OpportunitiesDetailPage {
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
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
