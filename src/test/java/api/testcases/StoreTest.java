package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints;
import api.endpoints.userEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTest {
	
	Faker faker;
	Store storepayload;
	public static Logger logger;

	@BeforeClass
	public void generateTestData()
	{
		faker = new Faker();
		storepayload = new Store();

		storepayload.setPetId(faker.idNumber().toString());
		storepayload.setQuantity(faker.number().toString());
		storepayload.setShipDate(faker.date().toString());
		storepayload.setStatus(faker.name().toString());
		


		//obtain logger

		logger = LogManager.getLogger("RestAssuredAutomationFramework_test");
	}

	
	

	@Test(priority=1)
	public void testCreateOrder()
	{
		Response response = StoreEndpoints.createorder(storepayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//log
		logger.info("Create order  executed.");
	}

	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = StoreEndpoints.Getorder(this.storepayload.getPetId());

		System.out.println("Read store Data.");
		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//log
		logger.info("Get order  Data executed.");
	}
	
	@Test(priority=3)
	public void testUpdateUser()
	{
		storepayload.setPetId(faker.idNumber().toString();
		Response response =StoreEndpoints.Updateorder(this.storepayload.getPetId(),storepayload);


		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//Read User data to check if first name is updated 

		Response responsePostUpdate = userEndPoints.GetUser(this.userPayload.getUsername());

		System.out.println("After Update User Data.");

		responsePostUpdate.then().log().all();

		//log
		logger.info("Update User executed.");

	}

}
