Feature: Create "Accounts"
  Background:
    Given I login as "other role user" User

@createAccount
Scenario:
    When  I go to the Account page
    And   I go click account New
    When I create account fill the following form with the requirement
  |Account Name    |Account Number  |Phone  |Fax       |Billing  City|Billing State|Billing Country|Number of Location|
  |ketty           |123             |1234567| 987654321|cbba         | Tiraque     |Bolivia        |7                 |

  Then validate the new Account created is displayed










