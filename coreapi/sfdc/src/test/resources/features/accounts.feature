Feature: Create "Accounts"

  Background:
    Given I login as "other role user" User
    And I go to the Account page

  @createAccount
  Scenario:
    When  I go to the Account page
    And   I go click account New
    When I create account fill the following form with the requirement
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | katty        | 123            | 1234567 | 987654321 | cbba          | Tiraque       | Bolivia         | 7                  | Prospect |

    Then validate the new Account created is displayed

  @editAccount
  Scenario: Verify that is possible edit Account
    Given I go click account New
    Given I have a contact with the following information

      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |













