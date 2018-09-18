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
    @FindBy(id= "acc11_ileinner")
    WebElement validatorFax;
    @FindBy(xpath = "//*[@id='topButtonRow']/input[3]")
    private WebElement editBtn;

    @FindBy(xpath = "//input[contains(@value,'Delete')]")
    private  WebElement deleteBtn;

    @Override
    public String validateAccountNew() {
        return validateAccount.getText().trim();
        //return validateNumber.getText().trim();
    }

    @Override
    public void validatorAccount(Account account) {
        log.info(account.getAccountNumber()+"################detail");
        log.info(validateNumber.getText()+"###############hola ");
        assertEquals(account.getAccountNumber(),validateNumber.getText().trim());
        assertEquals(account.getType(),validatorType.getText().trim());
        assertEquals(account.getPhone(),validatorPhone.getText().trim());
        assertEquals(account.getFax(),validatorFax.getText().trim());
    }

    @Override
    public AccountFormPage clickEditAccount() {
        driverTools.clickElement(editBtn);
        return new AccountFormPageClassic();
    }

    @Override
    public void deleteAnAccount() {
        driverTools.clickElement(deleteBtn);
        acceptAlertDialog();

    }



    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
