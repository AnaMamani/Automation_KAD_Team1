Feature: Create "Accounts"

  Scenario Outline:
    Given I login as "user admin" User
    When  I go to the Account page
    And   I go click account New
    When I fill form accounts "<Account Name>" "<Parent Account>" "<Account Number>" "<Phone>"
    Examples: Short pass
  |Account Name             |Parent Account  |Account Number  |Phone  |
  |ketty                    | Sara           |123             |1234567|











