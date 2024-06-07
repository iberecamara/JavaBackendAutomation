Feature: Verify Dummy JSON Product Categories API

  Scenario Outline: Get all categories
    When I request all "<type>" from Dummy JSON
    Then I validate that the response is a collection of "<type>"

    Examples:
      | type            |
      | categories      |
      | categoriesList  |