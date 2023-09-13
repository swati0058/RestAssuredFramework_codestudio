package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;
	public static Logger log;
	
	@BeforeClass
	public void generateTestData() {
	faker= new Faker();
	userpayload= new User();
	System.out.println("genearting data");
	
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());

	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPassword(faker.internet().safeEmailAddress());
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	
	
	log= LogManager.getLogger("Testrestassured");
	

	
	}
	

	
	@Test(priority=1)
	public void testCreateUser() {
		System.out.println("user creating ");
		log.info("user creating");
		Response response=	UserEndpoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
		
		
		
	}
	
		
	
		
	
	
@Test(priority = 2)
	
	public void  testGetUser() {
	System.out.println("getting user ");
	log.info("Get the details yhe user");
	Response response=	UserEndpoints.GetUser( this.userpayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		}


@Test(priority = 3)

public void  testUpdateUser() { 
	
	userpayload.setFirstName(faker.name().firstName());
	System.out.println("updating user ");
	log.info("updating the user ");
Response response=	UserEndpoints.updateUser( this.userpayload.getUsername(),userpayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);  
	
	
	
	/*
	 * System.out.println("reading data after updating "); Response response1=
	 * UserEndpoints.GetUser( this.userpayload.getUsername());
	 * response1.then().log().all();
	 * 
	 * Assert.assertEquals(response1.getStatusCode(),200);
	 */

	
	
	}






@Test(priority = 4)

public void  testdeleteUser() {
	System.out.println("deleting user ");
	log.info("deleting user ");
	
	//userpayload.setFirstName(faker.name().firstName());
Response response=	UserEndpoints.DeleteUser( this.userpayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);
	
	
	}


}