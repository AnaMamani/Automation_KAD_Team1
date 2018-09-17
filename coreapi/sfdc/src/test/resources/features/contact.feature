Feature: Create "Contact"

  Background:
    Given I navigate to Login page
    And I login as "local user" User
    And I go to the Contact page
    And I click in New button

  @createContact
  Scenario: Verify that is possible create a new contact
    When I create contact fill the following form with the requirement
      | First Name | Last Name | title | email          | phone   | street     | city    | state | country  |
      | salem      | corona    | Wolds | hello@mail.com | 2817123 | new flores | Bolivar |       | New York |
    Then Contact was created should be displayed in ContactDetailPage

  @editContact
  Scenario: Verify that is possible to edit a Contact to register
    Given I have a Contact with the following information
      | First Name | lastName | title | email          | phone   | street     | city    | state | country  |
      | oscarjoel  | solares  | sur   | hello@mail.com | 2817123 | new flores | Bolivar |       | New York |
    When I edit this Contact with the following information
      | First Name | lastName | title | email | phone | street | city | state | country |
      | grover     | ali      | este  |       |       |        |      |       |         |
    Then Contact was saved with the information actual in Contact Detail

  @deleteContact
  Scenario: Verify that is possible to delete a Contact to created
    Given I have a Contact with the following information
      | First Name | Last Name   | title     | email          | phone | street | city | state | country |
      | Jhon       | corona luna | Woldsseda | mundo@mail.com |       |        |      |       |         |
    When I delete this Contact create
    Then I should see the Contact is delete