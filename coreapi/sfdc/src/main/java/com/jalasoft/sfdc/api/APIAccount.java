package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Account;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;


public class APIAccount {
    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Account account;
    private Account accountApi;
    protected Map<String, Object> fieldsMap;
//    protected Map<String, Object> fieldsMapRemove;

    public APIAccount(Account account) {
        this.account = account;
        fieldsMap = covertEntityToMap();
//        fieldsMapRemove=removeToMap();
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
//    map.put("Website", account.getWeb());
//    map.put("Description", account.getDescription());
      map.put(ACCOUNT_NUMBER,account.getAccountNumber());
      map.put(ACCOUNT_FAX,account.getFax());
      map.put(ACCOUNT_PHONE, account.getPhone());
      map.put(ACCOUNT_TYPE,account.getType());
//    map.put("Industry", account.getSector());
//    map.put("NumberOfEmployees", account.getEmployees());
        return map;
    }

//    protected Map<String, Object> removeToMap() {
//        Map<String, Object> map = new HashMap<>();
//        map.remove(ACCOUNT_NAME, account.getAccountName());
////    map.put("Website", account.getWeb());
////    map.put("Description", account.getDescription());
//        map.remove(ACCOUNT_NUMBER,account.getAccountNumber());
//        map.remove(ACCOUNT_FAX,account.getFax());
//        map.remove(ACCOUNT_PHONE, account.getPhone());
//        map.remove(ACCOUNT_TYPE,account.getType());
////    map.put("Industry", account.getSector());
////    map.put("NumberOfEmployees", account.getEmployees());
//        return map;
//    }
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

    public void createAccountByAPI() {
        response = apiManager.post(ACCOUNT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        account.setId(response.jsonPath().get(ID).toString());
    }

    public void deleteAccountByAPI() {
        account.setId(response.jsonPath().get(ID).toString());
        response = apiManager.delete(ACCOUNT, account.getId());
        System.out.println("Query response delete: " + response.asString());
    }

//    public void editAccountByAPI() {
//        response=apiManager.put(ACCOUNT,account.getId());
//        System.out.println("Query response create: " + response.asString());
//
//
//    }
}
