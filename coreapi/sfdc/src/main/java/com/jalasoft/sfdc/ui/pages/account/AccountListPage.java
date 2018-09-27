package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.ListBasePage;

/**
 * Handles the Account List Page extends of the
 * {@Link ListBasePage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public abstract class AccountListPage extends ListBasePage {


    /**
     * this method abstract click for New Account on Light and Classic.
     *
     * @return new AccountFormPage
     */

    public abstract AccountFormPage clickNewAccount();


    /**
     * This method abstract search a account
     *
     * @param account Account
     * @return a boolean (true,false )
     */
    public abstract boolean accountSearch(Account account);
}
