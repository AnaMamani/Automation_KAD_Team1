Feature: Create a "Product"

  Background:
  //Given I navigate to Login page
    Given I login as "admin user" User

  Scenario: Verify that is possible create a new Product
    When I go to the Product page
    And I create a Product with the following information
      | Product Name | Product Code | Product Description | active |
      | Computers    | 69489750     | desktop and laptops | true   |
    Then Product Details Page should be display with the information of the product created

    When I edit to the Product created with the following data
      | Product Name  | Product Code | Product Description |
      | Computers iOS | 69489780     | desktop             |
    Then The Product should be edit and should be display with the information of the product edit

