package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTest extends BaseTest {

    @Test
    public void validateUserSchemaTest() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("userSchema.json"));
    }
}