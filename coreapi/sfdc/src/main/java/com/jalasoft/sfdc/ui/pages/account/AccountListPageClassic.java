package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountListPageClassic extends AccountListPage {


    @FindBy(xpath = ".//*[@id='hotlist']/table/tbody/tr/td[2]/input")
    WebElement clickBtn;
    @Override
    public FormAccount clickNewAccount() {
        driverTools.clickElement(clickBtn);
        return new FormAccountClassic();
    }
}
