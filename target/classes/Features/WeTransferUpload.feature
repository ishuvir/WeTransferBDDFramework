Feature: WeTransfer UploadFile Automation

Scenario: WeTransfer File_Upload & Creation of Link Transfer

Given user is already on WeTransfer page
When T&C screen is displayed 
Then User clicks on Accept button
Then User upload a file from local system 
Then User select Get Transfer link option
Then User saves the Transfer link 

