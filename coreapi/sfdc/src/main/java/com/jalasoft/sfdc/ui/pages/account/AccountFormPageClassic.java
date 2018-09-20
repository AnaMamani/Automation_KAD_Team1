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
    private WebElement accountPhoneTxt;

    private @FindBy(id = "acc11")
    WebElement accountFaxTxt;

    @FindBy(id = "acc6")
    private WebElement accountTypeTxt;

    @FindBy(id = "acc17city")
    private WebElement accountBillingCityTxt;

    @FindBy(id = "acc17state")
    private WebElement accountBillingStateTxt;

    @FindBy(id = "acc17country")
    private WebElement accountBillingCountryTxt;

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
        driverTools.setInputField(accountPhoneTxt, account.getPhone());
        driverTools.setInputField(accountFaxTxt, account.getFax());
        driverTools.clickElement(accountTypeTxt);
        log.info(account.getType());
        driverTools.clickElement(By.xpath("//select[@id='acc6']/option[contains(text(),'" + account.getType() + "')]"));
        driverTools.setInputField(accountBillingCityTxt, account.getBillingCity());
        driverTools.setInputField(accountBillingStateTxt, account.getBillingState());
        driverTools.setInputField(accountBillingCountryTxt, account.getBillingCountry());
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
            driverTools.setInputField(accountPhoneTxt, account.getPhone());
        if (account.getFax() != null)
            driverTools.setInputField(accountFaxTxt, account.getFax());
        if (account.getBillingCity() != null)
            driverTools.setInputField(accountBillingCityTxt, account.getBillingCity());
        if (account.getBillingState() != null)
            driverTools.setInputField(accountBillingStateTxt, account.getBillingState());
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageClassic();
    }
    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));
    }
}
