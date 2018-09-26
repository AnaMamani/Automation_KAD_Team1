Feature:Create a new Quote

  Background:
    Given I navigate to Login page
    And I login as "admin user" User

  Scenario: Verify that is possible created a new Quote
    Given I have a Account created with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
    When I go to Opportunities Page
    And I click on New Opportunities
    Given I created opportunity with the following information
      | Opportunity Name | Account Name | Close Date | Stage       |
      | Naomi            | Fely         | 09/27/2018 | Prospecting |
    Then The opportunity should be displayed in details page
    When I create a new Quote with Test Quote Name
    And I add the following line item
      | Product Name    | price | quantity |
      | Computers IDs   | 0     | 50       |