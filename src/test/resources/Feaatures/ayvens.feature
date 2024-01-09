#Author: your.email@your.domain.com
#Keywords Summary : Ayvens Test Scenarios
#Feature: 
###a. Get a random user and print his email address to the console.
#b. Verify a Random User’s Posts:
#Verify that each post contains a valid Post ID.
#c. Create a Post:
#Create a post and verify the response.
#Think of more than one scenario to improve the coverage of “/posts“ resource
#d. The api returns 10 users, for each user confirm the titles of their first and last post are not empty

Feature: Ayvens Tests
 
 
   @randomUserEmail
  Scenario: Get a random user and print his email address to the console
    Given Entering  Random postId with given base URI 
    When Pick email with given random postId
    Then Print email address in console
    

  @CreateandVerifypost
  Scenario: Create post and verify response
    Given Create post with given URI 
    When Add a post with unique id and details
    Then verify newly created post with details
    
    @Verify10UsersFirstandLastTitle
   Scenario:The api returns 10 users, for each user confirm the titles of their first and last post are not empty 
    Given URI and resource details are provided 
    When Pick 10 users 
    Then Verify titles of thier first and last posts are not empt
    
    