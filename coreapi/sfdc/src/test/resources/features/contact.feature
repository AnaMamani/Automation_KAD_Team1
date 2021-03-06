@Contact
Feature: Create "Contact"

  Background:
    Given I navigate to Login page
    And I login as "admin user" User

  @deleteContact
  Scenario: Verify that is possible create a new contact
    Given I go to the Contact page
    When I click New button for create
      And I create a Contact with the following information
      | First Name | Last Name | Title | Email          | Phone   | Street     | City    | State | Country  |
      | salem      | corona    | Wolds | hello@mail.com | 2817123 | new flores | Bolivar | ds    | New York |
    Then the Contact Details Page should be display with the information of the contact
      And the Contact should be created

  @deleteContact
  Scenario: Verify that is possible to edit a Contact to register
    Given I have a Contact with the following information
      | First Name | Last Name | Title | Email          | Phone   | Street     | City    | state | Country  |
      | oscarjoel  | solares   | sur   | hello@mail.com | 2817123 | new flores | Bolivar | sa    | New York |
    When I Select the Contact created by URL
      And I click Edit button contact
      And I edit this Contact with the following information
      | First Name | Last Name | Title | Phone   |
      | grover     | ali       | este  | 4364578 |
    Then the Contact Details Page should be display with the information of the contact update
      And the Contact should be updated

  @deleteContact
  Scenario: Verify that is possible to delete a Contact to created
    Given I have a Contact with the following information
      | First Name | Last Name   | Title     | Email          | Phone  | Street | City | State | Country |
      | Jhon       | corona luna | Woldsseda | mundo@mail.com | 784545 | hello  | word | rain  | La Paz  |
    When I Select the Contact created by URL
      And I click Delete button contact
    Then I should see the Contact is delete
      And the Contact should be deleted
