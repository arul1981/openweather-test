#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Home page weather forcast summary


  Scenario: Open the weather home page should show default weather details of Glassgow
    Given the firefox browser is opened
    When user navigates to HomePage "http://localhost:3000/"
    Then user should be displayed with five day forecast for the "Glassgow" city
    And user verify if the date starting order is correct


  Scenario Outline: when the user is one the home and try different cities in search box
    Given user is on the home page
    When user enters <city_name> on the home page
    Then user should be displayed with five day forecast for the <city_name> city

    Examples: 
      | city_name |
      | Edinburgh |
      | Glassgow  |

 
  Scenario Outline: when the user is one the home, try differnt alphanumeric and non existence city in text box
    Given user is on the home page
    When user enters <city_name> on the home page
    Then user should be displayed with <error_message>

    Examples: 
      | city_name | error_message             |
      | "234324"    | Unable to fetch the value |
      | sasdad    | Unable to fetch the value |
      
    Scenario Outline: when the user is one the home, try differnt cities text box
    Given user is on the home page
     When user clicks on any day
     Then user should be displayed with all details of the forecast for every 3 hourly forecast entry for the selected day
     But I don’t see summary of any other days


  Examples: 
  | city_name       | 
  | Edinburgh       |


  Scenario: If the three hour summary list of the day is select again then all the details should be hidden with only displaying the summary details of 5 day forecast
    Given user is on the home page
     When user clicks on again on the same day
     And it has the details of the three hour display
     Then 3 hour display details are hidden 
       But I see only the 5 day forecast
