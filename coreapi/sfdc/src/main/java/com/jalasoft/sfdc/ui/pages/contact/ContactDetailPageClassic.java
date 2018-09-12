package com.jalasoft.sfdc.ui.pages.contact;

import com.jalasoft.sfdc.entities.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;

/**
 * ContactDetailPageClassic class.
 *
 * @author Ana Maria Mamani Zenteno
 * @since 7/31/2018
 */
public class ContactDetailPageClassic extends ContactDetailPage {

    @FindBy(xpath = "//*[@class='topName']")
    private WebElement contactCreated;

    /**
     * For show create contact in ContactDetail.
     *
     * @return String.
     */
    @Override
    public String isSuccessDisplayedContactDetail() {
        System.out.print(contactCreated.getText()+ "#####################################################");
        return contactCreated.getText().trim();
    }
}
