package tests;

import base.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.SpecBuilder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AdvancedApiTest extends BaseTest {

    @Test
    public void createAndValidateUser() {

        // Step 1: Create user (POST)
        int userId = given()
                .spec(SpecBuilder.getRequestSpec())
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"Neelesh\", \"job\": \"QA Lead\" }")
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .path("id");

        Reporter.log("Created User ID: " + userId, true);
        // Step 2: Validate using GET
        given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));
    }
}