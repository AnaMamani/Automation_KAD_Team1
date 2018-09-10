package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class AccountListPage extends BasePage {

    public abstract  FormAccount clickNewAccount();

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
