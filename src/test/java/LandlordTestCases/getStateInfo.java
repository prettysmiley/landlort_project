package LandlordTestCases;
import static com.jayway.restassured.RestAssured.*; 
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class getStateInfo {
	
@Test
public void getStates(){
	
	given()
	.pathParam("countryCode", "IND")
	.when()
	.get("http://services.groupkt.com/state/get/{countryCode}/all")
	.then()
	.statusCode(201)
	.extract().body().asString();
	//.extract().response().body().prettyPrint();
}

}
