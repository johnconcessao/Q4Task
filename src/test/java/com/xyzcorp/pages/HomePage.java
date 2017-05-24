package com.xyzcorp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by jconcessao on 5/24/2017.
 */
public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private final By propertyLoc = By.cssSelector("button.ms-choice");
    private final By propertyTypeLoc = By.cssSelector("div.pure-control-group.pure-u-1-1.pure-u-sm-1-2.pure-u-md-1-4.pure-push button");
    private final By propertyTypeDropDown = By.cssSelector("div.ms-drop");
    private final By maxBedsLoc = By.cssSelector("#bedroom_group > div:nth-child(2) > div > button > span");
    private final By minBedsLoc = By.cssSelector("#bedroom_group > div:nth-child(1) > div > button > span");

    private final By search = By.cssSelector("button[type=\"submit\"]");
    private final By location = By.cssSelector("input[name='q']");
    private final By sortBy = By.cssSelector("div.sort button");
    private final By searchResults = By.cssSelector("ul.serp-result");
    private final By fixedTable = By.cssSelector("table.fixed-table");
    private final By BedCount=By.xpath("//*[@id='property-facts']/table/tbody/tr[4]/td");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectProperty(String property) {
        clickElement(propertyLoc);
        selectElement(property);
    }


    public void selectPropertyType(String propertyType) {
        clickElement(propertyTypeLoc);
        selectElement(propertyType);
    }


    public void selectPlace(String place) {


        clickElement(location);
        driver.findElement(location).sendKeys(place);
        driver.findElement(location).sendKeys(Keys.RETURN);

    }

    public void clickSearch() {
        clickElement(search);

    }

    public void selectMinBeds(String minBeds) {
        clickElement(minBedsLoc);
        selectElement(minBeds);


    }

    public void selectMaxBeds(String maxBeds) {
        clickElement(maxBedsLoc);
        selectElement(maxBeds);
    }

    public void clickElement(By selector) {
        try {
            WebElement element = driver.findElement(selector);
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            element.click();
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("element not available ", selector));
        }


    }

    public String getSearchResults() {

        String searchResultsCount = driver.findElement(cssSelector("div.list-count")).getText();
        return searchResultsCount;
    }


    public void selectOrderBy(String option) {

        clickElement(sortBy);
        selectElement(option);



    }

   public void selectLastProperty(){

       int max=driver.findElements(By.xpath("//*[@id=\"serp\"]/ul/li")).size();
       int row=max-1;

       String xpath = "//*[@id=\"serp\"]/ul/li[" + row + "]/div[3]/h2/a";
       driver.findElement(By.xpath(xpath)).click();

    }

    public void selectElement(String option) {

        List<WebElement> options = driver.findElements(By.cssSelector("div.ms-drop ul li"));
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("Can't find " + option + " in dropdown");
    }

    public String getBedCount() {


        if (driver.getTitle().contains("propertyfinder.qa")) {
            return driver.findElement(BedCount).getText();
        }
         else if  (driver.getTitle().contains("propertyfinder.ae")) {
                return driver.findElement(By.xpath("//*[@id='property-facts']/table/tbody/tr[5]/td")).getText();
        }
        return null;
    }
}
