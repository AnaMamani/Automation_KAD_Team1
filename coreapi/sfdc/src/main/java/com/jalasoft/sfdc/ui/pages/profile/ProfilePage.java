package com.jalasoft.sfdc.ui.pages.profile;


import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

public class ProfilePage extends BasePage {
    public ProfilePage(){
        //driver.findElement(By.id("editPage")).click();
        driver.findElement(By.id("userNavButton")).click();
        driver.findElement(By.linkText("My Profile")).click();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
    }
    public boolean isUserNameDisplayed(){
        return driver.findElement(By.id("tailBreadcrumbNode")).getText().isEmpty()?false:true;
    }

}

