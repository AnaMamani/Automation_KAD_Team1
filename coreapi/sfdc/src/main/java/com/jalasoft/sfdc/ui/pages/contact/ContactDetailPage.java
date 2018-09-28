package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import com.jalasoft.sfdc.ui.BasePage;
/**
 * ContactDetailPage class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public abstract class ContactDetailPage extends BasePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }


    /**
     * For show create contact in ContactDetail.
     * @return String.
     */
    public abstract String isSuccessDisplayedContactDetail();

    /**
     * Edit contact of contact detail.
     * @return ContactFormPage.
     */
    public abstract ContactFormPage clickEditOption();

    /**
     * Delete Contact of contact detail.
     * @return ContactListPage.
     */
    public abstract ContactListPage deleteContact();


    /**
     * Validate with detail.
     */

    public abstract boolean isSuccessEditContact(Contact contact);


    public  boolean isSuccessEditAccountByAPI(Contact contactApi, Contact contact){
        log.info("isSuccessEditContact:   ");
        boolean result = true;
        System.out.println(contact.getFirstName()+"////");
        System.out.println(contactApi.getFirstName()+"****");
        System.out.println(contact.getLastName()+"////");
        System.out.println(contactApi.getLastName()+"****");
        System.out.println(contact.getPhone()+"////");
        System.out.println(contactApi.getPhone()+"***");

        if (contact.getFirstName() != null && contact.getLastName() != null && !contact.getFirstName()
                .concat(" ").concat(contact.getLastName()).equals(contactApi.getFirstName().concat(" ").concat(contactApi.getLastName()))) {
            System.out.println("hola");
            return false;
        }
        if (contact.getPhone() != null && !contact.getPhone().equals(contactApi.getPhone())) {

            return false;
        }
        if (contact.getTitle() != null && !contact.getTitle().equals(contactApi.getTitle())) {
            return false;
        }
        return result;
    }

}
