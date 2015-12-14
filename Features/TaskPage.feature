Feature: Task Page


    Background:
       Given I am logged in the main page


    Scenario: Add a task and set it done
      Given I click the My Tasks button
      When I type "Teste" in the task description field and press the add button
      And I click in the checkbox Done
      Then the background color of the task, should be green
