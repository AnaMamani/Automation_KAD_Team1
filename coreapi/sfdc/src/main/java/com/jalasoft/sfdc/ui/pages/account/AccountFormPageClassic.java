package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles the Account form Page Classic extends of the
 * {@Link AccountFormPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class AccountFormPageClassic extends AccountFormPage {
    //this is locators .
    @FindBy(id = "acc2")
    private WebElement accountNameTxt;

    @FindBy(id = "acc5")
    private WebElement accountNumberTxt;

    @FindBy(id = "acc10")
    private WebElement phoneTxt;

    private @FindBy(id = "acc11")
    WebElement faxTxt;

    @FindBy(id = "acc6")
    private WebElement typeTxt;

    @FindBy(id = "acc17city")
    private WebElement billingCityTxt;

    @FindBy(id = "acc17state")
    private WebElement billingStateTxt;

    @FindBy(id = "acc17country")
    private WebElement billingCountryTxt;

    @FindBy(id = "00N0b000007FED5")
    private WebElement customerPriorityTxt;

    @FindBy(id = "00N0b000007FED6")
    private WebElement numberLocationTxt;

    @FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
    WebElement clickBtnSave;

    /**
     * This method setter for create an Account
     *
     * @param account Account
     * @return AccountDetailpage.
     */
    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt, account.getAccountName());
        driverTools.setInputField(accountNumberTxt, account.getAccountNumber());
        driverTools.setInputField(phoneTxt, account.getPhone());
        driverTools.setInputField(faxTxt, account.getFax());
        driverTools.clickElement(typeTxt);
        log.info(account.getType());
        driverTools.clickElement(By.xpath("//select[@id='acc6']/option[contains(text(),'" + account.getType() + "')]"));
        driverTools.setInputField(billingCityTxt, account.getBillingCity());
        driverTools.setInputField(billingStateTxt, account.getBillingState());
        driverTools.setInputField(billingCountryTxt, account.getBillingCountry());
        //driverTools.selectListBoxByValue(customerPriorityTxt,account.getCustomerPriority());
        driverTools.setInputField(numberLocationTxt, account.getNumberOfLocation());

        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageClassic();
    }

    /**
     * This method is edit Account
     *
     * @param account of Account
     * @return AccountDetailPageClassic
     */
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
        return new AccountDetailPageClassic();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
