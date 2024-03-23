@Login
Feature: Login

  Background: User opens url
    When User opens url "https://beksiteoldalpha.kartega.com/login"

#Using parameter
  Scenario: Successful login with valid credentials

    And   User enters email as "test.esra"
    And   User enters password as "12341234"
    And   Click on login
    Then  Verify that you can get the mainpage
    And   Close website

  Scenario: Unsuccesful login with invalid credentials
    And  User enters email as "testtest"
    And  User enters password as "0000"
    And  Click on login
    Then Verify that you can't get to loginpage

 #Ctrl + Alt +L => collocate the table
 #Using datatable
  @dataTable
  Scenario: Login with different credentials
    Given User enter the following values for login
      | username     | password |
      | test.uskudar | 123123   |
    And Click on login

  @test
  Scenario Outline: Login with different credentials
    Given User enters "<username>" and "<password>"
    Examples:
      | username     | password |
      | test.uskudar | 123123   |
      | test.esra    | 12341234 |
