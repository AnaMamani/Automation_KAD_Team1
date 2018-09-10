package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;
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

    /**
     * declared variable All App Page
     */
    By allAppBtnBy;

    public abstract void swithSkin();

    public LoginPage logout() {
        return new LoginPage();
    }

    public abstract HomePage goToHomePage();

    public abstract ProfilePage goToProfilePage();

    /**
     * Method for go to All App Page page
     * @return AllAppPage
     */
    public abstract AllAppsPage goToAllAppsPage();

    public abstract String getCurrentUser();
}

