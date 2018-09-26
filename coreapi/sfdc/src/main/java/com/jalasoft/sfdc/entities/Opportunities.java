package com.jalasoft.sfdc.entities;

import java.util.Date;

/**
 * User class opportunities the information.
 *
 * @author Ketty Camacho Vasquez
 *
 */
public class Opportunities {

    private String opportunityName;
    private String closeDate;
    private String stage;
    /**
     * get  opportunities Name.
     * @return opportunityName.
     */
    public String getOpportunityName() {
        return opportunityName;
    }

    /**
     * set opportunities Name
     * @param opportunityName
     */
    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    /**
     * get Close Date .
     * @return  closeDate.
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     *set Close Date.
     * @param closeDate close date.
     */
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    /**
     * get of stage.
     * @return stage.
     */
    public String getStage() {
        return stage;
    }

    /**
     *set of Stage.
     * @param stage stage.
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * update opportunity name.
     */
    public void updateOpportunityName() {
        long timeStamp = new Date().getTime();
        this.opportunityName += timeStamp;

    }

}
