@ login
Feature: LoginPage

   Scenario Outline:user should not be able to login with invalid credential

     Given user is on Login page
     When user enters invalid"<Email>" or "<Password>"
     Then user should able to see the "<error message>"

     Examples:

       | Email             |Password   |error message|
       |rajpatel@gmail.com |raj1234    |Login was unsuccessful. Please correct the error and try again.The credential provided are |
       |rajpatel@gmail.com |raj123     |Login was unsuccessful.Please correct the errors and try again.No customer account found |
       |rajpatel@gmail.com |           |Login was unsuccessful.Please correct the errors and try again.No customer account found |
       |rajpatel@gmail.com |raj12      |Login was unsuccessful.Please correct the errors and try again.No customer account found |
