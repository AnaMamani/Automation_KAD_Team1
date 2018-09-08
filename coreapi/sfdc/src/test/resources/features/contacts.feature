Feature: Create "Contact"

  Scenario Outline:
    Given I login as "local user" User
    When I go to the Contact page
    And I click in New button
    When I fill the following form with the minimum requirement "<First Name>", "<Last Name>"
    And I click in button Save
    Examples:
      |First Name      |Last Name|
      |elmer           | Mendez  |

