Feature:As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms
  Additionally open the last item in the result set and verify it has two bedrooms

  Steps:
  1. Launch PropertyFinder application
  2. User selects the property type,location,Min Bed,Max Bed from the dropdown
  3. User clicks on Search button.
  4. User filter the search results using "Price low" option.
  5. User open the last item in the result set.




  Expected Results:
  1.1 Verify user is presented with PropertyFinder Page
  3.1 Verify that search results contains 2 bedroom properties for rent
  4.1 Verify search results are sorted by price low to high.
  5.1 Verify user can open the last item in the list.
  5.2 verify last item has 2 bed rooms.


  Scenario: This Scenario is for Qatar property finder site
  As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms
  Additionally open the last item in the result set and verify it has two bedrooms


    When I Launch PropertyFinder application with URL "https://www.propertyfinder.qa/"
    And I selects the "RENT" property Type "Apartment" place "Marina District" Minimum "2 Beds" Maximum "2 Beds" from the dropdown list
    And I clicks on Search button
    Then Verify the search results "3 results"
    When I sorts the search results using sort "Price (low)" option
    And I click on the last item in the list
    Then verify this item has "2" Bedrooms




  Scenario:This Scenario is for Dubai property finder site
  As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms
  Additionally open the last item in the result set and verify it has two bedrooms


    When I Launch PropertyFinder application with URL "https://www.propertyfinder.ae/"
    And I selects the "RENT" property Type "Apartment" place "Umm Al" Minimum "2 Beds" Maximum "2 Beds" from the dropdown list
    And I clicks on Search button
    Then Verify the search results "3 results"
    When I sorts the search results using sort "Price (low)" option
    And I click on the last item in the list
    Then verify this item has "2" Bedrooms



