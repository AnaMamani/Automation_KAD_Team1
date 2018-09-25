Feature: Create "Accounts"

  Background:
    Given  I navigate to Login page
    And I login as "other role user" User


#  @createAccount
#  Scenario: Verify that is possible create a new Account
#    Given I go to the Account page
#   When I click New button
#    And  I create a Account with the following information
#      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
#      | KARINA | 123            | 1234567 | 987654321 | cbba          | Tiraque       | Bolivia         | 7                  | Prospect |
#    Then the Account Details Page should be displayed with the Account information
#    And the Product Account be created


  @editAccount
  Scenario: Verify that is possible edit Account created
    Given I have a Account created with the following information
#    Given  I create a Account with the following information

      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
    When I select the Account created by URL
    When I Edit the Account information with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Felysidad    | 222333         | 1000007 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |


    Then the Account Details Page should be display with the information of the Account updated

#  @deleteAccount
#  Scenario:  Verify that is possible Delete a Account created
#    Given I create a Account with the following information
#
#      | Account Name | Account Number | Phone   | Fax    | Billing  City | Billing State | Billing Country | Number of Location | Type     |
#      | Deysi        | 222111         | 6666637 | 987621 | cbba          | tiraque       | Bolivia         | 1                  | Prospect |
#
#    When I delete a Account
#    Then I should see the Account is delete









