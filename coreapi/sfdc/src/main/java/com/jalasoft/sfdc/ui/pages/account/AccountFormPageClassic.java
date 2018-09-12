package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt,account.getAccountName());
        driverTools.setInputField(accountNumberTxt,account.getAccountNumber());
        driverTools.setInputField(phoneTxt,account.getPhone());
//        setAccountName(accountName);
//        setAccountNumber(accountNumber);
//        setPhone(phone);
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

//    /**
//     * setter of phone.
//     * @param phone
//     */
//    private void setPhone(String phone) {
//        driverTools.setInputField(phoneTxt,phone);
//    }
//
//    /**
//     * this method setter account Number.
//     * @param accountNumber
//     */
//    private void setAccountNumber(String accountNumber) {
//        driverTools.setInputField(accountNumberTxt,accountNumber);
//    }
//
//    /**
//     * this method setter account Name.
//     * @param "accountName"
//     */
////    private void setAccountName(String accountName) {
//        driverTools.setInputField(accountNameTxt,accountName);
//    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
