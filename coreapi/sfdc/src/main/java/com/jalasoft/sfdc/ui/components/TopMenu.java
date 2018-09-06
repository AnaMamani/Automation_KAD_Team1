package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.product.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.profile.ProfilePage;
import org.openqa.selenium.By;

/**
 * Top bar that contains the user name information, settings and logout options.
 * {@link BasePage} class
 *
 * @author Silvia Valencia
 * @since 7/3/2018.
 */
public abstract class TopMenu extends BasePage {

    protected By sliderBtnBy;

    public abstract void swithSkin();

    public LoginPage logout() {
        return new LoginPage();
    }

    public abstract HomePage goToHomePage();

    public ProfilePage goToProfilePage() {
        return new ProfilePage();
    }

    public AllAppsPage goToAllAppsPage() {
        return PageFactory.getAllAppsPage();
    }

    public abstract String getCurrentUser();
}

