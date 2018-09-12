package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountFormPageClassic extends AccountFormPage {
   //this is locators .
    @FindBy(id="acc2")

    WebElement accountNameTxt;
    @FindBy(id ="acc5")

    WebElement accountNumberTxt;
    @FindBy(id="acc10")

    WebElement phoneTxt;
    @FindBy (xpath = "//*[@id='topButtonRow']/input[1]")

    WebElement clickBtnSave;

    /**
     * this is method fill date on the form new Account on Classic.
     * @param accountName account Name.
     * @param accountNumber account Number.
     * @param phone phone.
     * @return AccountDetailPage of Classic with action clickNewButton, detail of the new account created.
     */

    @Override
    public AccountDetailPage createAccount(String accountName, String accountNumber, String phone) {
        setAccountName(accountName);
        setAccountNumber(accountNumber);
        setPhone(phone);
        return clickNewButton();

    }

    /**
     * this method click new Button.
     * @return AccountDetailPageClassic.
     */

    private AccountDetailPage clickNewButton() {
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageClassic();
    }

    /**
     * setter of phone.
     * @param phone
     */
    private void setPhone(String phone) {
        driverTools.setInputField(phoneTxt,phone);
    }

    /**
     * this method setter account Number.
     * @param accountNumber
     */
    private void setAccountNumber(String accountNumber) {
        driverTools.setInputField(accountNumberTxt,accountNumber);
    }

    /**
     * this method setter account Name.
     * @param accountName
     */
    private void setAccountName(String accountName) {
        driverTools.setInputField(accountNameTxt,accountName);
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
