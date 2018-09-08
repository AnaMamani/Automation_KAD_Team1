package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.product.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPageLight;
import com.jalasoft.sfdc.ui.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {

    @FindBy(xpath = "//img[contains(@title,'All Tabs')]")
    private WebElement sliderBtnClassic;

    public TopMenuClassic() {

        //sliderBtnBy = By.xpath(".//*[@id='AllTab_Tab']/a/img");
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(sliderBtnClassic));
    }

    @Override
    public void swithSkin() {

    }

    @Override
    public HomePage goToHomePage() {
        return new HomePageClassic();
    }

    @Override
    public ProfilePage goToProfilePage() {
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("My Profile")).click();
        return new ProfilePageClassic();
    }

    public AllAppsPage goToAllAppsPage() {
        driverTools.clickElement(sliderBtnClassic);
        return new AllAppsClassic();
    }

    @Override
    public String getCurrentUser() {
        return null;
    }
}

