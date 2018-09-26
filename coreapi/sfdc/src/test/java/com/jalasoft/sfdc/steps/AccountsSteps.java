package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.api.APIAccount;
import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.PageTransporter;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

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
    private Account accountEdit;
    private AccountDetailPage accountDetailPage;
    private APIAccount apiAccount;
    private Response response;


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
     * click new button account
     */
    @When("^I click New Account button$")
    public void iClickNewButton() {
        accountFormPage = accountListPage.clickNewAccount();

    }
    /**
     * Create a account with a information.
     *
     * @param accounts of Account
     */
    @And("^I create an Account with the following information$")
    public void iCreateAccount(List<Account> accounts)  {

        log.info("iGoToTheAccountPage -----> Start homePage");

        this.account = accounts.get(0);
        apiAccount=new APIAccount(account);
        account.setAccountName(accounts.get(0).getAccountName());
        accountDetailPage = accountFormPage.createAccount(account);

    }

    /**
     * validate the information of Account.
     */
    @Then("^the Account should be displayed in Account Details page$")
    public void theAccountDetailsPageShouldBeDisplayedWithTheAccountInformation()  {
        assertEquals(account.getAccountName(), accountDetailPage.isSuccessDisplayedAccountDetail(), "the correct name user should be:");
        assertTrue(accountDetailPage.isSuccessCreateAccount(account),"create");
    }

    /**
     * The Account was Create
     */
    @And("^The Account should be created$")
    public void theProductAccountBeCreated()  {
        accountApi=apiAccount.getAccountValuesByAPI();
        System.out.println(account.getAccountName()+"++++++++Name+++++Normal ");
        System.out.println(accountApi.getAccountName()+"++++++++Name+++++Api ");
        assertEquals(account.getAccountName(),accountApi.getAccountName());
        assertEquals(account.getAccountNumber(),accountApi.getAccountNumber());
        assertEquals(account.getPhone(),accountApi.getPhone());
        assertEquals(account.getType(),accountApi.getType());
    }

//*********************************************************************************
    //                    Edit the Account
//*********************************************************************************

    /**
     *Edit the account information
     * @param accountApi
     */
    @Given("^I have an Account created with the following information$")
    public void iHaveAAccountCreatedWithTheFollowingInformation(List<Account> accountApi)  {
        account=accountApi.get(0);
        accountEdit.updateAccountName();
        apiAccount=new APIAccount(account);
        apiAccount.createAccountByAPI();

    }

    /**
     *  select URL Created
     * @throws MalformedURLException
     */
    @When("^I go by URL to the Account created$")
    public void iGoByURLTheAccountCreated() throws MalformedURLException  {
        homePage = PageFactory.getHomePage();
        //PageTransporter.getInstance();
        accountDetailPage = PageTransporter.getInstance().navigateToAccountPage(account);

    }

    /**
     * click Button the edit on Account
     */
    @And("^I click Edit Account button$")
    public void iGoClickEditButton()  {
        accountFormPage = accountDetailPage.clickEditAccount();
    }
    /**
     * Edi the account information
     *
     * @param editAccounts list for edit
     */
    @When("^I Edit the Account with the following information$")
    public void iEditTheAccountWithTheFollowingInformation(List<Account> editAccounts) {

        accountEdit = editAccounts.get(0);
        accountEdit.updateAccountName();
        accountDetailPage = accountFormPage.editAccount(accountEdit);


    }

    /**
     * Details of the information of Account Update
     */
    @Then("^the Account Details Page should be display with the information of the Account updated$")
    public void theAccountDetailsPageShouldBeDisplayWithTheInformationOfTheAccountUpdated()  {
        assertEquals(accountEdit.getAccountName(), accountDetailPage.isSuccessDisplayedAccountDetail(), "should be show the product name:");
        assertTrue(accountDetailPage. isSuccessEditAccount(accountEdit),"the expected result:");
    }

    /**
     * validate on Api
     */
    @And("^the Account should be updated$")
    public void theAccountShouldBeUpdated()  {
        log.info("Validation for API to Edit Account ----->    " + accountEdit.getAccountName());
        accountApi = apiAccount.getAccountValuesByAPI();
        assertEquals(accountEdit.getAccountName(),accountApi.getAccountName(), "should be show the Account name:");
        assertTrue(accountDetailPage.isSuccessEditAccountByAPI(accountApi,accountEdit), "the expected result:");

    }
//*********************************************************************************
    //                    Delete the Account
//*********************************************************************************

    /**
     * Delete a Account
     */
    @When("^I click Delete Account button$")
    public void iGoDeleteAAccount() {
        //apiAccount.deleteAccountByAPI();
      accountListPage = accountDetailPage.deleteAnAccount();
    }

    /**
     * Validate if was delect Account
     */
    @Then("^the Account should be removed from the Account List$")
    public void iShouldSeeTheAccountIsDelete() {

        assertFalse(accountListPage.accountSearch(account));
    }

    /**
     * should remove Api
     */
    @And("^the Account should be removed$")
    public void theAccountShouldBeRemoved()  {
        log.info("Validation delete for API ===>" + account.getAccountName()+" ====>"+account.getId());
        response = apiAccount.deleteAccountByAPI();
        assertTrue(response.asString().isEmpty(), "should be return :");

    }

    //****************************************************************
    //Hooks for @Delete Account scenarios
    //****************************************************************
    @After(value = "@deleteAccount", order = 999)
    public void afterDeleteProduct() {
        log.info("After hook @deleteProduct");
        apiAccount.deleteAccountByAPI();

    }



}
