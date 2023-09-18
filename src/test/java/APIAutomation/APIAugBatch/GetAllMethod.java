package APIAutomation.APIAugBatch;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllMethod 
{

	public static void main(String[] args) 
	{
		Response res= 
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/APIStudentBatch");
		
		System.out.println("Status code is ");
		System.out.println(res.statusCode());
	
		
	}
}
