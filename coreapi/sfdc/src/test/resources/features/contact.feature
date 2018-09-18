Feature: Create "Contact"

  Background:
    Given I navigate to Login page
      And I login as "local user" User
    When I go to the Contact page

  @createContact
  Scenario: Verify that is possible create a new contact
    Given I create a Contact with the following information
      | First Name | Last Name | title | email          | phone   | street     | city    | state | country  |
      | salem      | corona    | Wolds | hello@mail.com | 2817123 | new flores | Bolivar |       | New York |
    Then the Contact Details Page should be display with the information of the contact

#  @editContact
#  Scenario: Verify that is possible to edit a Contact to register
#    Given I create a Contact with the following information
#      | First Name | lastName | title | email          | phone   | street     | city    | state | country  |
#      | oscarjoel  | solares  | sur   | hello@mail.com | 2817123 | new flores | Bolivar |       | New York |
#    When I edit this Contact with the following information
#      | First Name | lastName | title |
#      | grover     | ali      | este  |
#    Then the Contact Details Page should be display with the information of the contact update

#  @deleteContact
#  Scenario: Verify that is possible to delete a Contact to created
#    Given  I create a Contact with the following information
#      | First Name | Last Name   | title     | email          | phone | street | city | state | country |
#      | Jhon       | corona luna | Woldsseda | mundo@mail.com |       |        |      |       |         |
#    When I delete this Contact create
#    Then I should see the Contact is delete