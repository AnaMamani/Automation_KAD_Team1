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
    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    private WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productLink;

    @FindBy(xpath = "//span[contains(text(),'Price Books')]")
    private WebElement priceBookLink;
    //this find element is to auxiliary for verify the menu the features.
    @FindBy(xpath = "//div[@title='Service']")
    private WebElement serviceLink;

    @FindBy(xpath = "//*[@class='label slds-truncate slds-text-link'][contains(text(),'Accounts')]" )
    private WebElement accountLink;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(serviceLink));
    }


    /**
     * Click ProductList Link.
     *
     * @return ProductListPage.
     */
    @Override
    public ProductListPage clickProductLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(productLink);
        return new ProductListPageLight();
    }

    /**
     * Click ContactList Link.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage clickContactLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(contactsLink);
        return new ContactListPageLight();
    }

    /**
     * Click Price Books Link.
     *
     * @return PriceBookListPage.
     */
    @Override
    public PriceBookListPage clickPriceBookLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(priceBookLink);
        return new PriceBookListPageLigth();
    }

    /**
     * click Account List PAge.
     *
     * @return AccountListPage.
     */
    @Override
    public AccountListPage clickAccountsLink() {
        driverTools.scrollToBottomOfPage();
        driverTools.clickElement(accountLink);
        return  new AccountListPageLight();
    }
}
