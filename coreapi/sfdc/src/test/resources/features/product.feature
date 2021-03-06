@Product
Feature: Create a "Product"

  Background:
    Given I navigate to Login page
      And I login as "admin user" User


  @deleteProduct
  Scenario: Verify that is possible to Create a Product
    Given I go to the Product page
    When I click New button Product
      And I create a Product with the following information
      | Product Name   | Product Code | Product Description | Active |
      | Computers Dell | hp and dell  | desktop and laptops | true   |
    Then the Product should be displayed in Product Details page
      And the Product should be created

  @deleteProduct
  Scenario: Verify that is possible to Edit a product
    Given I have a Product created with the following information
      | Product Name  | Product Code | Product Description | Active |
      | Computers IOs | 69489750     | desktop             | true   |
    When I go by URL to the Product created
      And I click Edit Product button
      And I Edit the Product with the following information
      | Product Name     | Product Code | Product Description | Active |
      | Computers Gamers | 0215424      | laptops             | false  |
    Then the Product Details Page should be displayed with the edited information
      And the Product should be updated

  @deleteProduct
  Scenario: Verify that is possible Delete a Product created
    Given I have a Product created with the following information
      | Product Name | Product Code | Product Description | Active |
      | Computers HP | 69489750     | desktop full        | true   |
    When I go by URL to the Product created
      And I click Delete Product button
    Then the Product should be removed from the Product List
      And the Product should be deleted
