package askomdch.stepdefinitions.cart;

import askomdch.pages.CartPage;
import askomdch.pages.StorePage;
import askomdch.utils.DriverFactory;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddProductToCart {
    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);

    @Then("On Cart Page I should see {int} {string} in the cart")
    public void checkProductInCart(int productQuantity, String productName){
        Assert.assertEquals("Not much", productName,cartPage.getProductName());
        Assert.assertEquals("Not much", productQuantity, cartPage.getProductQuantity());
    }
}
