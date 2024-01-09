package ayvens;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class StepDefinition {
	
	int randomNum;
	JsonPath js,js1,js2;
	
	    

	    @Given("Entering  Random postId with given base URI")
	    public void getRandpmUsersEmail() {
	    	
	    	
	    	int min = 10;
	    	int max = 100;
	    	 randomNum = (int)(Math.random() * (max - min + 1)) + min;
	    	System.out.println(randomNum);
	    	
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	    	
	    }
	@When("Pick email with given random postId")
		public void pickEmail()
	{
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .param("postId", randomNum)
	                .when()
	                .get("/comments")
	                .then()
	                .extract().response();
	       js= new JsonPath(response.asString());
	    	  
	        
	}
	
	@Then("Print email address in console")
	public void printEmail()
	{
    	  // Get a random user and print his email address to the console
	        System.out.println("Email Address :  " + js.getString("email[0]").toString()); 
	        System.out.println(js.getInt("postId[0]"));
	        //Verify that each post contains a valid Post ID.
	        Assertions.assertEquals(js.getInt("postId[0]"), randomNum);
	  
	}
	    
	    
	    @Given("Create post with given URI")
	    public void CreatePost() {
	  	    		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	    }
		//create Post   
	    @When("Add a post with unique id and details")
		   public void addpost()
		   {
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	      Response createresponse = given().header("Content-type", "application/json")
	               .and() .body("{\r\n"
	               		+ "    \"postId\": 101,\r\n"
	              // 		+ "    \"id\": 101,\r\n"
	               		+ "    \"name\": \"RPendela\",\r\n"
	               		+ "    \"email\": \"RP@gmail.com\",\r\n"
	               		+ "    \"body\": \"creation\"\r\n"
	               		+ "  }")
	                .when()
	                .post("/posts")
	                .then()
	                .extract().response();
	      Assertions.assertEquals(201, createresponse.statusCode()); 
	         js1= new JsonPath(createresponse.asString());
	        
	    }
	    
	    @Then("verify newly created post with details")
	    public void verifyPost()
	   
	   {
	        System.out.println(js1.getString("postId"));
	     //   System.out.println(js.getString("id"));
	        System.out.println(js1.getString("name"));
	        System.out.println(js1.getString("email"));
	        System.out.println(js1.getString("body"));
	       
	        Assertions.assertEquals("101", js1.getString("postId").toString());
	       // Assertions.assertEquals("101", js.getString("id").toString());
	        Assertions.assertEquals("RPendela", js1.getString("name").toString());
	        Assertions.assertEquals("RP@gmail.com", js1.getString("email").toString());
	        Assertions.assertEquals("creation", js1.getString("body").toString());
	        
	        
	    }   
	    
	//   The api returns 10 users, for each user confirm the titles of their first and last post are not empty  
	    @Given("URI and resource details are provided")
	    public void getRequestwith10users() {
	    	
	    	
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		    
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/posts")
	                .then()
	                .extract().response();
    	   js2= new JsonPath(response.asString());
	    }
	    
    	@When("Pick 10 users")
    	
    	public void pick10users()
    	{
	    
	    for (int i=1 ;i<11;i++)
    	   {
    	    
    	    	 
    	    Assertions.assertNotEquals(js2.getString("title[" + i+ "]"), null);
    	    
    		  
    	  }
	    
	    
    	}
    	
    	@Then("Verify titles of thier first and last posts are not empt")
    	public void verifyTitles()
    	{
    	for (int i=1 ;i<11;i++)
 	   {
 	
    	 System.out.println(js2.getString("title[" + i+ "]"));
    	    
	}
	   
}       

}
