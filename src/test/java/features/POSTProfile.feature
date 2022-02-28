Feature: Post Profile
  Test POST operation using REST-assured

  Scenario: Verify POST operation
    Given I perform POST operation for "/posts"

  Scenario: Verify Post operation for Profile
    Given I Perform POST operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Sam  | 2       |
    Then I should see the body has name as "Sam"
