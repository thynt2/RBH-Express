@uploadPhoto
Feature: UploadPhoto
  As a user I want to upload new photo

  @login
  Scenario: Login successfully with valid data
    When Input data into required field
    And Click Login button
    Then Verify user login success

  @homePage
  Scenario: Open Company Profile Page
    When Hover mouse to Admin page
    And Click to Company Profile page
    Then Verify Company Profile page display success

  @companyProfile
  Scenario: Upload Company Profile Image success
    When Upload new image success
    Then Verify success message will display
    And Click Save button
    When Click Done button
    Then Click sign out button