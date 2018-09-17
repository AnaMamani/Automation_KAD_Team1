Feature: Create "Accounts"

  Background:
#    Given I login as "other role user" User
#    And I go to the Account page

    Given  I navigate to Login page
    And I login as "other role user" User

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
    When  I go to the Account page
    And I go click account New
    Given I have a contact with the following information

      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
    When I  edit this account with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Felysidad    | 222333         | 1000007 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |


    Then validate the new Account created is displayed

  @editAccount
  Scenario: Verify that is possible delete
    When  I go to the Account page
    And I go click account New
    Given I have a contact with the following information

      | Account Name | Account Number | Phone   | Fax    | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Deysi        | 222111         | 6666637 | 987621 | cbba          | tiraque       | Bolivia         | 1                  | Prospect |

    When I go delete a Account
#    Then I should see the Account is removed from the Accounts page








