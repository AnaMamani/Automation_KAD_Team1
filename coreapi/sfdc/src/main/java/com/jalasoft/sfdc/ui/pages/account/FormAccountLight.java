package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAccountLight extends FormAccount {

    @FindBy(xpath = ".//input[@class='input uiInput uiInputText uiInput--default uiInput--input']")
    WebElement nameL;
    @FindBy(xpath = ".//input[@title='Search Accounts']")
    WebElement parentL;
    @FindBy(xpath = "//*[@id='231:815;a']")
    WebElement numberL;
    @FindBy(xpath = "//*[@id='115:815;a']")
    WebElement celL;
    @FindBy (xpath = "/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/button[3]/span")

    WebElement btnSave;
    @Override
    public AccountDetail fillDataAccount(String accountName, String parentAccount, String accountNumber, String phone) {
        setAccountName(accountName);
        setParentAccount(parentAccount);
        setAccountNumber(accountNumber);
        setPhone(phone);
        return clickNewButtonLight();

    }
    private AccountDetail clickNewButtonLight() {
        driverTools.clickElement(btnSave);
        return new AccountDetailLight();
    }

    private void setPhone(String phone) {
        driverTools.setInputField(celL,phone);
    }

    private void setAccountNumber(String accountNumber) {
        driverTools.setInputField(numberL,accountNumber);
    }

    private void setParentAccount(String parentAccount) {
        driverTools.setInputField(parentL,parentAccount);
    }

    private void setAccountName(String accountName) {
        driverTools.setInputField(nameL,accountName);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
