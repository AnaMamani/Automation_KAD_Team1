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

   // @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon' ]//parent::span)[1]")
    @FindBy (xpath  ="(//span[@data-aura-class='uiOutputText'])[7]")
    private WebElement detailsName;

    @FindBy(xpath = "//a[(@title='Edit')]")
    private WebElement selectOptionEdit;

    @FindBy(xpath = "//a[(@title='Delete')]")
    private WebElement selectOptionDelete;

    @FindBy(xpath = "//span[(text()='Delete')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "(//span[@class='uiOutputText'])[3]")
    private WebElement validateNameTxt;

    @FindBy (xpath = "(//span[contains(@class,'separator')])[7]")
    private WebElement validateNumber;

    @FindBy (xpath = "(//span[contains(@class,'separator')])[7]")
    private WebElement validatorType;

    @FindBy (xpath = "(//span[contains(@class,'separator')])[4]")
    private  WebElement validatorPhone;

    @FindBy (xpath = "(//span[contains(@class,'separator')])[6]")
    private  WebElement validatorFax;

    @FindBy(xpath = "//a[(@title='Show 7 more actions')]")
    private WebElement selectBtn;

    
    @Override
    public String validateAccountNew() {
       return detailsName.getText().trim();

    }

    @Override
    public void validatorAccount(Account account) {
        driverTools.clickElement(detail);
        log.info(account.getAccountNumber()+"################detail");
        log.info(validateNumber.getText()+"###############hola ");
        assertEquals(account.getAccountNumber(),validateNumber.getText().trim());
        assertEquals(account.getType(),validatorType.getText().trim());
        assertEquals(account.getPhone(),validatorPhone.getText().trim());
        assertEquals(account.getFax(),validatorFax.getText().trim());

    }

    @Override
    public AccountFormPage clickEditAccount() {
        driverTools.clickElement(selectBtn);
        driverTools.clickElement(selectOptionEdit);
        return new AccountFormPageLight();
    }

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
