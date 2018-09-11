Feature: Create "PriceBooks"

  Scenario Outline: Price Books
    Given I login as "local user" User
    When I go to the Price Books page
    And I click in New button of books
    When I fill the following form with requirement "<Price Book Name>", "<Description>"
    And I click in button Save og books
    Examples:
      |Price Book Name      | Description |
      |elmer                | Mendez      |