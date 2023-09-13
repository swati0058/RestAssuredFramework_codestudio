package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class UsertestDD {
	User userpayload;
	
@Test(priority = 1,dataProvider= "Alldata",dataProviderClass = Dataprovider.class)
	


	public void  testcreateUser(String userId,String username,String fname,String lname,String email,
			String password,String phoneno) {
	
	System.out.println("user creating ");
		
		 userpayload= new User();
		
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);

		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phoneno);
		
	Response response=	UserEndpoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
		
	}
	

@Test(priority = 2,dataProvider= "usernameData",dataProviderClass = Dataprovider.class)
	
	
	

public void  testgetUser(String username) {
	
	System.out.println("updating user");
	
	//userpayload.setUsername(username);

	
	Response response=	UserEndpoints.GetUser(username);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);






}





@Test(priority = 3,dataProvider= "usernameData",dataProviderClass = Dataprovider.class)

public void  testdeleteUser(String username) {
	
	System.out.println("Deleting user");
	
	//userpayload.setUsername(username);

	
	Response response=	UserEndpoints.DeleteUser(username);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(),200);





	


}



}
