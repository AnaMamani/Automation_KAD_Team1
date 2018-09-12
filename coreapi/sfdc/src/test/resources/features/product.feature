Feature: Create a product

  Background:
    Given I login as "admin user" User

  Scenario : Verify that is possible add a new product
    When  I go to the Product page
     And I create a Product with the following information:
      | Product Name | Product Code | Product Description | active |
      | Computers    | hp and dell  | desktop and laptops | true   |
    Then Product Details Page should be display with the information of the product created




