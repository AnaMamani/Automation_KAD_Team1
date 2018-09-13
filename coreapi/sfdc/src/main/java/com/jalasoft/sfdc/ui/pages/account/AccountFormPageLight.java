package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
   private  @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input" )
    WebElement phoneTxt;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    WebElement faxTxt;

//    @FindBy(id="acc6")
//    WebElement typeTxt;

    @FindBy (xpath="//span[text()='Billing City']/parent::label/following-sibling::input")
    WebElement billingCityTxt;

    @FindBy(xpath="//span[text()='Billing State/Province']/parent::label/following-sibling::input")
    WebElement billingStateTxt;

    @FindBy(xpath="//span[text()='Billing Country']/parent::label/following-sibling::input")
    WebElement billingCountryTxt;

//    @FindBy(xpath="00N0b000007FED5")
//    private  WebElement customerPriorityTxt;

    @FindBy(xpath="//span[text()='Number of Locations']/parent::label/following-sibling::input")
    private  WebElement numberLocationTxt;

    @FindBy (xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
    private WebElement clickBtnSave;

    @Override
    public AccountDetailPage createAccount(Account account){
        driverTools.setInputField(accountNameTxt,account.getAccountName());
        driverTools.setInputField(accountNumberTxt,account.getAccountNumber());
        driverTools.setInputField(phoneTxt,account.getPhone());
        driverTools.setInputField(faxTxt,account.getFax());
        // driverTools.selectListBoxByValue(typeTxt,account.getType());
        driverTools.setInputField(billingCityTxt,account.getBillingCity());
        driverTools.setInputField(billingStateTxt,account.getBillingState());
        driverTools.setInputField(billingCountryTxt,account.getBillingCountry());
        //driverTools.selectListBoxByValue(customerPriorityTxt,account.getCustomerPriority());
        driverTools.setInputField(numberLocationTxt,account.getNumberOfLocation());

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
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
