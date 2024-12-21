package starter.postcodes;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostCodeAPI {
    private static final String BASE_URL = "https://fakestoreapi.com/products";

    /**
     * Fetch all products.
     *
     * @return Response containing all products.
     */
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

    /**
     * Create a new product.
     *
     * @param product ProductResponse object containing product details.
     * @return Response after creating a new product.
     */
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

    /**
     * Update an existing product.
     *
     * @param productId       ID of the product to be updated.
     * @param updatedProduct  ProductResponse object with updated product details.
     * @return Response after updating the product.
     */
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

    /**
     * Delete a product.
     *
     * @param productId ID of the product to be deleted.
     * @return Response after deleting the product.
     */
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
