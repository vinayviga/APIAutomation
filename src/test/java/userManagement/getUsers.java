package userManagement;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class getUsers {
    @Test
    public void getUserData()
    {
         given()
        .when().get("https://restful-booker.herokuapp.com/booking")
        .then().assertThat().statusCode(200);
    }

    @Test
    public void validateGetResponseBody() {
        // Set base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and validate the response body using 'then'
        given()
                .when()
                .get("/todos/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body(not(isEmptyString()))
                .body("title", equalTo("delectus aut autem"))
                .body("userId", equalTo(1));
    }
}


