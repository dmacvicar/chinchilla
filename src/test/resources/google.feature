Feature: Google page

  Scenario: Click on help
    Given I go to google
    When I follow "About"
    Then I should see a "mission" text
