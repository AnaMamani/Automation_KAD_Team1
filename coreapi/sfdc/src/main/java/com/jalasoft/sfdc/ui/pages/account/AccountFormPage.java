package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.BasePage;

/**
 * Handles the Account form Page extends of the
 * {@Link BasePage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public abstract class AccountFormPage extends BasePage {
    /**
     * this method abstract click for New Account on Light and Classic.
     * @return a new AccountDetailPage.
     */

    public abstract AccountDetailPage createAccount(Account account);

    public abstract AccountDetailPage editAccount(Account account);
}
