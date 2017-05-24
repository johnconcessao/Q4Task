package com.xyzcorp.stepdefinitions;

import com.xyzcorp.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;


public class SearchPropertySteps extends RunCukesTest {

    HomePage homePage;

    public  SearchPropertySteps() {

        homePage=new HomePage(driver);
    }



    @When("^I Launch PropertyFinder application with URL \"([^\"]*)\"$")
    public void i_Launch_PropertyFinder_application_with_URL(String url) throws Throwable {
        driver.get(url);


    }

    @When("^I selects the \"([^\"]*)\" property Type \"([^\"]*)\" place \"([^\"]*)\" Minimum \"([^\"]*)\" Maximum \"([^\"]*)\" from the dropdown list$")
    public void user_selects_the_property_Type_place_Minimum_Maximum_from_the_dropdown_list(String property, String propertyType, String place, String minBeds, String maxbeds) throws Throwable {
        homePage.selectProperty(property);
        homePage.selectPropertyType(propertyType);
        homePage.selectPlace(place);
        homePage.selectMinBeds(minBeds);
        homePage.selectMaxBeds(maxbeds);

    }

    @When("^I clicks on Search button$")
    public void user_clicks_on_Search_button() throws Throwable {

        homePage.clickSearch();


    }

    @Then("^Verify the search results \"([^\"]*)\"$")
    public void verify_the_search_resuts(String SearchResultCount) throws Throwable {
        String ActualSerachResultCount = homePage.getSearchResults();
        assertEquals(ActualSerachResultCount, SearchResultCount);
    }

    @When("^I sorts the search results using sort \"([^\"]*)\" option$")
    public void user_sorts_the_search_results_using_sort_option(String sortSearchResultsBy) throws Throwable {
      homePage.selectOrderBy(sortSearchResultsBy);

    }

    @When("^I click on the last item in the list$")
    public void user_clicks_on_the_search_item_Apartment() throws Throwable {
        homePage.selectLastProperty();

    }



    @Then("^verify this item has \"([^\"]*)\" Bedrooms$")
    public void verify_this_item_has(String NumberofBedRooms) throws Throwable {
        String actualBedRooms = homePage.getBedCount();
        assertEquals(actualBedRooms, NumberofBedRooms);

    }







}
