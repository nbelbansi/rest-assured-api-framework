package tests;

import org.testng.annotations.Test;
import utils.TestData;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
        import static org.hamcrest.Matchers.*;

public class CreateUserByDataTest {

    @Test(dataProvider = "userData", dataProviderClass = TestData.class)
    public void createUserTest(String name, String job) {

        HashMap<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("job", job);

        given()
                .body(body)
                .when()
                .post("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(201);
//                .body("name", equalTo(name))
//                .body("job", equalTo(job));
    }
}