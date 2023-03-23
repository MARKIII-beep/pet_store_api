package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoint;
import api.endPoints.UserEndPoint_propertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoint_propertiesFile_Test {
	Faker faker;
	User userPayload;

	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode()); // hashcode for randomly generate id
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

	}

	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndPoint_propertiesFile.createUser(userPayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void testGetUserByName() {

		Response response = UserEndPoint_propertiesFile.readUser(this.userPayload.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3)
	public void testUpdateUserByName() {

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndPoint_propertiesFile.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		// checking data after update
		Response responseAfterUpdate = UserEndPoint_propertiesFile.readUser(this.userPayload.getUsername());

		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

	}

	@Test(priority = 4)
	public void testDeleteUserByName() {

		Response response = UserEndPoint_propertiesFile.deleteUser(this.userPayload.getUsername());

		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
