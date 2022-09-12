@login
Feature: Log in
  As user I want to log in with my credential successfully


  Scenario: Check validation when click close icon
    Given User has opened login with Phone No form
    When Check close login form when click close button
    Then Verify login form is closed