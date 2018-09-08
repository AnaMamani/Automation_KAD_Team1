package com.jalasoft.sfdc.ui.pages.product;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsClassic extends AllAppsPage {


    @FindBy(xpath = "//a[contains(@class,'listRelatedObject contactBlock title')]")
    WebElement contactsLink;

    @FindBy(id = "tryLexDialogX")
    WebElement dialogClose;

    @FindBy(xpath = "//a[contains(@class,'listRelatedObject pricebook2Block title')]")
    WebElement priceBooksLinks;

    @Override
    public ProductListPage clickProductLink() {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public ContactListPage clickContactLink() {
        wait.until(ExpectedConditions.visibilityOf(contactsLink));
        driverTools.clickElement(contactsLink);
        driverTools.clickElement(dialogClose);
        return new ContactListPageClassic();
    }

    @Override
    public PriceBooksPage clickPriceBooksLink() {
        driverTools.clickElement(priceBooksLinks);
        driverTools.clickElement(dialogClose);
        return new PriceBooksPageClassic();
    }
}
