package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPageLigth;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllAppsPageLight extends AllAppsPage {
    //PageFactory of selenium.
    @FindBy(xpath = "html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[9]/a/span/span")
    WebElement contactsLink;

    @FindBy(xpath = "//span[text()='Products' and @class]")
    WebElement productLink;

    @FindBy(xpath = "//span[@class='label slds-truncate slds-text-link'][contains(text(),'Price Books')]")
    WebElement priceBookLink;
    //this find element is to auxiliary for verify the menu the features.
    @FindBy(xpath = "//div[@title='Service']")
    WebElement serviceLink;

    @FindBy(xpath = "//span[@class='label slds-truncate slds-text-link'][contains(.,'Accounts')]" )
            //".//span[contains(@class,'label slds-truncate slds-text-link')]" )
            WebElement accountLink;


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(serviceLink));
        wait.until(ExpectedConditions.visibilityOf(accountLink));

    }

    /**
     * @return
     */
    @Override
    public ProductListPage clickProductLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(productLink);
        return new ProductListPageLight();
    }

    @Override
    public ContactListPage clickContactLink() {
        driverTools.scrollDown(5);
        driverTools.clickElement(contactsLink);
        return new ContactListPageLight();
    }

    @Override
    public PriceBookListPage clickPriceBookLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(priceBookLink);
        return new PriceBookListPageLigth();
    }


    @Override
    public AccountListPage clickAccountsLink() {
        driverTools.scrollDown(6);
        driverTools.clickElement(accountLink);
        return  new AccountListPageLight();
    }
}
