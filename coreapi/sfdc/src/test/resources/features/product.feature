Feature: Create a "Product"

  Background:
    Given I navigate to Login page
     And I login as "admin user" User
    When I go to the Product page

  @CreateProduct
  Scenario: Verify that is possible create a new Product
    Given I create a Product with the following information
      | Product Name | Product Code | Product Description | Active |
      | Computers    | hp and dell  | desktop and laptops | true   |
    Then the Product Details Page should be display with the information of the product created

  @EditProduct
  Scenario: Verify that is possible Edit a product created
    Given I create a Product with the following information
      | Product Name | Product Code | Product Description | Active |
      | Computers    | 69489750     | desktop             | true   |
    When I Edit the Product information with the following information
      | Product Name | Product Code | Product Description | Active |
      | Computers    | 0215424      | laptops             | false  |
    Then the Product Details Page should be display with the information of the product updated

  @DeleteProduct
  Scenario: Verify that is possible Delete a Product created
    Given I create a Product with the following information
      | Product Name | Product Code | Product Description | Active |
      | Computers    | 69489750     | desktop             | true   |
     And I delete the product
    Then the Product should be removed from the Product List




