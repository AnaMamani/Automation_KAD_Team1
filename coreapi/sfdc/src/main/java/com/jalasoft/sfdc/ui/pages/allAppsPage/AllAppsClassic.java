package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageClassic;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPage;
import com.jalasoft.sfdc.ui.pages.priceBooks.PriceBookListPageClassic;
import com.jalasoft.sfdc.ui.pages.product.ProductListPage;
import com.jalasoft.sfdc.ui.pages.product.ProductListPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllAppsClassic extends AllAppsPage {
    //PageFactory of selenium.
    @FindBy(xpath = "//img[@title='Contacts']")
    private WebElement contactsLink;

    @FindBy(xpath = "//img[@title='Products']")
    private WebElement productLink;

    @FindBy(id = "tryLexDialogX")
    private WebElement dialogClose;

    @FindBy(xpath = "//img[@title='Price Books']")
    private WebElement priceBooksLink;

    @FindBy(xpath = "//img[@title='Accounts']")
    private WebElement accountLink;


    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productLink));
    }


    /**
     * Click ProductList Link.
     *
     * @return ProductListPage.
     */
    @Override
    public ProductListPage clickProductLink() {
        log.info("clickProductLink ----> return the new ProductListPageClassic");
        driverTools.clickElement(productLink);
        try {
            driverTools.clickElement(dialogClose);// for the close the window popup.
        } catch (Exception e) {
            log.error("***************** dialogClose no found *****************************");
        }

        return new ProductListPageClassic();
    }


    /**
     * Click ContactList Link.
     *
     * @return ContactListPage.
     */
    @Override
    public ContactListPage clickContactLink() {
        driverTools.clickElement(contactsLink);
        try{
            driverTools.clickElement(dialogClose);// for the close the window popup.
        }catch (Exception e){

        }
        return new ContactListPageClassic();
    }

    /**
     * Click Price Books Link.
     *
     * @return PriceBookListPage.
     */
    @Override
    public PriceBookListPage clickPriceBookLink() {
        driverTools.clickElement(priceBooksLink);
        driverTools.clickElement(dialogClose);// for the close the window popup.
        return new PriceBookListPageClassic();
    }

    /**
     * click Account List PAge.
     *
     * @return AccountListPage.
     */
    @Override
    public AccountListPage clickAccountsLink() {
          driverTools.clickElement(accountLink);
          try{
            driverTools.clickElement(dialogClose);// for the close the window popup.
        }catch (Exception e){

        }
        return new AccountListPageClassic();
    }


}
