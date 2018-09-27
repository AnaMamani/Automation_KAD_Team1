package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Quote;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIQuote {

    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Quote quote;
    private Quote quoteApi;
    protected Map<String, Object> fieldsMap;


    /**
     * Constructor for quoteAPI
     *
     * @param quote
     */
    public APIQuote(Quote quote) {
        this.quote = quote;
        fieldsMap = covertEntityToMap();
        quoteApi = new Quote();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(QUOTE_NAME, quote.getQuoteName());
        return map;
    }

    /**
     * validate by API for Contact
     *
     * @return a contact
     */
    public Quote getQuoteValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(QUOTE).
                concat(SLASH).concat(quote.getId()));
        quoteApi.setQuoteName(response.jsonPath().get(QUOTE_NAME).toString());
        quoteApi.setQuoteAccountName(response.jsonPath().get(QUOTE_ACCOUNT_NAME).toString());
        quoteApi.setQuoteSubtotal(response.jsonPath().get(QUOTE_TOTAL_PRICE).toString());
        quoteApi.setQuoteGranTotal(response.jsonPath().get(QUOTE_TOTAL_PRICE).toString());
        return quoteApi;
    }

    /**
     * this method Create Api
     */
    public void createQuoteByAPI() {
        response = apiManager.post(QUOTE, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        quote.setId(response.jsonPath().get(ID).toString());
    }

    /**
     * this method delete Api
     */
    public Response deleteQuoteByAPI() {
        response = apiManager.delete(OPPORTUNITY, quote.getId());
        System.out.println("Query response delete: ***************************" + response.asString());
        return response;
    }
}
