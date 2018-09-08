package com.jalasoft.sfdc.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormBookBaseClassic extends FormBoookPage {

    @FindBy(xpath = "//*[@id=\"Name\"]")
    WebElement viewN;
    @FindBy(xpath = "//*[@id=\"Description\"]")
    WebElement viewUName;
//    @FindBy(xpath ="//*[@id=\"bottomButtonRow\"]/input[1]" )
//    WebElement saveBtn;
    public  FormBoookPage clickNewBook(){
    return new FormBookBaseClassic();    }
    @Override
    public FormBoookPage fillDataBook(String nameBook, String descriptionB) {
        setNameBook(nameBook);
        setViewDescription(descriptionB);
        return clickNewBook();
    }

    private void setNameBook(String nameBook) {
    }
    private void setViewDescription(String descriptionB){

    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
