package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//input[contains(@data-interactive-lib-uid,'10')]")
    WebElement accountNumberTxt;

    private @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    WebElement phoneTxt;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    WebElement faxTxt;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    WebElement typeTxt;

//    @FindBy(id="acc6")
//    WebElement typeTxt;

    @FindBy(xpath = "//span[text()='Billing City']/parent::label/following-sibling::input")
    WebElement billingCityTxt;

    @FindBy(xpath = "//span[text()='Billing State/Province']/parent::label/following-sibling::input")
    WebElement billingStateTxt;

    @FindBy(xpath = "//span[text()='Billing Country']/parent::label/following-sibling::input")
    WebElement billingCountryTxt;

//    @FindBy(xpath="00N0b000007FED5")
//    private  WebElement customerPriorityTxt;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::label/following-sibling::input")
    private WebElement numberLocationTxt;
    @FindBy(xpath = "//span[text()='Type']/../..//a[contains(@class,'select')]")
    WebElement typeSelected;


    @FindBy(xpath = "//span[text()='Save']/parent::button[@title='Save']")
    private WebElement clickBtnSave;

    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt, account.getAccountName());
        driverTools.setInputField(accountNumberTxt, account.getAccountNumber());
        driverTools.setInputField(phoneTxt, account.getPhone());
        driverTools.setInputField(faxTxt, account.getFax());
        driverTools.clickElement(typeSelected);
        driverTools.clickElement(By.xpath("//div[contains(@class,'select-options')] //li[contains(@role,'presentation')]/a[contains(@title,'" + account.getType() + "')]"));
        driverTools.setInputField(billingCityTxt, account.getBillingCity());
        driverTools.setInputField(billingStateTxt, account.getBillingState());
        driverTools.setInputField(billingCountryTxt, account.getBillingCountry());
        //driverTools.selectListBoxByValue(customerPriorityTxt,account.getCustomerPriority());
        driverTools.setInputField(numberLocationTxt, account.getNumberOfLocation());

        return clickNewButtonLight();

    }

    @Override
    public AccountDetailPage editAccount(Account account) {
        if (account.getAccountName() != null)
            driverTools.setInputField(accountNameTxt, account.getAccountName());
        if (account.getAccountNumber() != null)
            driverTools.setInputField(accountNumberTxt, account.getAccountNumber());
        if (account.getPhone() != null)
            driverTools.setInputField(phoneTxt, account.getPhone());
        if (account.getFax() != null)
            driverTools.setInputField(faxTxt, account.getFax());
        if (account.getBillingCity() != null)
            driverTools.setInputField(billingCityTxt, account.getBillingCity());
        if (account.getBillingState() != null)
            driverTools.setInputField(billingStateTxt, account.getBillingState());
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageLight();
    }

    /**
     * this is method  to da click button New Light.
     *
     * @return AccountDetailPage Account detail Page Light.
     */
    private AccountDetailPage clickNewButtonLight() {
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageLight();
    }

    /**
     * it method set of Phone.
     *
     * @param phone number cel.
     */
    private void setPhone(String phone) {
        driverTools.setInputField(phoneTxt, phone);
    }

    /**
     * this method setter of account Number.
     *
     * @param accountNumber number of Account.
     */
    private void setAccountNumber(String accountNumber) {
        driverTools.setInputField(accountNumberTxt, accountNumber);
    }

    /**
     * this method setter Name of account.
     *
     * @param accountName name of account.
     */
    private void setAccountName(String accountName) {
        driverTools.setInputField(accountNameTxt, accountName);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
