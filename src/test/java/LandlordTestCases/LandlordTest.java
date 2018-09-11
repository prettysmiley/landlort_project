package LandlordTestCases;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;

public class LandlordTest {

	@Test(enabled = false)
	public void getLandLordData() {
		given().when().get("http://localhost:8080/landlords").then()
				.statusCode(200).body("", is(empty())).extract().response()
				.body().prettyPrint();
	}

	@Test(enabled = true)
	public void addLandLordData() {
		
		Reporter.log("Adding Landlord data:");
		LandLord arlett = new LandLord("Arlett", "Beattle", false);
		String str = given()
				.contentType(ContentType.JSON)
		.body(arlett)
//		.body("{"+
//  "\"firstName\": \"Iniya\","+
//  "\"lastName\": \"P\","+
//  "\"trusted\": false"+
//"}")
		.when()
		.post("http://localhost:8080/landlords").then()
				.statusCode(201)
				.extract().response().body().prettyPrint();
		JsonPath response_body = new JsonPath(str);
		String landlord_id = response_body.getString("id");
		
		Reporter.log("Landlord "+ landlord_id +" is added");
		
		String added_ll = getLLbyID(landlord_id);
		Reporter.log("Landlord add verification complete for : "+ added_ll);
	}
	
	@Test(enabled = false)
	public void deleteLandLordData() {
		
		Reporter.log("Deleting Landlord data:");
		given()
				.contentType(ContentType.JSON)
				.pathParam("ID", "fKNDoang")
		.when()
		.delete("http://localhost:8080/landlords/{ID}").then()
				.statusCode(200)
				.extract().response().body().prettyPrint();
	System.out.println("Deleted Landlord ID: " + "fKNDoang");
	
	// Verify that Landlord with given ID is not available anymore
     given()
	.pathParam("ID", "fKNDoang")
	.when()
	.get("http://localhost:8080/landlords/{ID}").then()
	.statusCode(404);
	
	}
	@Test(enabled = false)
	public void UpdateLandLordData() {
		
		//
		Reporter.log("Updating Landlord data:");
		String fname = "fname" + (int)(Math.random() *50);
		String lname = "lname" + (int)(Math.random() *50);
		String id = "19o6wgSI";
		LandLord arlett = new LandLord(fname, lname, false);
		given()
				.contentType(ContentType.JSON)
				.pathParam("ID", id)
		.body(arlett)
		.when()
		.put("http://localhost:8080/landlords/{ID}").then()
				.statusCode(200)
				.extract().response().body().prettyPrint();
	
		String added_ll = getLLbyID(id);
		Reporter.log("Landlord update verification complete for : "+ added_ll);
	}
	
	public static String getLLbyID(String id){
		
		String response_body = given()
		.pathParam("ID", id)
		.when()
		.get("http://localhost:8080/landlords/{ID}").then()
		.statusCode(200)
		.extract().response().body().prettyPrint();
		return response_body;
	}
}
