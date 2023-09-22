package APIAutomation.APIAugBatch;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestUsingPojoClass 
{
	public static void main(String[] args) 
	{
		BasicInformation basic= new BasicInformation();
		
		basic.setFirstname("Chandani");
		basic.setLastname("Jariwala");
		basic.setDesignation("Developer");
		basic.setId("ChandaniJa");
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(basic)
		.when()
		.post( "http://localhost:3000/APIStudentBatch");
		
		System.out.println("Status code is " + res.statusCode());
		
	}

}
