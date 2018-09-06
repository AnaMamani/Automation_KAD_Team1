package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllAppsPageLight extends AllAppsPage {

    @FindBy
    WebElement productLink;

    @FindBy(xpath = "html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[9]/a/span/span")
    WebElement contactsLink;

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
}
