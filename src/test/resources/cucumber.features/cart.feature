Feature: Smoke
  As a user
  I want to add products to the cart
  So that I can change their quantity and see the total price

  Scenario Outline: Verify the price of the hardware's items in the cart
    Given User opens '<homePage>' page
    And User clicks on the Categories Hardware's menu of the left sidebar
    When User clicks on the first item of the new products
    And User clicks on the Add to Cart button
    And User types the value of the item's count equals '<itemQuantity>'
    And User checks '<itemQuantity>' and clicks on the Update button
    Then User checks that the item's price in the cart is equal to the '<totalPrice>'

    Examples:
      | homePage                                | itemQuantity | totalPrice|
      | http://practice.bpbonline.com/index.php | 2            | 139.98    |
      | http://practice.bpbonline.com/index.php | 3            | 209.97    |
      | http://practice.bpbonline.com/index.php | 4            | 279.96    |