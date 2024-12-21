Feature: FakeStore API Testing

  Scenario: Retrieve all products
    When I retrieve all products
    Then I should get a status code of 200

  Scenario: Create a new product
    When I create a new product with title "New Product" and price 29.99
    Then I should get a status code of 200

  Scenario: Update a product
    When I update the product with id 1 to have title "Updated Product" and price 49.99
    Then I should get a status code of 200

  Scenario: Delete a product
    When I delete the product with id 1
    Then I should get a status code of 200
