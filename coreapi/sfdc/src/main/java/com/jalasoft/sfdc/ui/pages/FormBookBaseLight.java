package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormBookBaseLight extends FormBoookPage {

    @FindBy(xpath = "//*[@id=\"7:1570;a\"]")
    WebElement nameB;
    @FindBy(xpath = "//*[@id=\"43:1570;a\"]")
    WebElement descript;
//    @FindBy(xpath ="//*[@id=\"bottomButtonRow\"]/input[1]" )
//    WebElement saveBtn;

    public  FormBoookPage clickNewBook(){
        return new FormBookBaseLight();    }


    private void setNameBook(String namebook){
        driverTools.setInputField(nameB,namebook);
    }

    private void setViewDescription(String description){
        driverTools.setInputField(descript,description);
    }

    @Override
    public FormBoookPage fillDataBook(String nameBook, String descriptionB) {
        setNameBook(nameBook);
        setViewDescription(descriptionB);
        return clickNewBook();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
