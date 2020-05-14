package Steps;

import Pages.AttendancePage;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends LoginPage {
    //created reference variable of LoginPage to access methods
    LoginPage loginPage;
    //created reference variable of AttendancePage to access methods
    AttendancePage Atnpage;


    @Given("^User enter the keka url to login$")
    public void userEnterTheKekaUrlToLogin() {
        //Calling login method using reference of loginPage
        loginPage.login();
    }

    @And("^User verify that user is on login page$")
    public void userVerifyThatUserIsOnLoginPage() {
        //Calling verifyWelcomescreen method using reference of loginPage

        loginPage.verifyWelcomescreen();
    }

    @And("^User click on login with google$")
    public void userClickOnLoginWithGoogle() {
        //Calling loginWithgoogle method using reference of loginPage
        loginPage.loginWithgoogle();
    }

    @When("^user enter credentials$")
    public void userEnterCredentials() {
        //Calling email method using reference of loginPage
        loginPage.email();
        //Calling next method using reference of loginPage
        loginPage.next();
        //Calling password method using reference of loginPage
        loginPage.password();
        //Calling submit method using reference of loginPage
        loginPage.submit();
    }

    @Given("^user verify the first component$")
    public void userVerifyTheFirstComponent() {
        //Calling verifyCompnyname method using reference of loginPage
        loginPage.verifyCompnyname();
    }

    @And("^user verify the second component$")
    public void userVerifyTheSecondComponent() {
        //Calling verifyUsername method using reference of loginPage
        loginPage.verifyUsername();
    }

    @And("^user verify the first six tab$")
    public void userVerifyTheFirstSixTab() {
        //Calling verifyLinks method using reference of loginPage
        loginPage.verifyLinks();
    }

    @Then("^user verify the last seventh tab$")
    public void userVerifyTheLastSeventhTab() {
        //Calling orgTab method using reference of loginPage
        loginPage.orgTab();
        //Calling verifyOrgtab method using reference of loginPage
        loginPage.verifyOrgtab();
    }
}

