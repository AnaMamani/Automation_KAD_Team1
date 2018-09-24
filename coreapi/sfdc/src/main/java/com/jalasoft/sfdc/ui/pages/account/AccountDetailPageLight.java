package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.junit.Assert.assertEquals;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageLight extends AccountDetailPage {

    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div/span/span")
    private WebElement accountNameTxt;

    @FindBy(xpath = "//span[contains(text(), 'Account Number')]/parent::div/following-sibling::div/span/span")
    private WebElement accountNumberTxt;

    @FindBy(xpath = "//span[contains(text(), 'Type')]/parent::div/following-sibling::div/span/span")
    private WebElement accountSelectTypeTxt;

    @FindBy(xpath = "//span[contains(text(), 'Phone')]/parent::div/following-sibling::div/span/span")
    private WebElement accountPhoneTxt;

    @FindBy(xpath = "//span[contains(text(), 'Fax')]/parent::div/following-sibling::div/span/span")
    private WebElement accountFaxTxt;

    @FindBy(xpath = "//a[@title='Details']")
    private WebElement optionDetail;

    @FindBy(xpath = "//div[@class='slds-media__body']//following::span[@class='slds-truncate uiOutputText']")
    private WebElement accountNameCreatedTxt;

    @FindBy(xpath = "//a[(@title='Edit')]")
    private WebElement selectOptionEdit;

    @FindBy(xpath = "//a[(@title='Delete')]")
    private WebElement selectOptionDelete;

    @FindBy(xpath = "//span[(text()='Delete')]")
    private WebElement selectDelete;

    @FindBy(xpath = "//a[(@title='Show 7 more actions')]")
    private WebElement selectBtn;

    /**
     * This method validate the Account New.
     *
     * @return of String of Name
     */

    @Override
    public String isSuccessDisplayedAccountDetail() {
        log.info("validateAccountNew =========> " + accountNameCreatedTxt.getText().trim());
        return accountNameCreatedTxt.getText().trim();

    }

    /**
     * This method a click on edit an Account
     *
     * @return AccountFormPageLight() Account Form page of Light
     */
    @Override
    public AccountFormPage clickEditAccount() {
        driverTools.clickElement(selectBtn);
        driverTools.clickElement(selectOptionEdit);
        return new AccountFormPageLight();
    }

    /**
     * This method delete an Account of page Light
     */
    @Override
    public void deleteAnAccount() {
        driverTools.clickElement(selectBtn);
        driverTools.clickElement(selectOptionDelete);
        driverTools.clickElement(selectDelete);
    }
    /**
     * verify that a account is create.
     *
     * @param account information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessCreateAccount(Account account) {
        driverTools.clickElement(optionDetail);
        saveAccountId(driver.getCurrentUrl(),account);
        return account.getAccountNumber().equals(accountNumberTxt.getText()) &&
                account.getType().equals(accountSelectTypeTxt.getText()) &&
                account.getPhone().equals(accountPhoneTxt.getText()) && account.getFax().equals(accountFaxTxt.getText());
    }

    /**
     *  @param currentUrl url.
     *  @param account Account.
     */
    private void saveAccountId(String currentUrl, Account account) {

        String[] url=currentUrl.split("/");
        account.setId(url[url.length-1]);
        System.out.println("ID: "+url[url.length-1]+" THIS IS THE ACCOUNT ID");

    }

    /**
     *
     * @param account information the current user.
     * @return boolean
     */
    @Override
    public boolean isSuccessEditAccount(Account account) {
        driverTools.clickElement(optionDetail);
        boolean result = true;
        if (account.getAccountNumber() != null && !account.getAccountNumber().equals(accountNumberTxt.getText().trim())) {
            log.info("product name :" + account.getAccountNumber() + " ====> " + accountNumberTxt.getText().trim());
            return false;
        }

        if (account.getPhone() != null && !account.getPhone().equals(accountPhoneTxt.getText().trim())) {
            log.info("product code :" + account.getPhone() + " ====> " + accountPhoneTxt.getText().trim());
            return false;
        }
        if (account.getFax()!= null && !account.getFax().equals(accountFaxTxt.getText().trim())) {
            log.info("product name :" + account.getFax() + " ====> " + accountFaxTxt.getText().trim());
            return false;
        }
        return result;
        }

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountNameCreatedTxt));
    }
}

