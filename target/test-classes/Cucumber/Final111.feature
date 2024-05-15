
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given Landed on ecommerce site


  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username "<name>" and password "<value>"
    When I add product "<productname>" to cart
    Then checkout "<productname>" and submit the order

    Examples: 
      | name 				  | value 		| productname  |
      | s19@gmail.com | 258369Qp@ | ZARA COAT 3  |
   
