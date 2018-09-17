package com.jalasoft.sfdc.ui.components;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import org.apache.log4j.Logger;

/**
 * Top bar that contains the user name information, settings and logout options.
 * {@link BasePage} class
 *
 * @author Silvia Valencia
 * @since 7/3/2018.
 */
public abstract class TopMenu extends BasePage {
    protected Logger log = Logger.getLogger(getClass());

    public abstract void swithSkin();

    /**
     * This method get the profile name the current user.
     * @return  a new LoginPage.
     */
    public abstract LoginPage logout();

    public abstract HomePage goToHomePage();

    /**
     * This method get the profile name the current user.
     * @return the profile name.
     */
    public abstract String getProfileName();

    /**
     * This method do click and create the new page.
     * @return a new allAppsPage.
     */
    public abstract AllAppsPage goToAllAppsPage();

    public abstract String getCurrentUser();
}

