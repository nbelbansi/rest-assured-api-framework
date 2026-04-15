package tests;//package tests;
//
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class AuthTest {
//
//    @Test
//    public void getUserWithAuthTest() {
//
//        String token = "dummy-token-123";
//
//        given()
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .get("https://jsonplaceholder.typicode.com/users/1")
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(1));
//    }
//}

//package tests;
//
//import base.BaseTest;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class AuthTest extends BaseTest {
//
//    @Test
//    public void getUserWithAuthTest() {
//
//        given()
//                .header("Authorization", "Bearer " + TokenManager.getToken())
//                .when()
//                .get("/users/1")   // base URI already set
//                .then()
//                .statusCode(200)
//                .body("id", equalTo(1));
//    }
//}

//package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.SpecBuilder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AuthTest extends BaseTest {

    @Test
    public void getUserWithAuthTest() {

        given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .get("/users/1")
                .then()
                .spec(SpecBuilder.getResponseSpec())
                .body("id", equalTo(1));
    }
}