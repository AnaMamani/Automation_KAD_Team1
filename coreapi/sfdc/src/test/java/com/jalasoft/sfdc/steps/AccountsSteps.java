package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIAccount;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    private Account accountApi;
    private AccountDetailPage accountDetailPage;
    private APIAccount apiAccount;


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
        accountFormPage = accountListPage.clickNewAccount();
        apiAccount=new APIAccount(account);
        apiAccount.createAccountByAPI();
//        account.setAccountName(accounts.get(0).getAccountName());

//        accountDetailPage = accountFormPage.createAccount(account);
    }

    /**
     * validate the information of Account.
     */
    @Then("^the Account Details Page should be display with the information of the Account created$")
    public void accountDetailsPageShouldBeDisplayWithTheInformationOfTheAccountCreated() {

        accountApi=apiAccount.getAccountValuesByAPI();

        assertEquals(account.getAccountName(),accountApi.getAccountName());
        assertEquals(account.getAccountNumber(),accountApi.getAccountNumber());
        assertEquals(account.getPhone(),accountApi.getPhone());
        assertEquals(account.getType(),accountApi.getType());



//        assertEquals(account.getAccountName(), accountDetailPage.isSuccessDisplayedAccountDetail(), "the correct name user should be:");
//
//        assertTrue(accountDetailPage.isSuccessCreateAccount(account),"create");


       // accountDetailPage.validatorAccount(account);
    }
//*********************************************************************************
    //                    Edit the Account
//*********************************************************************************

    /**
     * Edi the account information
     *
     * @param editAccounts list for edit
     */
    @When("^I Edit the Account information with the following information$")
    public void iEditThisAccountWithTheFollowingInformation(List<Account> editAccounts) {

        accountFormPage = accountDetailPage.clickEditAccount();
        this.account = editAccounts.get(0);
        apiAccount=new APIAccount(account);
//        apiAccount.editAccountByAPI();
        //        account.setAccountName(editAccounts.get(0).getAccountName());
//        accountDetailPage = accountFormPage.editAccount(account);

    }

    @Then("^the Account Details Page should be display with the information of the Account updated$")
    public void theAccountDetailsPageShouldBeDisplayWithTheInformationOfTheAccountUpdated()  {
        assertTrue(accountDetailPage. isSuccessEditAccount(account),"the expected result:");
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
