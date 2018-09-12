Feature: Create "Contact"
  Background:
    Given I login as "other role user" User

  @createContact
  Scenario: Verify that is possible create a new contact
    When I go to the Contact page
    And I click in New button
    When I create contact fill the following form with the requirement
      | First Name   | Last Name    |  title | email          | phone   | street     | city    | state   | country   |
      | Nando        | Valdez       |  Wolds | test1@mail.com | 2817123 | new flores | Bolivar |         | New York  |
    Then Contact was created message should be displayed in Contact Detail Page


