package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ContactListPage  extends BasePage {


    /**
     * method for definition a contactClassi and ContactsLight
     * @return a PageFactory
     */

    public abstract ContactsFormPage clickLoginButtonNew();
}
