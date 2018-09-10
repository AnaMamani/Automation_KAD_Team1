package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAccountClassic extends FormAccount {

    @FindBy(xpath = ".//*[@id='acc2']")
    WebElement name;
    @FindBy(xpath = ".//*[@id='acc3']")
    WebElement parent;
    @FindBy(xpath = ".//*[@id='acc5']")
    WebElement number;
    @FindBy(xpath = ".//*[@id='acc10']")
    WebElement cel;
    @FindBy (xpath = ".//*[@id='topButtonRow']/input[1]")
    WebElement btn;



    @Override
    public AccountDetail fillDataAccount(String accountName, String parentAccount, String accountNumber, String phone) {
        setAccountName(accountName);
        setParentAccount(parentAccount);
        setAccountNumber(accountNumber);
        setPhone(phone);
        return clickNewButton();

    }

    private AccountDetail clickNewButton() {
        driverTools.clickElement(btn);
        return new AccountDetailClassic();
    }

    private void setPhone(String phone) {
        driverTools.setInputField(cel,phone);
    }

    private void setAccountNumber(String accountNumber) {
        driverTools.setInputField(number,accountNumber);
    }

    private void setParentAccount(String parentAccount) {
        driverTools.setInputField(parent,parentAccount);
    }

    private void setAccountName(String accountName) {
        driverTools.setInputField(name,accountName);
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
