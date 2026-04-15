package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InvalidTest {
    @Test
    public void createUserWithoutBody() {

        given()
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(201); // ⚠️ This API still returns 201
    }
    @Test
    public void invalidEndpointTest() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/invalid")
                .then()
                .log().all()
                .statusCode(404);
    }
    @Test
    public void invalidUserIdTest() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/99999")
                .then()
                .log().all()
                .statusCode(404);
    }
    @Test
    public void wrongMethodTest() {

        given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .log().all()
                .statusCode(200); // fake API again
    }
    @Test
    public void invalidTokenTest() {

        given()
                .header("Authorization", "InvalidToken")
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .log().all()
                .statusCode(200); // fake API ignores auth
    }
    @Test
    public void invalidQueryParamTest() {

        given()
                .queryParam("page", "abc")
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(200); // API ignores bad param
    }
}
