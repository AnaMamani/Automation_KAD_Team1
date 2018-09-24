package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageClassic extends AccountDetailPage {

    @FindBy(xpath = "//h2[contains(@class,'topName')]")
    private WebElement accountNameCreateTxt;

    @FindBy(xpath = " //* [@id='acc5_ileinner']")
    private WebElement accountNumberTxt;

    @FindBy(xpath = "//td[contains(@class,'dataCol col02 inlineEditWrite')]/child::div[@id='acc6_ileinner']")
    private WebElement accountTypeTxt;

    @FindBy(id = "acc10_ileinner")
    private WebElement accountPhoneTxt;

    @FindBy(id = "acc11_ileinner")
    private WebElement accountFaxTxt;

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
    public String isSuccessDisplayedAccountDetail() {

        return accountNameCreateTxt.getText().trim();
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
    /**
     * verify that a account is create.
     *
     * @param account information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessCreateAccount(Account account) {
        return account.getAccountNumber().equals(accountNumberTxt.getText()) &&
                account.getType().equals(accountTypeTxt.getText()) &&
                account.getPhone().equals(accountPhoneTxt.getText()) && account.getFax().equals(accountFaxTxt.getText());
    }
    /**
     * verify the edit the account.
     *
     * @param account information the current user.
     * @return is successfully or not successfully.
     */
    @Override
    public boolean isSuccessEditAccount(Account account) {

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
     *  Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountNameCreateTxt));
    }
}
