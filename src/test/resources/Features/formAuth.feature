Feature: Form Authentication:tests for the form to login and validate

  Scenario: Login with Valid credentials
    Given Browser is opened
    When user navigates to the-internet.herokuapp URL and clicks on Form Authentication link
    And user enters the valid username "tomsmith" and password  "SuperSecretPassword!" provided on the landing page
    Then user successfully login into the Form Authentication page and validate
    And user logout and validate loggged out

  Scenario: Login with Invaalid Username
    Given Browser is opened
    When user navigates to the-internet.herokuapp URL and clicks on Form Authentication link
    And user enters an invalid invalidusername "tomsmit" and password  "SuperSecretPassword!" provided on the landing page
    Then user unsuccessfully login into the Form Authentication page and validate,due to inavid username

  Scenario: Login with Invalid Password
    Given Browser is opened
    When user navigates to the-internet.herokuapp URL and clicks on Form Authentication link
    And user enters the username "tomsmith" and an invalid invalidpassword  "SuperSecretPassword" provided on the landing page
    Then user unsuccessfully login into the Form Authentication page and validate,due to inavid password
