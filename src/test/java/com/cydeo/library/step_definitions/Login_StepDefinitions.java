package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtility;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("loginPage"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperties("userLibrarian"));

    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperties("password"));

    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        BrowserUtility.waitUntilTitleIs("Library");
        Assert.assertEquals("Library", Driver.getDriver().getTitle());

    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperties("userStudent"));

    }

    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperties("password"));

    }

    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        loginPage.signInBtn.click();
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String string) {
        loginPage.inputEmail.sendKeys(string);
    }


    @When("user enters user password as {string}")
    public void user_enters_user_password_as(String string) {
        loginPage.inputPassword.sendKeys(string);

    }

    @When("{string} enters credentials and clicks sign in button")
    public void enters_credentials_and_clicks_sign_in_button(String string) {

        if (string.equals("librarian"))
            loginPage.login(ConfigurationReader.getProperties("userLibrarian"), ConfigurationReader.getProperties("password"));
        else
            loginPage.login(ConfigurationReader.getProperties("userStudent"), ConfigurationReader.getProperties("password"));
    }

}
