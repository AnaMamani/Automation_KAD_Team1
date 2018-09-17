package com.jalasoft.sfdc.ui.pages.home;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.components.TopMenu;

public abstract class HomePage extends BasePage {
    public TopMenu topMenu;

    public HomePage() {
        this.topMenu = PageFactory.getTopMenu();
        waitUntilPageObjectIsLoaded();
    }
}
