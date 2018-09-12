package com.jalasoft.sfdc.entities;

/**
 * User class contains the Account information.
 *
 * @author Ketty Camacho Vasquez
 * @since 7/3/2018
 */
public class Account {

    private String accountNames;
    private String parentAccount;
    private String accountNumber;
    private String accountSite;
    private String fax;
    private String phone;


    public Account(String accountNames, String parentAccount, String accountNumber, String accountSite,String fax, String phone){
        this.accountNames = accountNames;
        this.parentAccount= parentAccount;
        this.accountNumber=accountNumber;
        this.accountSite=accountSite;
        this.fax=fax;
        this.phone=phone;

    }

    /**
     *gets the Account Names.
     * @return account names.
     */
    public String getAccountNames() {
        return accountNames;
    }

    /**
     *gets the Parent Account.
     * @return account parent.
     */
    public String getParentAccount() {
        return parentAccount;
    }
    /**
     *gets the Account Number.
     * @return account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    /**
     *gets the Account Site.
     * @return account site.
     */
    public String getAccountSite() {
        return accountSite;
    }
    /**
     *gets the phone
     * @return phone account.
     */
    public String getPhone() {
        return phone;
    }
    /**
     *gets the fax
     * @return fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     *  sets of account name.
     * @param accountNames to set
     */
    public void setAccountNames(String accountNames) {
        this.accountNames = accountNames;
    }

    /**
     *sets of parent account.
     * @param parentAccount to set
     */
    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    /**
     *sets of account site
     * @param accountNumber to set
     */
    public void setAccountName(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *sets account site.
     * @param accountSite to set.
     */
    public void setAccountSite(String accountSite) {
        this.accountSite = accountSite;
    }

    /**
     *sets  fax
     * @param fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *sets phone
     * @param phone to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
