Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|prabhat.pk589@gmail.com|Selenium12345|


Scenario: Account Page Title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account Section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6