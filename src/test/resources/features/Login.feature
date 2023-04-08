@LoginFeature
Feature: PVH B2B Feature

@sanity @regression 
Scenario: SC_01_Validate basic checks on Login widget
    Given I navigate to the application URL ""
    When I click on Sign In button
    Then I should see "SIGN IN" as a header of the Login widget
    And I should see Create an account link
    And I should select Remember me checkbox

@sanity @regression    
Scenario: SC_02_Validate Login positive flow
    Given I navigate to the application URL "https://pt.tommy.com/men"
    When I enter valid login credentials
    Then I should logged in successfully in the application

@regression
Scenario Outline: SC_03_Validate Login negative flow with invalid credentials and empty values in "<textField>" field 
    Given I navigate to the application URL "https://pt.tommy.com/men"
    When I enter invalid "<textField>" in login credentials
    Then Application should display "username and password don't match" error message
    And I close the sigin dialog
    And I click on Sign In button
    And I provide empty value in "<textField>" textbox
    Then Application should display "You need to fill in this field" error message below "<textField>" textbox
    And I close the sigin dialog
    Examples:
      | textField 				|
      | email				      |
      | password 			  	|

@regression   
Scenario Outline: SC_04_Validate Login negative flow with invalid format"<credentialFormat>"
    Given I navigate to the application URL "https://pt.tommy.com/men"
    When I enter invalid "<credentialFormat>" in login credentials
    Then Application should display "<credentialFormat>" error message
    Examples:
      | credentialFormat 	|
      | email format      |
      | password format  	|
    

      
