package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.ui.components.TopMenu;
import com.jalasoft.sfdc.ui.components.TopMenuClassic;
import com.jalasoft.sfdc.ui.components.TopMenuLight;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPageLight;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPage;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageClassic;
import com.jalasoft.sfdc.ui.pages.contact.ContactListPageLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsClassic;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPageLight;
import com.jalasoft.sfdc.ui.pages.product.*;

public class PageFactory {
    private static Skin skin = ServersConfigReader.getInstance().getSkin();

    //****************************************************************
    // Pages
    //****************************************************************

    /**
     * Returns an Instance of HomePage for the respective Skin
     *
     * @return
     */
    public static HomePage getHomePage() {
        switch (skin) {
            case CLASSIC:
                return new HomePageClassic();
            default:
                return new HomePageLight();
        }
    }

    public static TopMenu getTopMenu() {
        switch (skin) {
            case CLASSIC:
                return new TopMenuClassic();
            default:
                return new TopMenuLight();
        }
    }
    public static AllAppsPage getAllAppsPage() {
        switch (skin) {
            case CLASSIC:
                return new AllAppsClassic();
            default:
                return new AllAppsPageLight();
        }
    }

    public static ContactListPage getHomeContacts() {
        switch (skin) {
            case CLASSIC:
                return new ContactListPageClassic();
            default:
                return new ContactListPageLight();
        }
    }

    public static ProductListPage getProductListPage() {
        switch (skin) {
            case CLASSIC:
                return new ProductListPageClassic();
            default:
                return new ProductListPageLight();
        }
    }

    public static ProductDetailPage getProductDetailPage() {
        switch (skin) {
            case CLASSIC:
                return new ProductDetailPageClassic();
            default:
                return new ProductDetailPageLight();
        }
    }

    public static AccountDetailPage getAccountDetailPage() {
        switch (skin) {
            case CLASSIC:
                return new AccountDetailPageClassic();
            default:
                return new AccountDetailPageLight();
        }
    }
}
