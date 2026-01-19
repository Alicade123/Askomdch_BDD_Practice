package askomdch.stepdefinitions.productfilterbycategory;

import askomdch.dependencyinjection.UtilClass;
import askomdch.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductFilterByCategory {
    private WebDriver driver = DriverFactory.getDriver();

    private By dropdownField = By.id("product_cat");

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        driver.get(UtilClass.SITEURL+"store");
    }

    @When("I select category {string}")
    public void i_select_category(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownField));
        dropdown.click();
        String xpathExpression = "//option[contains(text(), '" + category + "')]";
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    @Then("I should see {string} in the url")
    public void i_should_see_in_the_url(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean success = wait.until(ExpectedConditions.urlContains(expected.toLowerCase()));
        Assert.assertTrue(success);
        driver.quit();
    }
}
