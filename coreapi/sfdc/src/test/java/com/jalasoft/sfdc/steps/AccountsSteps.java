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
import cucumber.api.java.en.When;

import java.util.List;

public class AccountsSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private AccountFormPage AccountFormPage;
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
       AccountFormPage = accountListPage.clickNewAccount();
    }

    @When("^I create account fill the following form with the requirement$")
    public void iCreateAccount(List<Account> accounts) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        this.account = accounts.get(0);
        accountDetailPage= AccountFormPage.createAccount(account);
        //accountDetail=formAccount.clickSave();
        throw new PendingException();
    }
}
