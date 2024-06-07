Feature: Verify Dummy JSON Products API

  Scenario: Get all products
    When I request all "products" from Dummy JSON
    Then I validate that the response is a collection of "products"


  Scenario: Save new product
    Given I create a "new" product
    When I send a request to "save" a product
    Then I receive the "saved" product in the response body


  Scenario: Update a product
    Given I create a "updated" product
    When I send a request to "update" a product
    Then I receive the "updated" product in the response body


  Scenario: Delete a product
    Given I select product with id 1 to delete
    When I send a request to "delete" a product
    Then I receive the "deleted" product in the response body