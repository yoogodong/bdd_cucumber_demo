package glue.web;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class GoogleSearchTipsStep {

    private final WebDriver driver = new FirefoxDriver();


    @Given("^打开 Google 搜索页面$")
    public void 打开Google搜索页面() throws Throwable {
        driver.get("https://www.google.com");
    }

    @When("^搜索 \"([^\"]*)\"$")
    public void 搜索(String query) throws Throwable {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(query);
        element.submit();
    }

    @Then("^页面的标题应该是 \"([^\"]*)\"$")
    public void 页面的标题应该是(String title) throws Throwable {
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title);
            }
        });
        assertThat(driver.getTitle().toLowerCase(), startsWith(title));
    }



    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
