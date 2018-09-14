package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.entities.Account;
import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.*;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AccountsSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private AccountFormPage accountFormPage;
    private Account account;
    private AccountDetailPage accountDetailPage;

    @When("^I go to the Account page$")
    public void iGoToTheAccountPage() {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
        accountListPage = allAppsPage.clickAccountsLink();

    }


    @And("^I go click account New$")
    public void iGoClickAccountNew() {
        accountFormPage = accountListPage.clickNewAccount();
    }

    @When("^I create account fill the following form with the requirement$")
    public void iCreateAccount(List<Account> accounts) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        this.account = accounts.get(0);
        accountDetailPage = accountFormPage.createAccount(account);
        //accountDetail=formAccount.clickSave();
    }

    @Then("^validate the new Account created is displayed$")
    public void validateTheNewAccountCreatedIsDisplayed() throws Throwable {
        assertEquals(accountDetailPage.validateAccountNew(), account.getAccountName(), "Correcto");
    }

    @When("^I go click edit$")
    public void iGoClickEdit()  {
        accountFormPage=accountDetailPage.clickEditAcoount();
    }

    @When("^I edit that Account with the following information:$")
    public void iEditThatAccountWithTheFollowingInformation(List<Account> accountss) throws Throwable {
        this.account = accountss.get(0);
        accountDetailPage=accountFormPage.editAccount(account);
    }

    @And("^I go Save change Account$")
    public void iGoSaveChangeAccount()  {



    }
}
