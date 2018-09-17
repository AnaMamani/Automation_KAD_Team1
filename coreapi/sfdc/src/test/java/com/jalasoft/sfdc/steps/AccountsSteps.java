package com.jalasoft.sfdc.steps;

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

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AccountsSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private AccountFormPage accountFormPage;
    private Account account;
    private AccountDetailPage accountDetailPage;

    @When("^I go to the Account page$")
    public void iGoToTheAccountPage()  {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
          accountListPage=allAppsPage.clickAccountsLink();

    }


    @And("^I go click account New$")
    public void iGoClickAccountNew()  {
       accountFormPage = accountListPage.clickNewAccount();
    }

    @When("^I create account fill the following form with the requirement$")
    public void iCreateAccount(List<Account> accounts) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        this.account = accounts.get(0);
        accountDetailPage= accountFormPage.createAccount(account);
        //accountDetail=formAccount.clickSave();
    }

    @Then("^validate the new Account created is displayed$")
    public void validateTheNewAccountCreatedIsDisplayed() throws Throwable {
        accountDetailPage.validatorAccount(account);


        assertEquals(accountDetailPage.validateAccountNew(),account.getAccountName(),"Correcto");
       // assertEquals(accountDetailPage.validateAccountNew(),account.getAccountNumber());
    }


    @Given("^I have a contact with the following information$")
    public void iHaveAContactWithTheFollowingInformation(List<Account> accountsN) {
        this.account = accountsN.get(0);
       // iGoClickAccountNew();
        accountDetailPage= accountFormPage.createAccount(account);
    }

    @When("^I  edit this account with the following information$")
    public void iEditThisAccountWithTheFollowingInformation(List<Account> accounts) throws Throwable {
        accountFormPage=accountDetailPage.clickEditAccount();
        this.account = accounts.get(0);
        accountDetailPage=accountFormPage.editAccount(account);

    }

    @When("^I go delete a Account$")
    public void iGoDeleteAAccount() throws Throwable {
        accountDetailPage.deleteAnAccount();
    }

//    @Then("^I should see the Account is removed from the Accounts page$")
//    public void iShouldSeeTheAccountIsRemovedFromTheAccountsPage() throws Throwable {
//        assertTrue();
//        assertTrue(contactHomePage.containContact(contact));
//    }
}
