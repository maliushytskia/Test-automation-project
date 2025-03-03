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
    And Confirm Order page is opened
    When user clicks Confirm Order button
    Then Success page is opened
    And user clicks on Continue button at Success page
    And Home Page is opened

  @smoke
  @allure.label.jira:AE-2
  @allure.id:2
  @allure.label.feature:SearchProducts
  @allure.label.story:SearchProductsViaSearchBar
  Scenario: Search product via search bar
    Given Home Page is opened
    And user fills in search input "Apple Cinema 30" to Search Bar
    And user clicks Search button
    And Products List Page is opened
    And "Apple Cinema 30\"" product is present on the Products List Page

  @smoke
  @allure.label.jira:AE-3
  @allure.id:3
  @allure.label.feature:LogIn
  @allure.label.story:UserLogIn
  Scenario: User Log In
    Given Home Page is opened
    And user opens Login page
    And Login Page is opened
    And user specifies email "joe.doe@test.net" and password "1234"
    And user clicks Login button
    And user see validation message for invalid credentials
    When user specifies email "joe.doe@test.com" and password "1234"
    And user clicks Login button
    Then Account page is opened


