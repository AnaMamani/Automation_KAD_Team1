package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunities;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * Handles the opportunities Detail Page.
 *
 * @author Ketty Camacho Vasquez
 */
public abstract class OpportunitiesDetailPage extends BasePage {
    /**
     * verify that an opportunities is create
     * @param opportunities information.
     * @return is successfully or not successfully
     */
    public abstract boolean isSuccessCreateOpportunity(Opportunities opportunities);

    /**
     *
     * @return Opportunity name created.
     */
    public abstract String getOpportunityCreated();
}
