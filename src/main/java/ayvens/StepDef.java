package ayvens;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class StepDef {
	
	    

	    @Test
	    public void getRandpmUsersEmail() {
	    	
	    	
	    	int min = 10;
	    	int max = 100;
	    	int randomNum = (int)(Math.random() * (max - min + 1)) + min;
	    	System.out.println(randomNum);
	    	
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		    
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .param("postId", randomNum)
	                .when()
	                .get("/comments")
	                .then()
	                .extract().response();
    	   JsonPath js= new JsonPath(response.asString());
    	  // Get a random user and print his email address to the console
	        System.out.println("Email Address :  " + js.getString("email[0]").toString()); 
	        System.out.println(js.getInt("postId[0]"));
	        //Verify that each post contains a valid Post ID.
	        Assertions.assertEquals(js.getInt("postId[0]"), randomNum);
	  
	}
	    
	    
	    @Test
	    public void CreatePost() {
	  	    		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		//create Post    
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
	        JsonPath js= new JsonPath(createresponse.asString());
	        System.out.println(js.getString("postId"));
	     //   System.out.println(js.getString("id"));
	        System.out.println(js.getString("name"));
	        System.out.println(js.getString("email"));
	        System.out.println(js.getString("body"));
	       
	        Assertions.assertEquals("101", js.getString("postId").toString());
	       // Assertions.assertEquals("101", js.getString("id").toString());
	        Assertions.assertEquals("RPendela", js.getString("name").toString());
	        Assertions.assertEquals("RP@gmail.com", js.getString("email").toString());
	        Assertions.assertEquals("creation", js.getString("body").toString());
	        
	        
	        
	    }   
	    
	//   The api returns 10 users, for each user confirm the titles of their first and last post are not empty  
	    @Test
	    public void getRequestwith10users() {
	    	
	    	
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		    
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/posts")
	                .then()
	                .extract().response();
    	   JsonPath js= new JsonPath(response.asString());
    	   for (int i=1 ;i<11;i++)
    	   {
    	    System.out.println(js.getString("title[" + i+ "]"));
    	    	 
    	    Assertions.assertNotEquals(js.getString("title[" + i+ "]"), null);
    	    
    		  
    	  }
    	    
	}
	   
	       

}
