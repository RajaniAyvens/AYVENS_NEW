$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feaatures/ayvens.feature");
formatter.feature({
  "name": "Ayvens Tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get a random user and print his email address to the console",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@randomUserEmail"
    }
  ]
});
formatter.step({
  "name": "Entering  Random postId with given base URI",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.getRandpmUsersEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Pick email with given random postId",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.pickEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print email address in console",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.printEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create post and verify response",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@CreateandVerifypost"
    }
  ]
});
formatter.step({
  "name": "Create post with given URI",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.CreatePost()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a post with unique id and details",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.addpost()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify newly created post with details",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verifyPost()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The api returns 10 users, for each user confirm the titles of their first and last post are not empty",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Verify10UsersFirstandLastTitle"
    }
  ]
});
formatter.step({
  "name": "URI and resource details are provided",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.getRequestwith10users()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Pick 10 users",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.pick10users()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify titles of thier first and last posts are not empt",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.verifyTitles()"
});
formatter.result({
  "status": "passed"
});
});