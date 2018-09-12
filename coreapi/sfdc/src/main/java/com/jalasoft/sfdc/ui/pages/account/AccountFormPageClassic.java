package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
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

    @FindBy (xpath = "//*[@id='topButtonRow']/input[1]")
    WebElement clickBtnSave;


    @Override
    public AccountDetailPage createAccount(Account account) {
        driverTools.setInputField(accountNameTxt,account.getAccountName());
        driverTools.setInputField(accountNumberTxt,account.getAccountNumber());
        driverTools.setInputField(phoneTxt,account.getPhone());

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

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(clickBtnSave));

    }
}
