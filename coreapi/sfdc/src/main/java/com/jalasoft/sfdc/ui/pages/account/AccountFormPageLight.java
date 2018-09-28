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

    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::input")
    private WebElement accountNameTxt;

    @FindBy(xpath = ".//input[@title='Search Accounts']")
    private WebElement parentL;

    @FindBy(xpath = "//span[text()='Account Number']/parent::label/following-sibling::input")
    private WebElement accountNumberTxt;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    private WebElement accountPhoneTxt;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    private WebElement accountFaxTxt;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    private WebElement accountSelectTypeTxt;

    @FindBy(xpath = "//span[text()='Billing City']/parent::label/following-sibling::input")
    private WebElement accountBillingCityTxt;

    @FindBy(xpath = "//span[text()='Billing State/Province']/parent::label/following-sibling::input")
    private WebElement accountBillingStateTxt;

    @FindBy(xpath = "//span[text()='Billing Country']/parent::label/following-sibling::input")
    private WebElement accountBillingCountryTxt;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::label/following-sibling::input")
    private WebElement accountNumberLocationTxt;

    @FindBy(xpath = "//span[text()='Type']/../..//a[contains(@class,'select')]")
    private WebElement typeSelected;

    @FindBy(xpath = "//span[text()='Save']/parent::button[@title='Save']")
    private WebElement clickBtnSave;

    @FindBy(xpath = "//p[@title='Website']")
    private WebElement auxToAccountId;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }

    /**
     * This method setter for create an Account
     *
     * @param account Account
     * @return AccountDetailpageLight.
     */
    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt, account.getAccountName());
        driverTools.setInputField(accountNumberTxt, account.getAccountNumber());
        driverTools.setInputField(accountPhoneTxt, account.getPhone());
        driverTools.setInputField(accountFaxTxt, account.getFax());
        driverTools.clickElement(typeSelected);
        driverTools.clickElement(By.xpath("//div[contains(@class,'select-options')] //li[contains(@role,'presentation')]/a[contains(@title,'" + account.getType() + "')]"));
        driverTools.setInputField(accountBillingCityTxt, account.getBillingCity());
        driverTools.setInputField(accountBillingStateTxt, account.getBillingState());
        driverTools.setInputField(accountBillingCountryTxt, account.getBillingCountry());
        driverTools.setInputField(accountNumberLocationTxt, account.getNumberOfLocation());
        driverTools.clickElement(clickBtnSave);
        wait.until(ExpectedConditions.visibilityOf(auxToAccountId));


        saveProductId(driver.getCurrentUrl(), account);

        return new AccountDetailPageLight();

    }

    /**
     * @param currentUrl url.
     * @param account    product.
     */
    private void saveProductId(String currentUrl, Account account) {

        String[] url = currentUrl.split("/");
        account.setId(url[url.length - 2]);
        System.out.println("ID: " + url[url.length - 2] + " THIS IS THE PRODUCT ID");

    }

    /**
     * This method is edit Account
     *
     * @param account of Account
     * @return AccountDetailPageLight
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
        driverTools.sleepMilliSeconds(5000);
        return new AccountDetailPageLight();
    }


}





