Feature: Create a New Book

  Scenario: Create a New Book
    When I create a new book with id {1} title {book01} and author {author01}
    Then I should get a status code of 200
