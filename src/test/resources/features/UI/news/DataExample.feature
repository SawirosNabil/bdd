@example
Feature: Arguments in steps and features example

  @args
  Scenario: show case all argument usage
    Given User chose city as "New York" and state as "NY"
    When add 3 to 5
    And walk 4.6 mile
    Then user should say hello

  
  
  
  @Exampletable
  Scenario Outline: showcase Scenario Outline with examples table
  Given User is "<type>" level
  Then User should be able to "<access>"
  Examples:
   |  type  |  access   |
   | admin  |  manage |
   | client |  view     |
   | visitor | drink coffee |
   |  drop-in  |  ~~dance~~   |
   
   
     
       @table1
  Scenario: showcase datatable without header
    Given I have following grade
     |English |  A  | 
     |Math   |  B  |
     |Science |  C  |
  Then I am happy
    
  @table2
Scenario: showcase datatable with header
    Given I have following header grade
     |header  | grade  |
     |Math    |  B  |
     |Science |  C  |
     |English |  A  
