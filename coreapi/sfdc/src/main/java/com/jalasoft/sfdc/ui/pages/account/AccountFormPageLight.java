package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Handles the Account form Page Light extends of the
 * {@Link AccountFormPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class AccountFormPageLight extends AccountFormPage {

    // it is web element locators.

    @FindBy(xpath = ".//input[@class='input uiInput uiInputText uiInput--default uiInput--input']")
   private WebElement accountNameTxt;
    @FindBy(xpath = ".//input[@title='Search Accounts']")
   private WebElement parentL;
    @FindBy(xpath = "//input[contains(@data-interactive-lib-uid,'10')]" )
    WebElement accountNumberTxt;
   private  @FindBy(xpath = "//input[@data-interactive-lib-uid='7']" )
    WebElement phoneTxt;
    @FindBy (xpath = "button[@title='Save']")

   private WebElement clickBtnSave;

    /**
     * this is method fill date on the form new Account on Light.
     * @param accountName account name.
     * @param accountNumber Account Number.
     * @param phone Phone.
     * @return AccountDetailPage of Light, detail of the new account created.
     */
    @Override
    public AccountDetailPage createAccount(String accountName, String accountNumber, String phone) {
        setAccountName(accountName);
        setAccountNumber(accountNumber);
        setPhone(phone);
        return clickNewButtonLight();

    }

    /**
     * this is method  to da click button New Light.
     * @return AccountDetailPage Account detail Page Light.
     */
    private AccountDetailPage clickNewButtonLight() {
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageLight();
    }

    /**
     * it method set of Phone.
     * @param phone number cel.
     */
    private void setPhone(String phone) {
        driverTools.setInputField(phoneTxt,phone);
    }

    /**
     * this method setter of account Number.
     * @param accountNumber number of Account.
     */
    private void setAccountNumber(String accountNumber) {
        driverTools.setInputField(accountNumberTxt,accountNumber);
    }

    /**
     * this method setter Name of account.
     * @param accountName name of account.
     */
    private void setAccountName(String accountName) {
        driverTools.setInputField(accountNameTxt,accountName);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
