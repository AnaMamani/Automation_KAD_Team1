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

    public abstract AccountListPage deleteAnAccount();

    /**
     * verify that a account is create.
     *
     * @param account information the current user.
     * @return is successfully or not successfully.
     */
    public abstract boolean isSuccessCreateAccount(Account account);

    /**
     * verify the edit the account.
     *
     * @param account information the current user.
     */

    public abstract boolean isSuccessEditAccount(Account account);

    /**
     * verify the edit the Account.
     *
     * @param accountApi  information the current user by API.
     * @param accountEdit information the current user.
     */
    public boolean isSuccessEditAccountByAPI(Account accountApi, Account accountEdit) {
        log.info("isSuccessEditAccountByAPI:   ");
        boolean result = true;
        if (accountEdit.getAccountName() != null && !accountEdit.getAccountName().equals(accountApi.getAccountName())) {
            log.info("Account name :" + accountEdit.getAccountName() + " ====> " + accountApi.getAccountName());
            return false;
        }

        if (accountEdit.getAccountNumber() != null && !(accountEdit.getAccountNumber().equals(accountApi.getAccountNumber()))) {
            log.info("product code :" + accountEdit.getAccountNumber() + " ====> " + accountApi.getAccountNumber());
            return false;
        }
        if (accountEdit.getPhone() != null && !accountEdit.getPhone().equals(accountApi.getPhone())) {
            log.info("product Phone :" + accountEdit.getPhone() + " ====> " + accountApi.getPhone());
            return false;
        }
        if (accountEdit.getFax() != null && !accountEdit.getFax().equals(accountApi.getFax())) {
            log.info("product fax :" + accountEdit.getFax() + " ====> " + accountApi.getFax());
            return false;
        }
        return result;
    }
}

