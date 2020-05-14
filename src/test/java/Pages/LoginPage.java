package Pages;

import com.typesafe.config.Config;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigLoader;

public class LoginPage extends PageObject
//PageObject class provides a number of convenient methods that make accessing and manipulating web elements much easier.
{
    Config config = ConfigLoader.load();

    //Below all are the elements on which user has performed operations

    @FindBy(xpath = "//button[@title='Login with Google']")
    WebElementFacade google;

    @FindBy(className = "login-heading")
    WebElementFacade loginPage;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade email;

    @FindBy(xpath = "//input[@name='password']")
    WebElementFacade password;

    @FindBy(xpath = "//span[text()='Next']")
    WebElementFacade next;

    @FindBy(xpath = "//span[text()='Next']")
    WebElementFacade signIn;

    @FindBy(xpath = "/html/body/xhr-app-root/xhr-page-header/nav/div/div[1]/div/a")
    WebElementFacade companyName;

    @FindBy(xpath = "//*[@id='userProfile']/span[1]")
    WebElementFacade userName;


    @FindBy(xpath = "//a[@href='#/inbox/action']")
    WebElementFacade inboxText;

    @FindBy(xpath = "//span[text()='My Team']")
    WebElementFacade Team;


    @FindBy(xpath = "//button[text()='OK']")
    WebElementFacade popup;


    @FindBy(xpath = "//div[text()='There are no Tasks']")
    WebElementFacade noTasks;

    @FindBy(xpath = "//center[text()='Org']")
    WebElementFacade Org;

    @FindBy(xpath = "//span[text()='Documents']")
    WebElementFacade documents;

    @FindBy(xpath = "//span[text()='Organization Documents']")
    WebElementFacade organisation;

    @FindBy(xpath = "//h1[text()='Organization Documents']")
    WebElementFacade orgDocuments;

    @FindBy(xpath = "//a[@href='/ui/#/me/leave']")
    WebElementFacade me;

    @FindBy(xpath = "//h4[text()='Attendance Stats' ]")
    WebElementFacade Atnstatus;


    @FindBy(xpath = "//span[text()='Attendance']")
    WebElementFacade AttendanceTab;

    public void verifyLinks() {
        //loop will locate first 6 tabs and as soon as user click on 6th tab ,path for last(7th) tab will be changed and loop will not locate it thats why loop value is 1 to 6

        for (int i = 1; i <= 6; i++) {
            getDriver().findElement(By.xpath("(//span[@class='sidebar-list-label'])[" + i + "]")).click();

            if (i == 1) {

                //Calling companyname method
                verifyCompnyname();
                //Calling username  method
                verifyUsername();
            }

            if (i == 2) {
                //Calling attendance method
                Attendance();
                //Calling verifyAttendance method
                verifyAttendance();
            }

            if (i == 3) {

                System.out.println("\nUser has reached to the third tab of left pane");
                //calling verifyInbox method
                verifyInbox();

            }

            if (i == 4) {

                System.out.println("\nUser reached to my team tab  of the left pane");
                //calling verifyMyteam method
                verifyMyteam();
            }

            if (i == 5) {
                System.out.println("\nUser has reached to fifth tab of left pane");

                //calling verifyfinance method
                verifyfinance();

            }

            if (i == 6) {

                System.out.println("\nUser has reached to sixth tab  of left pane");
                //calling verifyTodoTab method
                verifyTodoTab();

            }

        }
    }

    public void Attendance() {
        //user is on second tab and clicking on other links of the second tab
        withAction().moveToElement(me).moveToElement(AttendanceTab).click().build().perform();
        System.out.println("\nuser has been reached to second tab of left pane links");
    }

    public void verifyAttendance() {
        //user is verifying that user is on second tab
        Assert.assertEquals("Attendance Stats", Atnstatus.getText());
        System.out.println("Verified that user has been reached to second tab of left pane links");

    }

    public void login() {
        //Allow user to reach login page of application
        openUrl(config.getString("loginTestUrl"));
        getDriver().manage().window().maximize();


    }

    public void verifyWelcomescreen() {
        //Verifying that user has reached on login screen
        Assert.assertEquals("Login", loginPage.getText());
        System.out.println("\nUser is at login screen ");

    }


    public void loginWithgoogle() {
        //Since there are two option to login,user will choose login with google
        waitFor(google).click();

    }

    public void email() {
        //user is entering the email id
        waitFor(email).sendKeys("Shiwani.sharma@successive.tech");
        System.out.println("\nEmail entered successfully");
    }

    public void password() {
        //user is entering the password
        waitFor(password).sendKeys("Lovelyjhansi@123");
        System.out.println("\nPassword entered successfully");


    }

    public void next() {
        //user is clicking  next button to enter password after entering email
        waitFor(next).click();

    }

    public void submit() {
        //user is clicking on sign in button after entering i.d and password
        waitFor(signIn).click();
        System.out.println("\nSign in clicked");
        //Application takes time to load the page
        waitABit(15000);

    }

    public void verifyCompnyname() {

        //user is verifying the first components of home page
        Assert.assertEquals("Successive Technologies Pvt. Ltd.", companyName.getText());
        System.out.println("\nCompany name i.e first component of home page has been verified");
    }

    public void verifyUsername() {
        //user is verifying the second component of home page
        Assert.assertEquals("Shiwani Sharma", userName.getText());
        System.out.println("\nusername i.e second component of home page has been verified\n");
    }


    public void verifyInbox() {
        //user is Verifying  that user is on inbox tab i.e third  tab  of left pane
        Assert.assertEquals("TAKE ACTION", inboxText.getText());
        System.out.println("\nVerified that user is on inbox tab i.e third tab of left pane");

    }


    public void verifyMyteam() {
        //user is Verifying  that user is on my team tab i.e fourth tab of left pane
        Assert.assertEquals("My Team", Team.getText());
        System.out.println("\nuser has verified that user is on team tab i.e fourth tab of left pane");
    }

    public void verifyfinance() {
        //user is Verifying  that user is on finance i.e fifth tab of left pane
        waitFor(popup).click();
        System.out.println(" user has verified that user is on finance i.e fifth  tab of left pane");
    }


    public void verifyTodoTab() {
        //user is Verifying  that user is on  Todotab tab i.e sixth tab of left pane
        Assert.assertEquals("There are no Tasks", noTasks.getText());
        System.out.println("\nVerified user is on sixth tab i.e sixth tab of left pane");

    }

    public void orgTab() {
        //user is clicking on seventh tab of left pane
        withAction().moveToElement(Org).moveToElement(documents).moveToElement(organisation).click().build().perform();
        System.out.println("\nVerified that user has reached on last tab i.e seventh tab of left pane");
    }

    public void verifyOrgtab() {
        //user is Verifying  that user is on my org tab i.e seventh tab of left pane
        Assert.assertEquals("Organization Documents", orgDocuments.getText());
        System.out.println("\nUser verified that he is on last tab i.e seventh tab of the left pane");

    }
}

