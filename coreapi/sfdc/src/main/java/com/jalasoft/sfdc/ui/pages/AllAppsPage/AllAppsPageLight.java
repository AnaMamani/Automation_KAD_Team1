package com.jalasoft.sfdc.ui.pages.AllAppsPage;

import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBooksPageLight;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AllAppsPageLight extends AllAppsPage {
    /**
     * declared variable Contacts
     */
    @FindBy
    WebElement productLink;
    WebDriverWait wait = new WebDriverWait(driver,60);

    public AllAppsPageLight(){
       // contactsLink= By.cssSelector("a[href*='Contact']");
        //div[@title='Service']
        contactsLink= By.xpath("//span[contains(text(),'Contacts')]");
        priceBooksLinks= By.xpath("//span[contains(text(),'Price Books')]");
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
///  tiempo de espera cuando la pagina se debe esperar para validar.
      //  wait.until(ExpectedConditions.visibilityOf(priceBooksLinks));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Contracts')]")));
    }

    @Override
    public ProductListPage clickProductLink() {
        driverTools.scrollDown(8);
        driverTools.clickElement(productLink);
        return new ProductListPageLight();
    }
    /**
     * Method for go to contacts page
     * @return ContactsListPageLight
     */
    @Override
    public ContactListPage clickContactLink() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
        driverTools.clickElement(contactsLink);
        return new ContactListPageLight();
    }

    @Override
    public PriceBooksPage clickPriceBooksLink() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driverTools.scrollDown(10);
        driverTools.clickElement(priceBooksLinks);
        return new PriceBooksPageLight();
    }
}
