package com.jalasoft.sfdc.steps;

import com.jalasoft.sfdc.ui.PageFactory;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.FormAccount;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.AllAppsPage.AllAppsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class AccountsSteps {
    private HomePage homePage;
    private AllAppsPage allAppsPage;
    private AccountListPage accountListPage;
    private FormAccount formAccount;

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
       formAccount = accountListPage.clickNewAccount();
    }

    @When("^I fill form accounts \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iFillFormAccounts(String accountName, String parentAccount, String accountNumber, String phone)  {
       formAccount.fillDataAccount(accountName, parentAccount, accountNumber, phone);
       //accountDetail=formAccount.clickSave();
    }
}
