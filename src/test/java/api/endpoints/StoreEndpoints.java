package api.endpoints;

import api.payload.Store;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.Logger;

public class StoreEndpoints {
	
	



 public static Response createorder( Store storedata)
 {
	 

	 
	Response response = given().accept("application/json").contentType("application/json").
	 body(storedata).when().post(StoreRoutes.post_url);
	
	
	return response;
 }
	
 
 
 
 
  public static Response Getorder(String orderId) {
	  
	  
	  Response response=given().accept("application/json").
			  pathParam("orderId", orderId).when().get(StoreRoutes.get_url);
	  
	  
	return response;
	  
	  
	  
	  
  }
  

  public static Response Updateorder(String orderId, Store storepayload) {
	  
	  
	  Response response=given().accept("application/json").contentType("application/json").
			  pathParam("orderId", orderId).when().put(StoreRoutes.put_url);
	  
	  
	return response;
	  
  
  
	
}
  
  
  
public static Response deleteorder(String orderId) {
	  
	  
	  Response response=given().accept("application/json").contentType("application/json").
			  pathParam("orderId", orderId).when().delete(StoreRoutes.del_url);
	  
	  
	return response;
	  
  
  
}	
}
