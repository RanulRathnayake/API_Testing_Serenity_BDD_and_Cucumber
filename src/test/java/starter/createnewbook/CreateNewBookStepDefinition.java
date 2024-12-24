package starter.createnewbook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class CreateNewBookStepDefinition {
    private CreateNewBookAPI createNewBookAPI = new CreateNewBookAPI();
    private Response response;

    @When("I create a new book with id (\\d+) title (.+) and author (.+)")
    public void iCreateANewProduct(int id, String title, String author) {
        CreateNewBookResponse newbook = new CreateNewBookResponse();
        newbook.setId(id);
        newbook.setTitle(title);
        newbook.setAuthor(author);
        response = createNewBookAPI.CreateNewBook(newbook);
    }

    @Then("I should get a status code of {int}")
    public void iShouldGetAStatusCodeOf(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

}
