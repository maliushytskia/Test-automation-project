Feature: Test base functionality on Home Page

  @Tag("regression")
  @positive
  @Attachment(value = "Login Page Loaded", type = "image/png")
  Scenario: Successful open Login Page
    Given Home Page is opened
    And user opens Shop by Category panel
