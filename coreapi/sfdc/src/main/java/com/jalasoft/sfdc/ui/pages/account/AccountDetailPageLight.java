package com.jalasoft.sfdc.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Handles Account Detail Page Classic extends of the
 * {@Link AccountDetailPage} class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountDetailPageLight extends AccountDetailPage {

    @FindBy(xpath = "//span[@class='title'][contains(.,'Details')]")
    WebElement details;
    @FindBy(xpath = "(//div[@class='testonly-outputNameWithHierarchyIcon sfaOutputNameWithHierarchyIcon' ]//parent::span)[1]")

    WebElement detailsName;
    @Override
    public String validateAccountNew() {
        driverTools.clickElement(details);
       return detailsName.getText().trim();

    }


    @Override
    public AccountFormPage clickEditAcoount() {
        return null;
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
