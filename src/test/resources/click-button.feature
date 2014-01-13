Feature: Click on a Button

  Scenario: Normal Button
    Given I am on the "buttons and links" test page 1
    When I click on "click-button-test Button"
    Then I should see a "click-button-test OK" text
