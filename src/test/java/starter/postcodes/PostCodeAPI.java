package starter.postcodes;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostCodeAPI {
    private static final String BASE_URL = "https://fakestoreapi.com/products";


    public Response getProducts() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .when()
                .get()
                .then()
                .log().all() // Log response details
                .extract()
                .response();
    }


    public Response createProduct(ProductResponse product) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .body(product)
                .header("Content-Type", "application/json")
                .when()
                .post()
                .then()
                .log().all() // Log response details
                .extract()
                .response();
    }


    public Response updateProduct(int productId, ProductResponse updatedProduct) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .basePath("/" + productId)
                .body(updatedProduct)
                .header("Content-Type", "application/json")
                .when()
                .put()
                .then()
                .log().all() // Log response details
                .extract()
                .response();
    }


    public Response deleteProduct(int productId) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .basePath("/" + productId)
                .when()
                .delete()
                .then()
                .log().all() // Log response details
                .extract()
                .response();
    }
}
