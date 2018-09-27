package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.entities.Opportunities;

/**
 * Handles the opportunities form Page Light extends of the
 * {@Link OpportunitiesFormPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class OpportunitiesFormPageLight extends OpportunitiesFormPage {
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * setting and create a new OpportunitiesDetailPage.
     *
     * @param opportunity all information
     * @return OpportunitiesDetailPageLight
     */
    @Override
    public OpportunitiesDetailPage createOpportunity(Opportunities opportunity) {
        return null;
    }
}
