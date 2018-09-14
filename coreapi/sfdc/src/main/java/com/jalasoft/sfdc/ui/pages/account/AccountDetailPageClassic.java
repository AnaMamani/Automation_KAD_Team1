package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageClassic extends AccountDetailPage {

    @FindBy(xpath = "//h2[contains(@class,'topName')]")
    WebElement validateAccount;
     @FindBy(xpath = "//*[@id='topButtonRow']/input[3]")
     WebElement editBtn;


    @Override
    public String validateAccountNew() {
        return validateAccount.getText().trim();
    }


    @Override
    public AccountFormPage clickEditAcoount() {
        driverTools.clickElement(editBtn);
        return new AccountFormPageClassic();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
