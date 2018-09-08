package com.jalasoft.sfdc.ui.pages;

import com.jalasoft.sfdc.ui.BasePage;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Login Page class.
 *
 * @author Silvia Valencia
 * @since 6/21/2018
 */
public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    @FindBy(id = "error")
    private WebElement error;

    /**
     * {@inheritDoc}
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    /**
     * Sets the user name.
     *
     * @param username - The user name.
     */
    private void setUsername(final String username) {
        driverTools.setInputField(userNameTxt, username);
    }

    /**
     * Sets the user password.
     *
     * @param password - The user password.
     */
    private void setPassword(final String password) {
        driverTools.setInputField(passwordTxt, password);
    }

    /**
     * Clicks on login button.
     *
     * @return a list page.
     */
    private HomePage clickLoginButton() {
        driverTools.clickElement(loginBtn);
        return PageFactory.getHomePage();
    }

    /**
     * Logs in to Salesforce
     *
     * @param userName - The user name
     * @param password - The password
     * @return HomePage
     */
    public HomePage login(final String userName, final String password) {
        setUsername(userName);
        setPassword(password);
        return clickLoginButton();
    }

    public String unSuccefullLogin(){
        return error.getText();
    }
}
