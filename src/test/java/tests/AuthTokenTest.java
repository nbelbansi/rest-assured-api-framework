package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthTokenTest extends BaseTest {

    @Test
    public void getUserWithRealToken() {

        given()
                .header("Authorization", "Bearer " + TokenManager.getToken())
                .log().all()
                .when()
                .get("https://dummyjson.com/auth/me")
                .then()
                .log().all()
                .statusCode(200)
                .body("username", equalTo("kminchelle"));
    }
}