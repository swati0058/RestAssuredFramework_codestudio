package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;

public class UserEndpoints {

	
	public static Response  createUser(User payload) {
	Response response=given().accept("application/json").contentType("application/json").
	body(payload).
	when().post(Routes.post_url);
	
		return response;
	}
	
	
	public static Response GetUser(String userName) {
		
		Response response=
		given().accept("application/json").
		pathParam("username", userName).
		when().get(Routes.get_url);
		
			return response;
		}
		
	

	public static Response updateUser(String userName, User payload) {
		
		Response response=
		given().accept("application/json").contentType("application/json").
		pathParam("username", userName).body(payload).
		when().put(Routes.put_url);
		
			return response;
		}
		
	
	

	public static Response DeleteUser(String userName) {
		
		Response response=
		given().accept("application/json").contentType("application/json").
		pathParam("username", userName).
		when().delete(Routes.del_url);
		
			return response;
			
			
		}
		
	
	}


