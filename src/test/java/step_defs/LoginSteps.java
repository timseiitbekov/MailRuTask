package step_defs;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pojo.LoginDataContainer;
import utils.ConfigReader;
import utils.Driver;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    Hooks hooks = new Hooks();

    @DataTableType
    public LoginDataContainer loginEntry(Map<String, String> entry) {
        return new LoginDataContainer(
                entry.get("username"),
                entry.get("password")
        );
    }


    @Given("User navigates to the Mail.ru login page")
    public void user_navigates_to_the_mail_ru_login_page() throws InterruptedException {
        driver.get(ConfigReader.getProperty("ru.mail.login"));
    }

    @When("User inputs following credentials")
    public void user_inputs_following_credentials(List<LoginDataContainer> dataTable) throws InterruptedException {
        LoginDataContainer loginDataContainer = dataTable.get(0);
        loginOnce(loginDataContainer.getUsername(), loginDataContainer.getPassword());
    }

    @Then("Validate the user has logged in")
    public void validate_the_user_has_logged_in() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void loginOnce(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.usernameField));
        loginPage.usernameField.sendKeys(username);
        loginPage.enterPasswordButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordField));
        loginPage.passwordField.sendKeys(password);
        loginPage.submitButton.click();
    }
}
