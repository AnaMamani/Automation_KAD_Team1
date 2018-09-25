Feature: Create "Opportunities"

  Background:
    Given  I navigate to Login page
    And I login as "other role user" User

  Scenario: User should be able to create an Opportunity
    And I go to Opportunities page
    When I click New button Opportunities
    And  I create a Opportunity with the following information

      | oppyName | closeDate | stage         | account | privateOppy | amount |
      | OppyTest | 6/12/2018 | Qualification | Acme    | true        | 10000  |
