Feature: Add a new product

  Background:
    Given I login as "other role user" User

  Scenario: Verify that is possible add a new product
    When  I go to the Product page
    When I add the new product

