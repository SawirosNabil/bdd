@SignUp   @API
Feature: SignUp and login Service
  

  @APIRegression
  Scenario: Validate registration and login service
    Given Execute the registration service with email "eve.holt@reqres.in" and password "pistol"
    When Sign in with email "eve.holt@reqres.in" and password "pistol"
    Then Validate the token is "QpwL5tke4Pnpja7X4"