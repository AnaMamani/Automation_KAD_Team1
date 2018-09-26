package com.jalasoft.sfdc.ui.pages.opportunities;
import com.jalasoft.sfdc.ui.ListBasePage;
/**
 * Handles the opportunities List Page extends of the
 * {@Link ListBasePage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public abstract class OpportunitiesListPage extends ListBasePage {
    /**
     * This method perform an action and create a new OpportunitiesFormPage.
     *
     * @return a new OpportunitiesFormPage.
     */
    public abstract OpportunitiesFormPage clickNewOpportunities();
}
