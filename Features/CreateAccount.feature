Feature: Account Creation

    Background:
        Given I am in the home page

    Scenario: Create a  valid account
        Given I have clicked in the Sign Up button
        And I have entered "Bruno" as a name
        And I have entered a valid email address
        And I have entered "12345678" as a password
        And I have entered "12345678" as a password confirmation
        When I press the Sign Up button
        Then I should go to the main page with the succsess message

        Scenario: Create an account with a password lesser than 8 digits
            Given I have clicked in the Sign Up button
            And I have entered "Bruno" as a name
            And I have entered a valid email address
            And I have entered "123" as a password
            And I have entered "123" as a password confirmation
            When I press the Sign Up button
            Then I should stay in the same page with the error message

          Scenario: Create an account with no email entered
            Given I have clicked in the Sign Up button
            And I have entered "Bruno" as a name
            And I have entered "12345678" as a password
            And I have entered "12345678" as a password confirmation
            When I press the Sign Up button
            Then I should stay in the same page with the error message