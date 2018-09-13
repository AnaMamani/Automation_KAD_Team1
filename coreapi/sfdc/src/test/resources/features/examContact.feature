Feature: Create Contact exam

  Background:
    Given I login as "local user" User

  @createContact
  Scenario: Verify that is possible create a new contact
    When  I go to the Contact page
    And I click in New button
    When I create contact fill the following form with the requirement
      | First Name | Last Name | title | email          | phone   | street     | city    | state | country  |
      | salem      | corona    | Wolds | hello@mail.com | 2817123 | new flores | Bolivar |       | New York |
    Then Contact was created should be displayed in ContactDetailPage
    Given I have an Contat with the following information
      | First Name | Last Name |
      | mijail     | Hello     |
    When I select the Contact