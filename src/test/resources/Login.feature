Feature: Login to the application and verify  Home page components along with Left Pane links

  Scenario:   User will log into the application
    Given User enter the keka url to login
    And   User verify that user is on login page
    And   User click on login with google
    When  user enter credentials

  Scenario: User will verify the Home page components
    Given user verify the first component
    And   user verify the second component

  Scenario: user verify the  left pane links
    And user verify the first six tab
    Then user verify the last seventh tab


