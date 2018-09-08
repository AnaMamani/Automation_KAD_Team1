package com.jalasoft.sfdc.ui.pages.priceBooksFormPage;

import com.jalasoft.sfdc.ui.pages.contactDetailPage.ContactDetailPageClassic;
import com.jalasoft.sfdc.ui.pages.priceBooksDetailPage.PriceBooksDetailPage;
import com.jalasoft.sfdc.ui.pages.priceBooksDetailPage.PriceBooksDetailPageClassic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBooksFormPageClassic extends PriceBooksFormPage {
    @FindBy(id = "Name")
    WebElement priceBooksName;

    @FindBy(id = "Description")
    WebElement description;

    @FindBy(xpath = ".//*[@id='bottomButtonRow']/input[1]")
    WebElement clickBtnSave;

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    public void setName(final String name) {
        driverTools.setInputField(priceBooksName, name);
    }
    public void setDescription(final String descriptions) {
        driverTools.setInputField(description, descriptions);
    }

    @Override
    public PriceBooksDetailPage insertPriceBooks(String priceBookName, String description) {
        setName(priceBookName);
        setDescription(description);
        return new PriceBooksDetailPageClassic();
    }

    @Override
    public PriceBooksDetailPage clickBtnSave() {
        driverTools.clickElement(clickBtnSave);
        return new PriceBooksDetailPageClassic();

    }
}
