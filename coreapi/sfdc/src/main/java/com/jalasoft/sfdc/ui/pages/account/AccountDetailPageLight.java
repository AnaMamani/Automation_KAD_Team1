package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageLight extends AccountDetailPage {

    @FindBy(xpath = "//a[@title='Details']")
    private WebElement detail;

    @FindBy(xpath = "//div[@class='slds-media__body']//following::span[@class='slds-truncate uiOutputText']")
    private WebElement detailsName;

    @FindBy(xpath = "//a[(@title='Edit')]")
    private WebElement selectOptionEdit;

    @FindBy(xpath = "//a[(@title='Delete')]")
    private WebElement selectOptionDelete;

    @FindBy(xpath = "//span[(text()='Delete')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "(//span[@class='uiOutputText'])[3]")
    private WebElement validateNameTxt;

    @FindBy(xpath = "(//span[contains(@class,'separator')])[7]")
    private WebElement validateNumber;

    @FindBy(xpath = "(//span[contains(@class,'separator')])[11]")
    private WebElement validatorType;

    @FindBy(xpath = "(//span[contains(@class,'separator')])[4]")
    private WebElement validatorPhone;

    @FindBy(xpath = "(//span[contains(@class,'separator')])[6]")
    private WebElement validatorFax;

    @FindBy(xpath = "//a[(@title='Show 7 more actions')]")
    private WebElement selectBtn;

    /**
     * This method validate the Account New.
     *
     * @return of String of Name
     */

    @Override
    public String validateAccountNew() {
        log.info("validateAccountNew =========> " + detailsName.getText().trim());
        return detailsName.getText().trim();

    }

    /**
     * This method Validate of details that was created
     *
     * @param account of Account object
     */
    @Override
    public void validatorAccount(Account account) {
        driverTools.clickElement(detail);
        log.info(account.getAccountNumber() + "################detail");
        log.info(validateNumber.getText() + "###############hola ");
        assertEquals(account.getAccountNumber(), validateNumber.getText().trim());
        assertEquals(account.getType(), validatorType.getText().trim());
        assertEquals(account.getPhone(), validatorPhone.getText().trim());
        assertEquals(account.getFax(), validatorFax.getText().trim());

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
        driverTools.clickElement(deleteBtn);
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
