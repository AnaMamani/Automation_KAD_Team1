package com.jalasoft.sfdc.ui.pages.account;

import com.jalasoft.sfdc.entities.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageLight extends AccountDetailPage {

    @FindBy(xpath = "//span[text()='Details']")
    WebElement details;
    @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon' ]//parent::span)[1]")
    WebElement detailsName;

    
    @Override
    public String validateAccountNew() {
        driverTools.clickElement(details);
       return detailsName.getText().trim();

    }

    @Override
    public void validatorAccount(Account account) {
        driverTools.clickElement(details);



    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
