Feature: Login Functionality 

@ft @build
Scenario: To verify Login functionality with valid credentials 

	Given  user is on login page 
	When user enters valid username "admin" and  password "manager" 
	And clicks on login page 
	
@smoke @build
Scenario Outline: to verify login functionality with multiple data 
	Given  user is on login page 
	When user enters valid username "<UserName>" and  password "<PassWord>" 
	And clicks on login page 
	Then Message should be displayed as login Successfull "<Expected_Result>" 
	
	Examples: 
		|UserName |PassWord   | Expected_Result           |	
		|admin    | manager   |actiTIME - Enter Time-Track|
		|admin1   | manager1  |actiTIME - Login           |
		
		@Regression @build
		Scenario: To verify Actime version 
			Given  user is on login page 
			When user enters valid username "admin" and  password "manager" 
			And clicks on login page 
			And clicks on help 
			And clicks on About actime 
			And verify the actime version "actiTIME 2014 Pro" 
			And user clicks on close 
			And user clicks on logout 
			Then login page should be displayed 
			
		@it @build
		Scenario: To Verify the bugs Reported 
		
			Given  user is on login page 
			When user enters valid username "admin" and  password "manager" 
			And clicks on login page 
			And clicks on help 
			And user clicks on report 
			And  user enters description "Ui issue" 
			And user enters first name "chethan" 
			And user enters last name "Shetty" 
			And user enters email "shetty.chethan257@gmail.com" 
			And users enters company "ABC" 
			And users clicks on send report 
			Then bug report should be submited successfully 
			
			
			
