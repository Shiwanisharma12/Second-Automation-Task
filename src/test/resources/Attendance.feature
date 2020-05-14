Feature: Click on Link Me and select "Attendance" and verify "Attendance Log functionality" by verifying Last 30 and month wise data.

  Scenario: Scenario: User will log into the application
    Given User enter the keka url to login
    And   User verify that user is on login page
    And   User click on login with google
    When  user enter credentials


  Scenario: User will click on link me and select Attendance
    Given  user is on home page of the application
    When   user click on me link ,menu with multiple option appear
    Then  user click on Attendance and verify user is on attendance tab

  Scenario: user is clicking on month one by one
    When user is clicking on month one by one ana storing the attendance logs one by one






