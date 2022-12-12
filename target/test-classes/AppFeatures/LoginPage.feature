Feature: Login Page feature

Scenario: Login Page title
Given user is on login page
When user gets the title of the page 
Then page title should be "Free CRM - CRM software for customer relationship management, sales, and support."

Scenario: Forgot Password link
Given user is on login page 
Then forgot password link should be displayed 

Scenario: Login with correct credentials
Given user is on login page 
When user enters username "suneethav"
And user enters password "Secure#12"
And user clicks on Login button 
Then user gets the title of the page 
And page title should be "CRMPRO"