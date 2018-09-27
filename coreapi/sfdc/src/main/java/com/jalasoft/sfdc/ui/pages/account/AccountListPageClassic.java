package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Handles the Account List Classic Page extends of the
 * {@Link AccountListPage} class.
 *
 * @author Ketty Camacho Vasquez
 */
public class AccountListPageClassic extends AccountListPage {

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
     * @return AccountFormPage, it page is a form of Classic.
     */
    @Override
    public AccountFormPage clickNewAccount() {
        driverTools.clickElement(newBtn);
        return new AccountFormPageClassic();
    }

    /**
     * This method search Account
     *
     * @param account Account
     * @return boolean (true/false)
     */
    @Override
    public boolean accountSearch(Account account) {
        return driverTools.isElementDisplayed(By.xpath("//*[contains(text(),'" + account.getAccountName() + "')]"));
        //return driverTools.isElementDisplayed(By.xpath("//th/a[text()='"+account.getAccountName()+"']"));
    }


}
