package api.endPoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// created for perform CRUD Operations create, Read, update,delete
public class UserEndPoint_propertiesFile {
	
	
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes");
	return routes;
	}
	
	
	
	public static Response createUser(User payload){
		
		
	String post_url	=getURL().getString("post_url");
		
		Response response=given()
			.contentType(ContentType.JSON)//what type of data you are passing
			.accept(ContentType.JSON) // this is header
			.body(payload)
			
		.when()
			.post(post_url);
		
		return response;
	}
	public static Response readUser(String userName){
		
		String get_url	=getURL().getString("get_url");
		
		Response response=given()
			.pathParam("username", userName)
			
		.when()
			.get(get_url);
		
		return response;
	}
	public static Response updateUser(String userName, User payload){
		

		String update_url	=getURL().getString("update_url");
		
		Response response=given()
			.contentType(ContentType.JSON)//what type of data you are passing
			.accept(ContentType.JSON) // this is header
			.pathParam("username", userName)
			.body(payload)
			
		.when()
			.put(update_url);
		
		return response;
	}
	public static Response deleteUser(String userName){
		

		String delete_url	=getURL().getString("delete_url");
		
		Response response=given()
			.pathParam("username", userName)
			
		.when()
			.delete(delete_url);
		
		return response;
	}

}
