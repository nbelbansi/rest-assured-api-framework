import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest {

    public static void main(String[] args) {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"));

    }
}