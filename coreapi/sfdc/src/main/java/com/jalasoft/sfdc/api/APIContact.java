package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.entities.Contact;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;

public class APIContact {

    protected APIManager apiManager = APIManager.getInstance();
    protected Response response;
    private final Contact contact;
    private Contact contactApi;
    protected Map<String, Object> fieldsMap;


    /**
     * Contructor for contact
     *
     * @param contact
     */
    public APIContact(Contact contact) {
        this.contact = contact;
        fieldsMap = covertEntityToMap();
        contactApi = new Contact();
    }

    /**
     * <p>This method converts the </p>
     *
     * @return
     */
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(CONTACT_FIRST_NAME, contact.getFirstName());
        map.put(CONTACT_LAST_NAME, contact.getLastName());
        map.put(CONTACT_TITLE, contact.getTitle());
        map.put(CONTACT_EMAIL, contact.getEmail());
        map.put(CONTACT_PHONE, contact.getPhone());
        map.put(CONTACT_STREET, contact.getStreet());
        map.put(CONTACT_CITY, contact.getCity());
        map.put(CONTACT_STATE, contact.getState());
        map.put(CONTACT_COUNTRY, contact.getCountry());// more data
        return map;
    }

    /**
     * validate by API for Contact
     *
     * @return a contact
     */
    public Contact getContactValuesByAPI() { //ToDo define what aee you going to return
        response = APIManager.getInstance().get(SLASH.concat(SOBJECTS).concat(SLASH).concat(CONTACT).
                concat(SLASH).concat(contact.getId()));
        contactApi.setFirstName(response.jsonPath().get(CONTACT_FIRST_NAME).toString());
        contactApi.setLastName(response.jsonPath().get(CONTACT_LAST_NAME).toString());
        contactApi.setTitle(response.jsonPath().get(CONTACT_TITLE).toString());
        contactApi.setEmail(response.jsonPath().get(CONTACT_EMAIL).toString());
        contactApi.setPhone(response.jsonPath().get(CONTACT_PHONE).toString());
        contactApi.setStreet(response.jsonPath().get(CONTACT_STREET).toString());
        contactApi.setCity(response.jsonPath().get(CONTACT_CITY).toString());
        contactApi.setState(response.jsonPath().get(CONTACT_STATE).toString());
        contactApi.setCountry(response.jsonPath().get(CONTACT_COUNTRY).toString());
        return contactApi;
    }

    /**
     *for create
     */
    public void createContactByAPI() {
        response = apiManager.post(CONTACT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        contact.setId(response.jsonPath().get(ID).toString());
    }
    /**
     *for edit
     */
    public void editContactByAPI() {
        response = apiManager.post(CONTACT, fieldsMap);
        System.out.println("Query response create: " + response.asString());
        contact.setId(response.jsonPath().get(ID).toString());
    }
    /**
     * for delete
     */
    public void deleteContactByAPI() {
        response = apiManager.delete(CONTACT, contact.getId());
        System.out.println("Query response delete: " + response.asString());
    }
}
