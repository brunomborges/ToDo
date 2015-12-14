Feature: Login Page

  Background:
    Given I am in the home page


    Scenario: Login with a valid account
      Given  I have clicked in the Sign In button
      And I have entered "brunomelgarejoborges@gmail.com" as a valid email address
      And I have entered "jbr2514201" as a valid password
      When I click the Sign In button
      Then I should go to the main page with the succsess message
