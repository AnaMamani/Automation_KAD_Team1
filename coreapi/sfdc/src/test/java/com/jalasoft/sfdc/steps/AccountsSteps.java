package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

/**
 * Account steps class.
 *
 * @author Ketty Camacho Vasquez
 */

public class AccountsSteps {

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private AccountFormPage accountFormPage;
    private Account account;
    private AccountDetailPage accountDetailPage;


    /**
     * Go a page account on classic o light .
     */

    @When("^I go to the Account page$")
    public void iGoToTheAccountPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        accountListPage = allAppsPage.clickAccountsLink();

    }

    /**
     * Create a account with a information.
     *
     * @param accounts of Account
     */
    @And("^I create a Account with the following information$")
    public void iCreateAccount(List<Account> accounts) throws Throwable {
        log.info("iGoToTheAccountPage -----> Start homePage");

        this.account = accounts.get(0);
        account.setAccountName(accounts.get(0).getAccountName());
        accountFormPage = accountListPage.clickNewAccount();
        accountDetailPage = accountFormPage.createAccount(account);
    }

    /**
     * validate the information of Account.
     */
    @Then("^the Account Details Page should be display with the information of the Account$")
    public void accountDetailsPageShouldBeDisplayWithTheInformationOfTheAccountCreated() {
        accountDetailPage.validatorAccount(account);
        System.out.println("*****************************" + account.getAccountName());
        assertEquals(account.getAccountName(), accountDetailPage.validateAccountNew(), "the correct name user should be:");
    }
//*********************************************************************************
    //                    Edit the Account
//*********************************************************************************

    /**
     * Craete a new Account with information .
     *
     * @param newAccounts List of new account
     */
    @Given("^I create a new Account with the following information$")
    public void iHaveAContactWithTheFollowingInformation(List<Account> newAccounts) throws Throwable {
        log.info("Go the account page ----> Start edit");
        iCreateAccount(newAccounts);
        accountDetailsPageShouldBeDisplayWithTheInformationOfTheAccountCreated();
    }

    /**
     * Edi the account information
     *
     * @param editAccounts list for edit
     */
    @When("^I Edit the Account information with the following information$")
    public void iEditThisAccountWithTheFollowingInformation(List<Account> editAccounts) {

        accountFormPage = accountDetailPage.clickEditAccount();
        this.account = editAccounts.get(0);
        account.setAccountName(editAccounts.get(0).getAccountName());
        accountDetailPage = accountFormPage.editAccount(account);

    }
//*********************************************************************************
    //                    Delete the Account
//*********************************************************************************

    /**
     * Delete a Account
     */
    @When("^I delete a Account$")
    public void iGoDeleteAAccount() {
        accountDetailPage.deleteAnAccount();
    }

    /**
     * Validate if was delect Account
     */
    @Then("^I should see the Account is delete$")
    public void iShouldSeeTheAccountIsDelete() {
        assertFalse(accountListPage.accountSearch(account));
    }

}
