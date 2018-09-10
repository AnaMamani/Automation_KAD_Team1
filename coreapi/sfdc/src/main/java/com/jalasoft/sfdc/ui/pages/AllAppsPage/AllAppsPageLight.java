package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllAppsPageLight extends AllAppsPage {

    @FindBy
    WebElement productLink;

    @FindBy(xpath = "html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[9]/a/span/span")
    WebElement contactsLink;
    @FindBy(xpath = ".//span[contains(@class,'label slds-truncate slds-text-link')]" )
            //*[@id='brandBand_1']/div/div[1]/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")
    WebElement accountLick;

            //*[@id='brandBand_1']/div/div[1]/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")

            //"html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[1]/a/span/span")

    @Override
    public void waitUntilPageObjectIsLoaded() {
///  tiempo de espera cuando la pagina se debe esperar para validar.
    }

    @Override
    public ProductListPage clickProductLink() {
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
    public AccountListPage clickAccountsLink() {
        driverTools.scrollDown(10);
        driverTools.clickElement(accountLick);
        return  new AccountListPageLight();
    }

}
