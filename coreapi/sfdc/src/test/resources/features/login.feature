@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest @Logout
  Scenario Outline: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "<User Name>" with password "<Password>"
    Then I should login successfully

    Examples: Short pass
      | User Name                | Password    |
      | fuego@lluviacompany.com  | asdfghjkl1  |

  Scenario Outline:
    Given I navigate to Login page
    When I login as "<User Name>" with password "<Password>"
    Then I should'nt login and show the "<Error Message>"

  Examples: Short pass
  | User Name                 | Password    | Error Message |
  | fuego@lluviacompany.comb  | asdfghjkl1 | Compruebe su nombre de usuario y contraseña. Si sigue sin poder iniciar sesión, póngase en contacto con su administrador de Salesforce. |
  | fuego@lluviacompan.comb   |            | Introduzca su contraseña. |