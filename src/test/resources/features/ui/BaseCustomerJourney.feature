@ui @positive
Feature: Test base functionality on Home Page

  @smoke
  @allure.label.jira:AE-1
  @allure.id:1
  @allure.label.feature:SimpleCustomerFlow
  @allure.label.story:ByProductFromComponents
  Scenario: Buying a new product
    Given Home Page is opened
    And user opens Shop by Category panel
    And user opens "Components" category
    And Components page is opened
    And user opens "HTC Touch HD" product from Components page
    And Product Details page is opened
    And Product can't be added to the basket by "Add to Cart" button as "OUT OF STOCK"
    And Product can't be added to the basket by "Buy now" button as "OUT OF STOCK"
    And user navigates to "Components" shopping category list page
    And Products List Page is opened
    And user navigates to 2 page
    And "HP LP3065" product is present on the Products List Page
    And user opens "HP LP3065" product from Components page
    And Product Details page is opened
    And user clicks Buy Now button on Product Details page
    And Checkout page is opened
    And user accepts Privacy Policy
    And user accepts Terms and Conditions
    And user specifies user account data for the following fields:
      | First Name | Last Name | E-Mail          | Telephone  | Password | Password Confirm | Address 1 | City   | Post Code |
      | Joe        | Doe       | {generateEmail} | 4412345678 | 1234     | 1234             | Test      | London | SW1W 0NY  |
    And user clicks Continue button on Checkout page
