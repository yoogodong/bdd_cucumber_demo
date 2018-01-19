Feature: add a product to shopping cart
  作为一个客户
  我想要添加产品到到我的购物车
  这样我可以在之后查看这些商品以及决定是否购买它们
  Scenario: add 1 pen
    Given a product with name "pen" and price 20
    And a shopping cart is empty
    When  I add that product in to the cart
    Then I can find the product from the cart
    And it has only 1
    And the cart's total price is 20

  Scenario: add 2 pen
    Given a product with name "pen" and price 20
    And a shopping cart is empty
    When  I add that product in to the cart
    And I add that product in to the cart
    Then I can find the product from the cart
    And it has only 2
    And the cart's total price is 40

  Scenario: add 9 pens
    Given a product with name "pen" and price 20
    And a shopping cart is empty
    When  I add that product with quantity 9 in to the cart
    Then I can find the product from the cart
    And it has only 9
    And the cart's total price is 180


  Scenario: add 3 notebooks after 9 pens
    Given a shopping cart with 9 "pen" and the unitprice  is 10
    And a product with name "notebook" and price 8
    When I add that product with quantity 3 in to the cart
    Then I can find the product from the cart
    And it has only 3
    And the cart's total price is 114






