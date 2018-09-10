package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageClassic;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllAppsClassic extends AllAppsPage {


    @FindBy(xpath = ".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[9]/td[1]/a/img")
    WebElement contactsLink;

    @FindBy (xpath = ".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
    WebElement accountClick;

    @FindBy (xpath = "//*[@id='tryLexDialogX']")
    WebElement closePublicity;
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

    @Override
    public AccountListPage clickAccountsLink() {
        driverTools.clickElement(accountClick);
        driverTools.clickElement(closePublicity);
        return new AccountListPageClassic();
    }


}
