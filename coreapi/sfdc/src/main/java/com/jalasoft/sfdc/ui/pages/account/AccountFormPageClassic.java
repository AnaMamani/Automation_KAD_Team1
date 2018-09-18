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
    @FindBy(id="acc2")
    WebElement accountNameTxt;

    @FindBy(id ="acc5")
    WebElement accountNumberTxt;

    @FindBy(id="acc10")
    WebElement phoneTxt;

    @FindBy(id="acc11")
    WebElement faxTxt;

    @FindBy(id="acc6")
    WebElement typeTxt;

    @FindBy (id="acc17city")
    WebElement billingCityTxt;

    @FindBy(id="acc17state")
    WebElement billingStateTxt;

    @FindBy(id="acc17country")
    WebElement billingCountryTxt;

    @FindBy(id="00N0b000007FED5")
    private  WebElement customerPriorityTxt;

    @FindBy(id="00N0b000007FED6")
    private  WebElement numberLocationTxt;

    @FindBy (xpath = "//*[@id='topButtonRow']/input[1]")
    WebElement clickBtnSave;

    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt,account.getAccountName());
        driverTools.setInputField(accountNumberTxt,account.getAccountNumber());
        driverTools.setInputField(phoneTxt,account.getPhone());
        driverTools.setInputField(faxTxt,account.getFax());
        driverTools.clickElement(typeTxt);
        log.info(account.getType());
        driverTools.clickElement(By.xpath("//select[@id='acc6']/option[contains(text(),'"+account.getType()+"')]"));
        driverTools.setInputField(billingCityTxt,account.getBillingCity());
        driverTools.setInputField(billingStateTxt,account.getBillingState());
        driverTools.setInputField(billingCountryTxt,account.getBillingCountry());
        //driverTools.selectListBoxByValue(customerPriorityTxt,account.getCustomerPriority());
        driverTools.setInputField(numberLocationTxt,account.getNumberOfLocation());
       return clickNewButton();
    }

    @Override
    public AccountDetailPage editAccount(Account account) {
        if (account.getAccountName()!=null)
            driverTools.setInputField(accountNameTxt,account.getAccountName());
        if (account.getAccountNumber()!=null)
            driverTools.setInputField(accountNumberTxt,account.getAccountNumber());
        if (account.getPhone()!=null)
            driverTools.setInputField(phoneTxt,account.getPhone());
        if (account.getFax()!=null)
            driverTools.setInputField(faxTxt,account.getFax());
        if (account.getBillingCity()!=null)
            driverTools.setInputField(billingCityTxt,account.getBillingCity());
        if (account.getBillingState()!=null)
            driverTools.setInputField(billingStateTxt,account.getBillingState());
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageClassic();
    }

    /**
     * this method click new Button.
     * @return AccountDetailPageClassic.
     */

    private AccountDetailPage clickNewButton() {
        driverTools.clickElement(clickBtnSave);
        return new AccountDetailPageClassic();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
