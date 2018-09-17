package com.jalasoft.sfdc.ui.pages.account;

/**
 * Handles the Account List Classic Page extends of the
 * {@Link AccountListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class AccountListPageClassic extends AccountListPage {


    /**
     * this is method clickNewAccount
     * @return AccountFormPage, it page is a form of Classic.
     */
    @Override
    public AccountFormPage clickNewAccount() {
        driverTools.clickElement(newBtn);
        return new AccountFormPageClassic();
    }


}
