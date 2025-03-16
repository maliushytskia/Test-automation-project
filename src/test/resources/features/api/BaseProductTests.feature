@api
Feature: Get products
  In order to use API
  As a client of shop
  I need to be able to get products and interact with them

  Scenario Outline: Check products by category are present
    Given user gets products by product category "<category>" and expects 200 code
    When user checks that Products are present in the list
    Then user checks that "HTC Touch HD" product is present in the list

    Examples:
      | category    |
      | COMPONENTS  |
      | CAMERAS     |
      | TABLETS     |
      | SOFTWARE    |
      | WEB_CAMERAS |

  Scenario: Check test product via API call
    Given user gets product by product ID 103 and expects 200 code
    When user gets product object from HTML
    Then user checks product details for the following fields:
      | name         | price | code      | brand | availability |
      | HTC Touch HD | 89.43 | Product 1 | HTC   | In Stock     |