Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "My Store123"

Scenario: Forgot Password Link
Given user is on login page
Then forgot your password link should be displayed


Scenario: Login withou credentials
Given user is on login page
When user enters username "prabhat.pk589@gmail.com"
Then user enters password "Selenium12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"


