Feature: As a user I am testing JSON Placeholder application for
  fetching posts from specific user
  fetching comments for post from the user
  email format for each comments

  @test
  Scenario: Testing JSON Placeholder for comments validation by specific user
    Given I fetch the user Samantha
    When I fetch id for the User Samantha 
    And I fetch posts from Samantha
    And I retrieve comments for the posts from Samantha
    Then I make sure email address for the comments displayed in the proper format


  # ------Scenarios below this line are not implemented --------------------
  Scenario: Testing JSON Placeholder to fetch the posts for invalid user
    Given I fetch the user hyperactivegoat
    Then Then I make sure email address for the comments displayed in the proper format


  Scenario: Testing JSON Placeholder to validate the comments for user who does not have post
    Given I search the user in JSON Placeholder and make sure no posts tagged to user 
#    or create new user if no user existing without posts tagged
    When I fetch id for the User userwithoutposts
    And I fetch posts from userwithoutposts
    Then Message appears saying no posts displayed for specific user


  Scenario: Testing JSON Placeholder to validate comments for the posts without comments
    Given I search the user in JSON Placeholder and make sure no posts tagged to user
    When I fetch id for the User userpostwithoutcomments
    And I fetch posts from userpostwithoutcomments
    And I retrieve comments for the posts from userpostwithoutcomments
    Then Message appears saying posts does not have any comments













