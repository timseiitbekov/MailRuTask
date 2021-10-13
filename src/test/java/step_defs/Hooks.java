package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Driver;

import java.io.IOException;

public class Hooks {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @AfterStep()
    public void takeScreen(Scenario scenario) throws IOException {
        Driver.takeScreenshotOnFail(scenario);
    }
}
