Feature: Create a "Product"

  Background:
    Given I navigate to Login page
    And I login as "admin user" User
    When I go to the Product page

  @CreateProduct
  Scenario: Verify that is possible create a new Product
    And I create a Product with the following information
      | Product Name | Product Code | Product Description | active |
      | Computers    | hp and dell  | desktop and laptops | true   |
    Then Product Details Page should be display with the information of the product created

  @EditProduct
  Scenario: Verify that is possible Edit a product created
    When I have a New Product with the following information
      | Product Name | Product Code | Product Description | active |
      | Computers    | 69489750     | desktop             | true   |
    When I select the Product
    And I Edit the Product information with the following information
      | Product Name | Product Code | Product Description | active |
      | Computers    | 0215424      | laptops             | false  |
    Then Product Content Page should be displayed with the information updated

  @DeleteProduct
  Scenario: Verify that is possible Delete a Product created
    When I have a New Product with the following information
      | Product Name | Product Code | Product Description | active |
      | Computers    | 69489750     | desktop             | true   |
    And I delete the product
    Then the Product should be removed from the Product List




