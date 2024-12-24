package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class PostCodeStepDefinitions {
    private PostCodeAPI postCodeAPI = new PostCodeAPI();
    private Response response;

    @When("I retrieve all products")
    public void iRetrieveAllProducts() {
        response = postCodeAPI.getProducts();
    }

    @When("I create a new product with title {string} and price {double}")
    public void iCreateANewProduct(String title, double price) {
        ProductResponse product = new ProductResponse();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription("Default description");
        product.setImage("https://example.com/image.png");
        product.setCategory("Default category");
        response = postCodeAPI.createProduct(product);
    }

    @When("I update the product with id {int} to have title {string} and price {double}")
    public void iUpdateTheProduct(int productId, String title, double price) {
        ProductResponse updatedProduct = new ProductResponse();
        updatedProduct.setTitle(title); // Setting the updated title
        updatedProduct.setPrice(price); // Setting the updated price
        updatedProduct.setDescription("Updated description"); // Adding updated description
        updatedProduct.setImage("https://example.com/updated_image.png"); // Adding updated image URL
        updatedProduct.setCategory("Updated category"); // Adding updated category
        response = postCodeAPI.updateProduct(productId, updatedProduct);
    }

    @When("I delete the product with id {int}")
    public void iDeleteTheProduct(int productId) {
        response = postCodeAPI.deleteProduct(productId);
    }

    /* @Then("I should get a status code of {int}")
    public void iShouldGetAStatusCodeOf(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    } */
}
