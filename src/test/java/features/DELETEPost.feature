Feature: Delete Posts
  Test the delete operation

  @smoke
  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation for "/posts" with body as
      | id  | title              | author            |
      | 111 | API Testing course | ExecuteAutomation |
    And I Perform DELETE operation for "/posts/{postid}"
      | postid |
      | 111    |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 111    |
    Then I should not see the body with title as "API Testing course"