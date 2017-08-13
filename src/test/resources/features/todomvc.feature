Feature: Test todomvc.com

  Scenario: I can Navigate to angularjs
    Given I navigate to todomvc.com
    When I click AngularJS link
    Then I am on AngularJS page

  Scenario: 1. I want to add a To-do item
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    Then Item First Item is added. Seq:1

#  Scenario: 2. I want to edit the content of an existing To-do item
#    Given I navigate to AngularJS page
#    When I add a To-do item First Item
#    Then Item First Item is added. Seq:1
#    When update the content of First Item To-do item to First Item Changed
#    Then Todo item 1 has value First Item Changed


  Scenario: 3. I can complete a To-do by clicking inside the circle UI to the left of the To-do
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    Then Item 1 is not done
    And I click the item 1 done
    Then Item 1 is done

  Scenario: 4. I can re-activate a completed To-do by clicking inside the circle UI
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    And I click the item 1 done
    Then Item 1 is done
    And I click the item 1 done
    Then Item 1 is not done

  Scenario: 5. I can add a second To-do
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    Then Item First Item is added. Seq:1
    When I add a To-do item Second Item
    Then Item First Item is added. Seq:1
    And Item Second Item is added. Seq:2

  Scenario: 6. I can complete all active To-dos by clicking the down arrow at the top-left of the UI
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    And I add a To-do item Second Item
    And I add a To-do item Third Item
    And I click all items done
    Then Item 1 is done
    Then Item 2 is done
    Then Item 3 is done

  Scenario: 7. I can filter the visible To-dos by Completed state
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    And I add a To-do item Second Item
    And I click the item 1 done
    And I click on completed filter
    Then Todo First Item is presented on the screen
    Then Todo Second Item is not presented on the screen

#  Scenario: 8. I can clear a single To-do item from the list completely by clicking the Close icon.
#    Given I navigate to AngularJS page
#    When I add a To-do item First Item
#    And I add a To-do item Second Item
#    And I click remove item 1
#    Then Todo First Item is not presented on the screen
#    Then Todo Second Item is presented on the screen


  Scenario: 9. I can clear all completed To-do items from the list completely
    Given I navigate to AngularJS page
    When I add a To-do item First Item
    And I add a To-do item Second Item
    And I click all items done
    And I click Clear All Completed Button
    Then Todo First Item is not presented on the screen
    Then Todo Second Item is not presented on the screen

