package utils;

import static io.restassured.RestAssured.*;

public class TokenManager {

    private static String token;

    public static String getToken() {

        if (token == null) {

            token = given()
                    .header("Content-Type", "application/json")
                    .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
                    .log().all()
                    .when()
                    .post("https://reqres.in/api/login")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                    .path("token");

            System.out.println("Generated Token: " + token);
        }

        return token;
    }
}