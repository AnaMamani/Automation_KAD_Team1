package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Account;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

/**
 * API Account class.
 *
 * @author Ketty camacho.
 */
public class APIAccount {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Account account;
    private Account accountApi;
    protected Map<String, Object> fieldsMap;

    public APIAccount(Account account) {
        this.account = account;
        fieldsMap = covertEntityToMap();
        accountApi=new Account();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(ACCOUNT_NAME, account.getAccountName());
      map.put(ACCOUNT_NUMBER,account.getAccountNumber());
      map.put(ACCOUNT_FAX,account.getFax());
      map.put(ACCOUNT_PHONE, account.getPhone());
      map.put(ACCOUNT_TYPE,account.getType());
        return map;
    }

    /**
     *  this method get values by Api of Account.
     * @return
     */
    public Account getAccountValuesByAPI() { //ToDo define what aee you going to return
       // response = APIManager.getInstance().get("/sobjects/Account/" + account.getId() + "?fields=Name");
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(ACCOUNT).
                concat(SLASH).concat(account.getId()));
        accountApi.setAccountName(response.jsonPath().get(ACCOUNT_NAME).toString());
        accountApi.setAccountNumber(response.jsonPath().get(ACCOUNT_NUMBER).toString());
        accountApi.setFax(response.jsonPath().get(ACCOUNT_FAX).toString());
        accountApi.setPhone(response.jsonPath().get(ACCOUNT_PHONE).toString());
        accountApi.setType(response.jsonPath().get(ACCOUNT_TYPE).toString());

        return accountApi;
    }

    /**
     * this method Create Api
     */
    public void createAccountByAPI() {
        response = apiManager.post(ACCOUNT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        account.setId(response.jsonPath().get(ID).toString());
    }

    /**
     * this method delete Api
     */
    public void deleteAccountByAPI() {
        account.setId(response.jsonPath().get(ID).toString());
        response = apiManager.delete(ACCOUNT, account.getId());
        System.out.println("Query response delete: " + response.asString());
    }

}
