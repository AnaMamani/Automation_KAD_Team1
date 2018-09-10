package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.ui.BasePage;

public abstract class FormAccount extends BasePage {

    public abstract AccountDetail fillDataAccount(String accountName, String parentAccount, String accountNumber, String phone);
}
