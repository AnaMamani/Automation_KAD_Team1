Feature: Create "Accounts"

  Background:
#    Given I login as "other role user" User
#    And I go to the Account page

    Given  I navigate to Login page
    And I login as "other role user" User
    When I go to the Account page

  @createAccount
  Scenario: Verify that is possible create a new Account
    And  I create a Account with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | keissy        | 123            | 1234567 | 987654321 | cbba          | Tiraque       | Bolivia         | 7                  | Prospect |

    Then the Account Details Page should be display with the information of the Account created
#
#  @editAccount
#  Scenario: Verify that is possible edit Account created
#    Given  I create a Account with the following information
#
#      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
#      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
#    When I Edit the Account information with the following information
#      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
#      | Felysidad    | 222333         | 1000007 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
#
#
#    Then the Account Details Page should be display with the information of the Account updated
#
#  @deleteAccount
#  Scenario:  Verify that is possible Delete a Account created
#    Given I create a Account with the following information
#
#      | Account Name | Account Number | Phone   | Fax    | Billing  City | Billing State | Billing Country | Number of Location | Type     |
#      | Deysi        | 222111         | 6666637 | 987621 | cbba          | tiraque       | Bolivia         | 1                  | Prospect |
#
#    When I delete a Account
#    Then I should see the Account is delete









