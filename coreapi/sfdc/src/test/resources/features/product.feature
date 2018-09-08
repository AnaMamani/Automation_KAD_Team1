Feature: Add a new product

  Background:
    Given I login as "other role user" User

  Scenario Outline: Verify that is possible add a new product
    When  I go to the Product page
    When I add the new product "<Product Name>"

    Examples: data of the product
    |Product Name|Product Code|Product Description|
    |Computers   |hp and dell |desktop and labtops|

