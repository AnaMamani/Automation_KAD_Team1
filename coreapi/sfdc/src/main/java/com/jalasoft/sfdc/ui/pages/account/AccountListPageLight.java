package com.jalasoft.sfdc.ui.pages.account;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountListPageLight extends AccountListPage {
    @FindBy(xpath = ".//div[contains(@title,'New')]")
            //*[@id='brandBand_1']/div/div[1]/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a" )
            //".//*[@id='brandBand_1']/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")
    WebElement btnNew;
    @Override
    public FormAccount clickNewAccount() {
        driverTools.clickElement(btnNew);
        return new FormAccountLight();

    }
}
