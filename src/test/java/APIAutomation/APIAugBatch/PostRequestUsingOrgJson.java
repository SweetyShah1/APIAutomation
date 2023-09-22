package APIAutomation.APIAugBatch;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequestUsingOrgJson {

	public static void main(String[] args)
	{
		JSONObject j= new JSONObject();
		j.put("firstname","Komal");
		j.put("lastname","Patel");
		j.put("id", "Kpatel");
		j.put("Designation", "TRAINEE");
		
		System.out.println("Body data is ");
		System.out.println(j.toString());
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(j.toString())
		.when()
		.post("http://localhost:3000/APIStudentBatch");
		
		System.out.println("Status code is "+ res.statusCode() );
		

	}

}
