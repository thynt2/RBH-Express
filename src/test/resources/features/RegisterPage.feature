@register
Feature: Register
  As user I want to register personal account


  Scenario: Check validation when no input data
    Given User has opened personal register form
    When Click submit button
    Then Check validation message at required fields