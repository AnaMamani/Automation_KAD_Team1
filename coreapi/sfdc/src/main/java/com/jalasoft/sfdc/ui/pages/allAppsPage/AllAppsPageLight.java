package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksListPageLigth;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPageLight;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllAppsPageLight extends AllAppsPage {

    @FindBy(xpath = "html/body/div[5]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/ul/li[9]/a/span/span")
    WebElement contactsLink;
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productLink;
    //
    @FindBy(xpath = "//span[@class='label slds-truncate slds-text-link'][contains(text(),'Price Books')]")
    WebElement priceBooksLink;

    @Override

    public void waitUntilPageObjectIsLoaded() {

        wait.until(ExpectedConditions.visibilityOf(priceBooksLink));
    }

    /**
     * @return
     */
    @Override
    public ProductListPage clickProductLink() {
        driverTools.scrollDown(20);
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
    public PriceBooksListPage clickPriceBooksLink() {
        driverTools.clickElement(priceBooksLink);
        return new PriceBooksListPageLigth();
    }
}
