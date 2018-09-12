package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.ListBasePage;
/**
 * ContactListPage class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public abstract class ContactListPage  extends ListBasePage {


    /**
     *   Contact Class and ContactsLight
     * @return a PageFactory
     */
    public abstract ContactFormPage clickContactNew();

}
