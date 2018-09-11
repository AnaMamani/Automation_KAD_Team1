package com.jalasoft.sfdc.ui.pages.profile;


import com.jalasoft.sfdc.ui.BasePage;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

public abstract class ProfilePage extends BasePage {
    public ProfilePage(){
        //driver.findElement(By.id("editPage")).click();

    }
    public abstract String getUserNameDisplayed();

}

