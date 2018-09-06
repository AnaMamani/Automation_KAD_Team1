package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.product.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPageLight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuClassic extends TopMenu {

    @FindBy(xpath = ".//*[@id='AllTab_Tab']/a/img")
    private WebElement sliderBtnLit;
    public TopMenuClassic() {

        //sliderBtnBy = By.xpath(".//*[@id='AllTab_Tab']/a/img");
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(sliderBtnLit);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

