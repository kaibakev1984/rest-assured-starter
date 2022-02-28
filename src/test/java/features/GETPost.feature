Feature:
  Verify different GET operations usin REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author name as "typicode"

  Scenario: Verify collection of authors in the post
    Given I perform GET operation for "/post"
    Then I should see the author names


  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/posts"
    Then I should see verify GET parameter
