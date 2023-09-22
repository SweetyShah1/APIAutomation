package APIAutomation.APIAugBatch;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequestUsingOrgJson_ComplexJSON {

	public static void main(String[] args)
	{
		JSONObject j= new JSONObject();
		
		JSONObject inner1 = new JSONObject();
		inner1.put("Sector","S12");
		inner1.put("ward no" , "w123");
		inner1.put("House no", "123");
		inner1.put("Address type", "Primary Address");
		
		JSONObject inner2 = new JSONObject();
		inner2.put("Sector","S13");
		inner2.put("ward no" , "w1234");
		inner2.put("House no", "House_41");
		inner2.put("Address type", "Secondary Address");
		
		JSONArray ja= new JSONArray();
		ja.put(0, inner1);
		ja.put(1,inner2);
		
		JSONObject outer= new JSONObject();
		outer.put("firstname","Pradeep");
		outer.put("lastname","Patel");
		outer.put("id", "Pradeep");
		outer.put("Designation", "QA Manager");
		outer.put("Address Details", ja);
		
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(outer.toString())
		.when()
		.post("http://localhost:3000/APIStudentBatch");
		
		System.out.println("Status code is "+ res.statusCode() );
		

	}

}
