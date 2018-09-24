package com.jalasoft.sfdc.ui.pages.account;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;
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

    public abstract String isSuccessDisplayedAccountDetail();

    /**
     * This is method abstract for event click on edit an Account.
     *
     * @return AccountFormPage.
     */

    public abstract AccountFormPage clickEditAccount();

    /**
     * this class is abstract for delete a Account
     */

    public abstract void deleteAnAccount();
    /**
     * verify that a account is create.
     * @param account information the current user.
     * @return is successfully or not successfully.
     */
    public abstract boolean isSuccessCreateAccount(Account account);
    /**
     * verify the edit the account.
     * @param account information the current user.
     */

    public abstract boolean isSuccessEditAccount(Account account);
}

