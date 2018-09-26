package com.jalasoft.sfdc.ui.pages.opportunities;

import com.jalasoft.sfdc.entities.Opportunities;
import com.jalasoft.sfdc.ui.BasePage;
/**
 * Handles the opportunities form Page extends of the
 * {@Link BasePage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public abstract class OpportunitiesFormPage extends BasePage {
    /**
     * setting and create a new OpportunitiesDetailPage.
     * @param opportunity all information
     * @return OpportunitiesDetailPage
     */
    public abstract OpportunitiesDetailPage createOpportunity(Opportunities opportunity);
}
