Feature: Search and place the order for products
	
	@OffersPage
  Scenario Outline: Search experience for product search in both home and Offers page
    Given User is on GreenCart landing page
    When User searched with short name <Name> and extracted actual name of product
    Then User searched for the same <Name> in offers page
    And validate product name in offers page matches with Landing page

    Examples: 
      | Name |
      | Tom  |
      | Beet |
