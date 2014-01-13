Feature: Fill in a form

  Scenario: Input tag with explicit label
    Given I am on the "form elements" test page 1
    When I fill "fill-by-label-input Label Text" with "

    When I click on "click-button-test Button"
    Then I should see a "click-button-test OK" text