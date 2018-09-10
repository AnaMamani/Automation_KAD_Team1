package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPageClassic;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsClassic extends AllAppsPage {


    /**
     * declared variable web element dialog
     */
    @FindBy(id = "tryLexDialogX")
    WebElement dialogClose;

    public AllAppsClassic(){
        contactsLink= By.xpath("//a[contains(@class,'listRelatedObject contactBlock title')]");
        priceBooksLinks= By.xpath("//a[contains(@class,'listRelatedObject pricebook2Block title')]");
    }

    @Override
    public ProductListPage clickProductLink() {
        return null;
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    /**
     * Method for go to contacts page.
     * @return ContactsListPageClassic.
     */
    @Override
    public ContactListPage clickContactLink() {
        driverTools.clickElement(contactsLink);
        driverTools.clickElement(dialogClose);
        return new ContactListPageClassic();
    }
    /**
     * Method for go to Price Books page.
     * @return PriceBooksPageClassic.
     */
    @Override
    public PriceBooksPage clickPriceBooksLink() {
        driverTools.clickElement(priceBooksLinks);
        driverTools.clickElement(dialogClose);
        return new PriceBooksPageClassic();
    }
}
