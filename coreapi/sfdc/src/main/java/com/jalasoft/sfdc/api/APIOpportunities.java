package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Opportunities;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIOpportunities {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Opportunities opportunities;
    private Opportunities opportunitiesApi;
    protected Map<String, Object> fieldsMap;

    public APIOpportunities(Opportunities opportunities) {
        this.opportunities = opportunities;
        fieldsMap = covertEntityToMap();
        opportunitiesApi=new Opportunities();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return map
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(OPPY_NAME, opportunities.getOpportunityName());
        map.put(OPPY_CLOSE_DATE,opportunities.getCloseDate());
        map.put(OPPY_STAGE,opportunities.getStage());
        map.put(OPPY_ACCOUNT_ID,opportunities.getAccountName());

        return map;
    }

    /**
     *  this method get values by Api of Account.
     * @return accountApi
     */
    public Opportunities getOpportunitiesValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(OPPORTUNITY).
                concat(SLASH).concat(opportunities.getId()));
        opportunitiesApi.setOpportunityName(response.jsonPath().get(OPPY_NAME).toString());
        opportunitiesApi.setCloseDate(response.jsonPath().get(OPPY_CLOSE_DATE).toString());
        opportunitiesApi.setStage(response.jsonPath().get(OPPY_STAGE).toString());
        opportunitiesApi.setAccountName(response.jsonPath().get(OPPY_ACCOUNT_ID).toString());
         return opportunitiesApi;

    }

    /**
     * this method Create Api
     */
    public void createOpportinitiesByAPI() {
        response = apiManager.post(OPPORTUNITY, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        opportunities.setId(response.jsonPath().get(ID).toString());
    }

    /**
     * this method delete Api
     */

    public Response deleteOpportinitiesByAPI() {
        response = apiManager.delete(OPPORTUNITY, opportunities.getId());
        System.out.println("Query response delete: ***************************" + response.asString());
        return response;
    }

}
