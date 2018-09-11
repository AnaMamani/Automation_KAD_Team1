Feature: Create "Contact"

  @createContact
  Scenario:
    Given I login as "local user" User
    When I go to the Contact page
    And I click in New button
    When I fill the following form with the minimum requirement
      | First Name   | Last Name    |  title | email          | phone   | street     | city    | state   | country   |
      | Nando        | Valdez       |  Wolds | test1@mail.com | 2817123 | new flores | Bolivar |         | New York  |
    And I click in button Save
    Then Contact was created




