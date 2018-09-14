package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.ui.BasePage;

/**
 * Handles the Account Detail Page.
 *
 *
 * @author Ketty Camacho Vasquez
 */
public abstract class AccountDetailPage extends BasePage {
    public abstract String validateAccountNew();

    public abstract AccountFormPage clickEditAcoount();
}
