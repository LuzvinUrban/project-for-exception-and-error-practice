package com.cydeo.step_defs;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @When("user  log in with valid credentials")
    public void user_log_in_with_valid_credentials() {
        new LoginPage().login();
    }

    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.warningMessage.getText());
    }
}
