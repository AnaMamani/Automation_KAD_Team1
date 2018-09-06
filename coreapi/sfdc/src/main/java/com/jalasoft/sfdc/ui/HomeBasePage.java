package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.ui.components.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public abstract class HomeBasePage extends BasePage {
    public TopMenu topMenu;

    @FindBy(id = "new")
    @CacheLookup
    WebElement newBtn;

    public HomeBasePage() {
        this.topMenu = PageFactory.getTopMenu();
        waitUntilPageObjectIsLoaded();
    }

    private By getItemLinkBy(String linkText) {
        return By.xpath("//a[contains(text(),'" + linkText + "')]");
    }

    protected void selectItem(String linkText) {
        driverTools.clickElement(getItemLinkBy(linkText));
    }

    protected void clickNewBtn() {
        driverTools.clickElement(newBtn);
    }

}
