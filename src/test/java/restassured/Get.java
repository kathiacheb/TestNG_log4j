package restassured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get {
  @Test
  public void f() {
	  baseURI="https://reqres.in";
	  String listuser_endpoint= "/api/users?page=2";
	  
	  Response listusergetresponse= get(baseURI+listuser_endpoint);
	 // listusergetresponse.prettyPrint();
	  
	  
	  // if we wanna print it as a string we can do
	String responsebody= listusergetresponse.asString();
	 System.out.println(responsebody);
	  
	 int  statuscode= listusergetresponse.getStatusCode();
	 System.out.println(statuscode);
	  
	// if (statuscode == 200) {
	//	 System.out.println("test is passed"); }
	// else { System.out.println("test is failed"); }
	 
	 // if we want to verify and check about the statuscode , we can use hard assert
	 
	// assertEquals(statuscode, 200);
	 
	 SoftAssert softassert= new SoftAssert();
	 softassert.assertEquals(statuscode,200, "the status code is 200");
	 softassert.assertAll();
	 
	 
	  //for verification we can also use softassert
	 // SoftAssert softassert= new SoftAssert();
	 // softassert.assertTrue(responsebody.toLowerCase().contains("lindsay.ferguson@reqres.in"), "this assert for email verification");
	 // softassert.assertAll();
	  
  }
}
