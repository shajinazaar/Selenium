Feature: Login into Application

  Scenario: Login validation with correct credential
    Given Initialize the browser with chrome driver
    And Navigate to "QAClickAcademy" site
    And Click on login button to navigate sign in page
    When User enter "username" and "password"
    And click on login button
    Then Verify the user is successfully log in.