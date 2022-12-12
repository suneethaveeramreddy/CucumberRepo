Feature: Home Page Feature

Background: 
Given user has already logged into the application
|username|password|
|suneethav|Secure#12|

Scenario: Home Page title
Given: user is on Home page 
When user gets the title of the page 
Then page title should be "CRMPRO"

Scenario: LoggedIn username
Given: user is on Home page 
Then loggedin username should be "User: Suneetha Veeramreddy"

Scenario: Home Page Labels count 
Given: user is on home page 
Then user gets home page labels section 
|HOME|
|CALENDAR|
|COMPANIES|
|CONTACTS|
|DEALS|
|TASKS|
|CASES|
|CALL|
|EMAIL|
|DOCS|
|FORMS|
|REPORTS|
And home page labels section count should be 12
