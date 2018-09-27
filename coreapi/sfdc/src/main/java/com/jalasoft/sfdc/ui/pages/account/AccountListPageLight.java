package com.jalasoft.sfdc.ui.pages.account;


import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles the Account List Light Page extends of the
 * {@Link AccountListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountListPageLight extends AccountListPage {

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    /**
     * this is method clickNewAccount
     *
     * @return AccountFormPage , it page is a form of Light.
     */
    @Override
    public AccountFormPage clickNewAccount() {
        driverTools.clickElement(newBtn);
        return new AccountFormPageLight();

    }

    /**
     * This method Search account
     *
     * @param account Account
     * @return boolean (true/false)
     */
    @Override
    public boolean accountSearch(Account account) {

        return driverTools.isElementDisplayed(By.xpath("//*[contains(text(),'" + account.getAccountName() + "')]"));

    }


}
