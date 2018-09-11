Feature: create a new Price Books

  Background:
    Given I login as "admin user" User

  Scenario Outline: Verify that is possible create a new price books
    When  I go to the Price Books page
    When I add the new Price Books "<Price Book Name>","<Description>"

    Examples: data of the Price Books
      | Price Book Name | Description |
      | DenisCCBooks    | hp and dell |