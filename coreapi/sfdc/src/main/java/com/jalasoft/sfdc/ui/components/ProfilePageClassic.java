package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.pages.profile.ProfilePage;
import org.openqa.selenium.By;

public class ProfilePageClassic extends ProfilePage {
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    @Override
    public String getUserNameDisplayed() {
        return driver.findElement(By.id("tailBreadcrumbNode")).getText().trim();
    }

}
