package Steps;

import Pages.AttendancePage;
import Pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AttendanceSteps {
    //created reference variable of LoginPage to access methods
    LoginPage page;

    //created reference variable of AttendancePage to access methods
    AttendancePage Atnpage;

    @Given("^user is on home page of the application$")
    public void userIsOnHomePageOfTheApplication() {
        //Calling verifyCompanyname method using reference of loginPage
        page.verifyCompnyname();
        //Calling verifyUsername method using reference of loginPage
        page.verifyUsername();
    }

    @When("^user click on me link ,menu with multiple option appear$")
    public void userClickOnMeLinkMenuWithMultipleOptionAppear() {
        //Calling clickOnme method using reference of AttendancePage
        Atnpage.clickOnme();
    }

    @Then("^user click on Attendance and verify user is on attendance tab$")
    public void userClickOnAttendanceAndVerifyUserIsOnAttendanceTab() {
        //Calling attendance method using reference of AttendancePage
        Atnpage.attendance();
        //Calling verifyAtnpage method using reference of AttendancePage
        Atnpage.verifyAtnpage();
    }


    @When("^user is clicking on month one by one ana storing the attendance logs one by one$")
    public void userIsClickingOnMonthOneByOneAnaStoringTheAttendanceLogsOneByOne() {
        //Calling monthwise method using reference of AttendancePage to take out attendance month wise

        Atnpage.monthWise();
    }
}
