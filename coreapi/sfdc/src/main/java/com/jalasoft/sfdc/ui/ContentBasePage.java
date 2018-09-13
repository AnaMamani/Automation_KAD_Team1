package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.ui.components.TopMenu;

public abstract class ContentBasePage extends BasePage {
    protected TopMenu topMenu;

    public ContentBasePage() {
        this.topMenu = PageFactory.getTopMenu();
    }
}
