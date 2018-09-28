package com.jalasoft.sfdc.ui.pages.allAppsPage;

import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitiesListPageClassic;
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

/**
 * Product All Apps Classic class.
 * @author Denis Camacho.
 * @author Ketty Camacho.
 * @author Ana Mamani.
 * @since 9/18/2018
 */
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

    @FindBy(xpath = "//img[@title='Opportunities']")
    private WebElement oportunitiestLink;

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
        if (driverTools.isElementDisplayed(dialogClose))
            driverTools.clickElement(dialogClose);// for the close the window popup.
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
        try {
            driverTools.clickElement(dialogClose);// for the close the window popup.
        } catch (Exception e) {

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
        try {
            driverTools.clickElement(dialogClose);// for the close the window popup.
        } catch (Exception e) {

        }
        return new AccountListPageClassic();
    }

    /**
     * click opportunities List PAge
     *
     * @return OpportunitiesListPage
     */
    @Override
    public OpportunitiesListPage clickOpportunities() {
        driverTools.clickElement(oportunitiestLink);
        return new OpportunitiesListPageClassic();
    }

}
