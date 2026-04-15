package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + TokenManager.getToken())
                .build();
    }

    public static ResponseSpecification getResponseSpec() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}