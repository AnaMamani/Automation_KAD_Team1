Feature:Create a new Quote

  Background:
    Given I navigate to Login page
    And I login as "admin user" User

  Scenario: Verify that it is possible to create a new Opportunity with Quote
    Given I have an Account created with the following information
      | Account Name | Account Number | Phone   | Fax       | Billing  City | Billing State | Billing Country | Number of Location | Type     |
      | Fely         | 222            | 3333337 | 987654321 | cbba          | Punata        | Bolivia         | 3                  | Prospect |
      And I have a Product created with the following information
        | Product Name  | Product Code | Product Description | Active |
        | Computers IOs | 69489750     | desktop             | true   |
      And I go by URL to the Product created
      And  I add the Product to the "Standard" Price Book and Price "50"
    When I go to Opportunities Page
      And I click on New Opportunities
      And I created opportunity with the following information
        | Opportunity Name |  Close Date | Stage       |Close Date Format|
        | Naomi            |  27/09/2018 | Prospecting |   2018-09-27    |
    Then the opportunity should be displayed in details page
      And the opportunity should be created
    When I click on New quote button
      And I create a new Quote with the following information
       | Quote Name |
       | quotes     |
      And I select a price book "Standard"
      And select the name of product create
      And I add the following line item
       | Sales Price | quantity |
       | 80          | 50       |
    Then the Quote should be displayed in Quotes Details page
     And the Quote should be created
