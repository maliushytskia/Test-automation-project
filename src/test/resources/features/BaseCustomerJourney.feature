@positive
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
