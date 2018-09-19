package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

import java.util.List;

/**
 * Handles the Account Detail Page.
 *
 * @author Ketty Camacho Vasquez
 */
public abstract class AccountDetailPage extends BasePage {
    /**
     * This method abstract for validator an Account new
     *
     * @return String name that was create .
     */

    public abstract String validateAccountNew();

    /**
     * This method abstract for validator an Account.
     *
     * @param account Account.
     */
    public abstract void validatorAccount(Account account);

    /**
     * This method abstract for event click on edit an Account.
     *
     * @return AccountFormPage.
     */

    public abstract AccountFormPage clickEditAccount();

    /**
     * this class is abstract for delete a Account
     */

    public abstract void deleteAnAccount();

}
