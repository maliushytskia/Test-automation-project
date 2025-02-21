@api
  Feature: API tests to check base product functionality

    Scenario: Check products by category are present
      Given user gets products by product category "COMPONENTS" and expects 200 code
      Then user checks that Products are present in the list
