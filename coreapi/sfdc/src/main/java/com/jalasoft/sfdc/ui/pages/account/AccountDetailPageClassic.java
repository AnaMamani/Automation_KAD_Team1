package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import com.typesafe.config.ConfigException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageClassic extends AccountDetailPage {

    @FindBy(xpath = "//h2[contains(@class,'topName')]")
    WebElement validateAccount;
    @FindBy(xpath = " //* [@id='acc5_ileinner']")
    WebElement validateNumber;
    @FindBy(xpath = "//td[contains(@class,'dataCol col02 inlineEditWrite')]/child::div[@id='acc6_ileinner']")
    WebElement validatorType;
    @FindBy(id = "acc10_ileinner")
    WebElement validatorPhone;
    @FindBy(id = "acc11_ileinner")
    WebElement validatorFax;
    @FindBy(xpath = "//*[@id='topButtonRow']/input[3]")
    private WebElement editBtn;

    @FindBy(xpath = "//input[contains(@value,'Delete')]")
    private WebElement deleteBtn;

    /**
     * This method validate Account
     *
     * @return string, of validate date Account
     */
    @Override
    public String validateAccountNew() {
        return validateAccount.getText().trim();
    }

    /**
     * This method validate of details of account create
     *
     * @param account Account.
     */
    @Override
    public void validatorAccount(Account account) {
        log.info(account.getAccountNumber() + "################detail");
        log.info(validateNumber.getText() + "###############hola ");
        assertEquals("Account Number correctly", account.getAccountNumber(), validateNumber.getText().trim());
        assertEquals("Type correctly", account.getType(), validatorType.getText().trim());
        assertEquals("the number Phone correctly", account.getPhone(), validatorPhone.getText().trim());
        assertEquals("The number Fax correctly", account.getFax(), validatorFax.getText().trim());
    }

    /**
     * This method to event click Edit Accout
     *
     * @return AccountFormPagecasseer
     */
    @Override
    public AccountFormPage clickEditAccount() {
        driverTools.clickElement(editBtn);
        return new AccountFormPageClassic();
    }

    /**
     * This method delete an Account on Classic
     */
    @Override
    public void deleteAnAccount() {
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();

    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
