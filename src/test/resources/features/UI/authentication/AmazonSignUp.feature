@SignUp @Authentication
Feature: Amazon function
 As a user, I want to sign up with proper information
 
 
 @uiRegression
 Scenario: User sign up with proper info
   Given User goes to Amazon sign up page
   When User enter personal information
   Then User should be able to verify something
   
   
 @second @uiSmoke
 Scenario: User try to sign up but look at privacy page
   Given User goes to Amazon sign up page
   When User enter personal information
   And User click the privacy link
   Then User should verify something and highlight headline
  
  
