@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  Background:
    Given I navigate to Login page

  @SmokeTest @Logout
  Scenario Outline: Users should be able to login using valid credentials
    When I login as "<User Name>" with password "<Password>"
    Then I should login successfully with a "<Full Name>"

    Examples: Short pass
      | User Name               | Password   | Full Name   |
      | fuego@lluviacompany.com | asdfghjkl1 | Ana Zenteno |

  Scenario Outline:
    When I login as "<User Name>" with password "<Password>"
    Then I should'nt login and show the "<Error Message>"

    Examples: Short pass
      | User Name                | Password   | Error Message                                                                                                                           |
      | fuego@lluviacompany.comb | asdfghjkl1 | Compruebe su nombre de usuario y contraseña. Si sigue sin poder iniciar sesión, póngase en contacto con su administrador de Salesforce. |
      | fuego@lluviacompan.comb  |            | Introduzca su contraseña.                                                                                                               |




