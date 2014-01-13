Feature: Follow a Link

  Scenario: Simple link
    Given I am on the test page 1
    When I follow "follow-link-test Link"
    Then I should see a "follow-link-test OK" text
