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
