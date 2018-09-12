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
    @FindBy(xpath = ".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[9]/td[1]/a/img")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@class=\"listRelatedObject productBlock title\"]")
    WebElement productLink;

    @FindBy(id = "tryLexDialogX")
    WebElement dialogClose;
    //
    @FindBy(xpath = "//a[@class='listRelatedObject pricebook2Block title']")
    WebElement priceBooksLink;

    @FindBy (xpath = "//a[contains(@class,'listRelatedObject accountBlock title')]" )
    //".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
            WebElement accountClick;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(productLink));
    }

    @Override
    public ProductListPage clickProductLink() {
        driverTools.clickElement(productLink);
        driverTools.clickElement(dialogClose);// for the close the window popup.
        return new ProductListPageClassic();
    }

    @Override
    public ContactListPage clickContactLink() {

        driverTools.clickElement(contactsLink);
        driverTools.clickElement(dialogClose);// for the close the window popup.
        return new ContactListPageClassic();
    }

    @Override
    public PriceBookListPage clickPriceBookLink() {
        driverTools.clickElement(priceBooksLink);
        driverTools.clickElement(dialogClose);// for the close the window popup.
        return new PriceBookListPageClassic();
    }

    @Override
    public AccountListPage clickAccountsLink() {
        driverTools.clickElement(accountClick);
        driverTools.clickElement(closePublicity);
        return new AccountListPageClassic();
    }
}
