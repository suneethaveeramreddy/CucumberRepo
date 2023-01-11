Feature: New Company Feature 

Background: 
Given user has already logged into the application
|username|password|
|suneethav|Secure#12|

Scenario Template: New Campany addition with different set of data 
Given User is on New Company page 
When User fills the  details from the given sheetname "<SheetName>" and rownumber <RowNumber>
And Clicks on save button 
Then the company should be added 

Examples:
|SheetName|RowNumber|
|Company|0|
|Company|1|
|Company|2|
|Company|3|
|Company|4|