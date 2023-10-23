package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResults_StepDefinition {
    UsersPage usersPage = new UsersPage();
    LoginPage loginPage=new LoginPage();

    @When("user click on {string} link")
    public void user_click_on_link(String string) {

        for (WebElement eachLink : usersPage.menuLinks)
            if (eachLink.getText().equals(string)) {
                eachLink.click();

            }
    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedHeaders) {
            List<String> headersTexts = new ArrayList<>();
            for (WebElement header : usersPage.headers) headersTexts.add(header.getText());

        Assert.assertEquals(expectedHeaders, headersTexts);
    }

    @When("user logins using {string} and {string}")
    public void user_logins_using_and(String email, String password) {
        loginPage.login(email,password);

    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String string) {
        while(usersPage.userName.getText().isBlank()){

        }
Assert.assertEquals(string,usersPage.userName.getText());
    }
}
