package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Quote;

import javax.xml.ws.Response;
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
        //map.put(QUOTE_NAME, quote.getName());
        return map;
    }

    /**
     * validate by API for Contact
     *
     * @return a contact
     */
    public Quote getContactValuesByAPI() { //ToDo define what aee you going to return
        //response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(QUOTE).
          //      concat(SLASH).concat());
       // quoteApi.setName(response.jsonPath().get(CONTACT_FIRST_NAME).toString());

        return quoteApi;
    }


}
