@Account
Feature: Create "Accounts"

  Background:
    Given  I navigate to Login page
    And I login as "admin user" User


  @deleteAccount
  Scenario: Verify that is possible create an Account
    Given I go to the Account page
    When I click New Account button
    And I create an Account with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | KARINA       | 123            | 1234567 | 987654321 | cbba          | Tiraque       | Bolivia         | 7                  | Prospect |
    Then the Account should be displayed in Account Details page
    And the Account should be created


  @deleteAccount
  Scenario: Verify that is possible edit an Account
    Given I have an Account created with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
    When I go by URL to the Account created
    And I click Edit Account button
    When I Edit the Account with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Felysidad    | 222333         | 1000007 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
    Then the Account Details Page should be display with the information of the Account updated
    And the Account should be updated

  @deleteAccount
  Scenario:  Verify that is possible Delete an Account
    Given I have an Account created with the following information
      | Account Name | Account Number | Phone   | Fax    | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Deysi        | 222111         | 6666637 | 987621 | cbba          | tiraque       | Bolivia         | 1                  | Prospect |
    When I go by URL to the Account created
    And I click Delete Account button
    Then the Account should be removed from the Account List
    And the Account should be removed