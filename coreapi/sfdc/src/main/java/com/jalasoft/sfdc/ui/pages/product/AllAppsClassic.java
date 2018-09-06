package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllAppsClassic extends AllAppsPage {


    @FindBy(xpath = ".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[9]/td[1]/a/img")
    WebElement contactsLink;
    @Override
    public ProductListPage clickProductLink() {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ContactListPage clickContactLink() {
        driverTools.clickElement(contactsLink);
        return new ContactListPageClassic();
    }
}
