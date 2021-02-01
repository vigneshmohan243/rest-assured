package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.testOne.GetJSON;
import files.testOne.ParseJSON;
import io.restassured.RestAssured;

public class TestOne {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// POST
		// Add a place
		String postResponse = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(GetJSON.AddPlace()).when()
				.post("maps/api/place/add/json").then().assertThat().log().all().statusCode(200)
				.body("status", equalTo("OK")).extract().response().asString();

		// get the place_id from response by parsing the JSON
		String placeId = ParseJSON.getValue(postResponse, "place_id");

		// PUT
		// update the place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(GetJSON.UpdatePlace(placeId)).when().put("maps/api/place/update/json").then().assertThat().log()
				.all().statusCode(200);

		// GET
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();

		// get the name, phone_number and address from response by parsing the JSON
		Assert.assertEquals(ParseJSON.getValue(getResponse, "name"), "Vignesh");
		Assert.assertEquals(ParseJSON.getValue(getResponse, "phone_number"), "1234567890");
		Assert.assertEquals(ParseJSON.getValue(getResponse, "address"), "Coimbatore, India");

		// DELETE
		// delete the place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(GetJSON.DeletePlace(placeId)).when().delete("maps/api/place/delete/json").then().assertThat()
				.log().all().statusCode(200).body("status", equalTo("OK"));
	}

}
