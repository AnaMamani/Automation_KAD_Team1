package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.config.UsersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.entities.User;
import com.jalasoft.sfdc.ui.PageTransporter;
import com.jalasoft.sfdc.ui.pages.LoginPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Login steps class.
 *
 * @author Silvia Valencia
 * @since 7/30/2018
 */
public class LoginSteps {
    private PageTransporter pageTransporter;
    private Logger log = Logger.getLogger(getClass());

    //Pages
    private LoginPage loginPage;
    private HomePage homePage;

    // Entities
    private User user;

    public LoginSteps() throws Exception {
        this.pageTransporter = PageTransporter.getInstance();
    }

    //****************************************************************
    //Login Step Definitions
    //****************************************************************

    /**
     * Verifies if the desired user is logged.
     *
     * @param user - The user.
     * @return true/false.
     * @throws MalformedURLException Exception.
     */
    private boolean isUserLogged(final User user) throws MalformedURLException {
        boolean isUserLogged = false;
        // If it is not in empty or login page, then it is logged in the app
        if (!pageTransporter.isOnEmptyPage() && !pageTransporter.isOnLogin()) {

            // ToDo Evaluates if the proper user is logged
            //if (homePage.getTopBar().getCurrentUser().equals(user.getUserName())) {
            if (homePage.topMenu.getCurrentUser().equals(user.getUserName())) {
                System.out.print(user.getUserName());
                isUserLogged = true;
            } else {
                //     System.out.print("ana");
                //homePage.getTopBar().logout();
                homePage.topMenu.logout();
            }

        } else {
            navigateToLoginPage();
        }

        return isUserLogged;
    }

    /**
     * Navigates to the Login page.
     *
     * @throws MalformedURLException Exception.
     */
    @Given("^I navigate to Login page$")
    public void navigateToLoginPage() throws MalformedURLException {

        //Use this step for login feature scenarios
        loginPage = pageTransporter.navigateToLoginPage();
    }

    /**
     * Logins to Salesforce.
     *
     * @param username - Name of the user.
     * @param password - Password of the user.
     */
    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void login(String username, String password) {

        //Use this step for login feature scenarios
        homePage = loginPage.login(username, password);
    }

    @Then("^I should login successfully with a \"(.*?)\"$")
    public void verifyMainPageIsDisplayed(String fullName) {
        assertEquals(homePage.topMenu.getProfileName(), fullName,"full name the user is showed");
        //assertTrue(true, "User email displayed in Web");
    }


    /**
     * Navigates and login to Salesforce with the user received.
     *
     * @param userAlias - Alias of the user.
     * @throws MalformedURLException Exception.
     */
    @Given("^I (?:am logged in|login) as \"(.*?)\" User$")
    public void loginAsUser(final String userAlias) throws MalformedURLException {
        user = UsersConfigReader.getInstance().getUserByAlias(userAlias);
        if (!isUserLogged(user)) {
            login(user.getUserName(), user.getPassword());
        }
    }

    //****************************************************************
    //Hooks for @Login scenarios
    //****************************************************************
    @After(value = "@Login, @CrudOppy, @Stages, @Account", order = 999)
    public void afterLoginScenario() {
        log.info("After hook @Login");
        Skin skin = ServersConfigReader.getInstance().getSkin();
        if (skin == Skin.LIGHT) {
            homePage.topMenu.logout();
        }
    }

    @Given("^I am logged on Salesforce with valid usr$")
    public void iAmLoggedOnSalesforceWithValidUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should'nt login and show the \"([^\"]*)\"$")
    public void iShouldNtLoginAndShowThe(String errorMessage) throws Throwable {
        assertEquals(loginPage.unSuccefullLogin(), errorMessage);
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}