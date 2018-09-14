Feature: Create "Accounts"

  Background:
    Given I login as "other role user" User

  @createAccount
  Scenario:
    When  I go to the Account page
    And   I go click account New
    When I create account fill the following form with the requirement
      | Account Name | Account Number | Phone    | Fax        | Billing  City | Billing State | Billing Country | Number of Location |
      | Roootona       | 123w           | 123w4567 | 98w7654321 | cochabamba    | Tiraque       | Bolivia         | 7                  |

    Then validate the new Account created is displayed

    When I go click edit
    When I edit that Account with the following information:
      | Account Name | Account Number | Phone     |
      | Raoomonita     | 222            | 727568163 |
    And I go Save change Account

















