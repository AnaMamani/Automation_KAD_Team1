Feature: Create "Accounts"

  Scenario Outline:
    Given I login as "admin user" User
    When  I go to the Account page
    And   I go click account New
    When I create account fill the following form with the requirement "<Account Name>" "<Account Number>" "<Phone>"
    Examples: Short pass
  |Account Name                 |Account Number  |Phone  |
  |ketty                        |123             |1234567|










