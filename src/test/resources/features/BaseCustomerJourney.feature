@positive
Feature: Test base functionality on Home Page

  @smoke
  @allure.label.jira:AE-2
  @allure.id:123
  @allure.label.epic:WebInterface
  @allure.label.feature:EssentialFeatures
  @allure.label.story:Labels
  Scenario: Successful open Login Page
    Given Home Page is opened
    And user opens Shop by Category panel
    And user opens "Components" category
    And user opens "HTC Touch HD" product from Components page