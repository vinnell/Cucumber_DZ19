package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTestDefinitions {
    private ChromeDriver chromeDriver;

    @Given("I open the Login page")
    public void openLoginPage() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.saucedemo.com");
    }

    @When("I enter {string} my email on the login page")
    public void enterEmail(String email) {
        chromeDriver.findElement(By.id("user-name")).sendKeys(email);
    }

    @When("I enter {string} my password on the login page")
    public void enterPassword(String pass) {
        chromeDriver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("I click on submit button on the login page")
    public void clickOnSubmitButton() {
        chromeDriver.findElement(By.id("login-button")).click();
    }

    @Then("The main page is displayed")
    public void verifyMainPage() {
        WebElement mainPage = new WebDriverWait(
                chromeDriver,
                Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='page_wrapper']"))
        );
        Assertions.assertTrue(mainPage.isDisplayed());
    }

    @Given("I login into the system")
    public void login() {
        enterEmail("standard_user");
        enterPassword("secret_sauce");
        clickOnSubmitButton();
        verifyMainPage();
    }
}
