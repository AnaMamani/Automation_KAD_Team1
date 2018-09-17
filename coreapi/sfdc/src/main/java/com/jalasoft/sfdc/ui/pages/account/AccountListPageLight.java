package com.jalasoft.sfdc.ui.pages.account;


/**
 * Handles the Account List Light Page extends of the
 * {@Link AccountListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountListPageLight extends AccountListPage {

    /**
     * this is method clickNewAccount
     * @return AccountFormPage , it page is a form of Light.
     */
    @Override
    public AccountFormPage clickNewAccount() {
        driverTools.clickElement(newBtn);
        return new AccountFormPageLight();

    }


}
