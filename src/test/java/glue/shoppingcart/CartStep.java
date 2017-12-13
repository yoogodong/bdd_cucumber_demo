package glue.shoppingcart;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import features.shoppingcart.Cart;
import features.shoppingcart.Product;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartStep {


    private Product product;
    private Cart cart;

    @Given("^a product with name \"([^\"]*)\" and price (\\d+)$")
    public void aProductWithNameAndPrice(String arg0, int arg1) throws Throwable {
        product = new Product(arg0, arg1);
    }

    @And("^a shopping cart is empty$")
    public void aShoppingCartIsEmpty() throws Throwable {
        cart = new Cart();
    }

    @When("^I add that product in to the cart$")
    public void iAddThatProductInToTheCart() throws Throwable {
        cart.add(product);
    }

    @Then("^I can find the product from the cart$")
    public void iCanFindTheProductFromTheCart() throws Throwable {
        assertTrue(cart.contains(product));
    }

    @And("^it has only (\\d+)$")
    public void itHasOnly(int arg0) throws Throwable {
        final int quality = cart.getItem(product).quality();
        assertEquals(arg0, quality);
    }


    @And("^the cart's total price is (\\d+)$")
    public void theCartSTotalPriceIs(int arg0) throws Throwable {
        final int totalPrice = cart.totalPrice();
        assertEquals(arg0, totalPrice);
    }

    @When("^I add that product with quantity (\\d+) in to the cart$")
    public void iAddThatProductWithQuantityInToTheCart(int arg0) throws Throwable {
        cart.add(product, arg0);
    }




    @Given("^a shopping cart with (\\d+) \"([^\"]*)\" and the unitprice  is (\\d+)$")
    public void aShoppingCartWithAndTheUnitpriceIs(int arg0, String arg1, int arg2) throws Throwable {
        cart = new Cart();
        cart.add(new Product(arg1,arg2),arg0);
    }

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features={"src/test/resources"}
    )
    public static class CukesRunner {

    }
}
