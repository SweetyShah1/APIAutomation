package APIAutomation.APIAugBatch;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.response.Response.*;

import static io.restassured.RestAssured.*;

public class PostRequestUsingJsonFile {

	public static void main(String[] args) throws FileNotFoundException
	{
		File f= new File("C:\\Users\\Siddhi Shah\\git\\APIAutomation\\requestbody.json");
		FileReader fr= new FileReader(f);
		JSONTokener js= new JSONTokener(fr);
		JSONObject jo= new JSONObject(js);
		
		//System.out.println(jo.toString());
		String requestbody= new String(jo.toString());
		
		Random r= new Random();
		Integer RandomIntValue= r.nextInt();
		requestbody= requestbody.replaceAll(Pattern.quote("{{id}}"), RandomIntValue.toString());
		
		System.out.println("Request body is");
		System.out.println(requestbody);
		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(requestbody)
		.when()
		.post("http://localhost:3000/APIStudentBatch");
		
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		
	}

}
