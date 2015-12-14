Feature: Subtask Modal

    Background:
      Given I am logged in the main page

      Scenario: Open the subtask modal
        Given I click the My Tasks button
        When I type "Teste" in the task description field and press the add button
        And I click in the subtasks button
        Then The subtask modal should open correctly

    Scenario: Add a Subtask and set it done
      Given I click the My Tasks button
      When I type "Teste" in the task description field and press the add button
      And I click in the subtasks button
      And I add "SubTeste" at the subtask description
      And I add "14/12/2015" as a Date
      And I click in the checkbox
      Then the background color of the subtask, should be green