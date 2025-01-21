Feature: Guest commenting on products
  As a guest user, I want to add comments to products,
  and as an admin, I should be able to disable guest commenting.

  Background:
    Given the product page is open

  Scenario: Guest successfully adds a comment to a product
    Given a guest user is on the product page
    When the guest submits a comment
    Then the comment should be submitted successfully

  Scenario: Admin disables guest commenting
    Given an admin is logged into the admin panel
    When the admin disables guest comments in the settings
    Then the guest comment functionality should be disabled
