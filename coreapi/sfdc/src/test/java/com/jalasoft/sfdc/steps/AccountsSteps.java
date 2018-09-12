package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountFormPage;
import com.jalasoft.sfdc.ui.pages.allAppsPage.AllAppsPage;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class AccountsSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private AccountFormPage AccountFormPage;

    @When("^I go to the Account page$")
    public void iGoToTheAccountPage()  {
        homePage = PageFactory.getHomePage();
        allAppsPage = homePage.topMenu.goToAllAppsPage();
          accountListPage=allAppsPage.clickAccountsLink();
         //contactListPage = allAppsPage.clickContactLink();
        // Write code here that turns the phrase above into concrete actions

    }


    @And("^I go click account New$")
    public void iGoClickAccountNew()  {
       AccountFormPage = accountListPage.clickNewAccount();
    }
    @When("^I create account fill the following form with the requirement \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillFormAccounts(String accountName, String accountNumber, String phone) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AccountFormPage.createAccount(accountName,accountNumber, phone);
        //accountDetail=formAccount.clickSave();
    }
}
