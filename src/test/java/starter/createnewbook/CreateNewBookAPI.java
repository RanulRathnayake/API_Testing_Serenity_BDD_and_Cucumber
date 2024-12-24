package starter.createnewbook;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import starter.createnewbook.CreateNewBookResponse;

public class CreateNewBookAPI {

    private static final String BASE_URL = "http://localhost:7081/api/books";

    public Response CreateNewBook(CreateNewBookResponse newbook) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .body(newbook)
                .header("Content-Type", "application/json")
                .when()
                .post()
                .then()
                .log().all() // Log response details
                .extract()
                .response();
    }
}
