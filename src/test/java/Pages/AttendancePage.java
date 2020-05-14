package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


public class AttendancePage extends PageObject
//PageObject class provi des a number of convenient methods that make accessing and manipulating web elements much easier.

{

    @FindBy(xpath = "//span[text()='Attendance']")
    WebElementFacade AttendanceTab;

    @FindBy(xpath = "//a[@href='/ui/#/me/leave']")
    WebElementFacade me;

    @FindBy(xpath = "//h4[text()='Attendance Stats' ]")
    WebElementFacade Atnstatus;


    public void clickOnme() {
        System.out.println("\nuser is already on me tab");
    }

    public void attendance() {
        //user is clicking on Attendance tab
        withAction().moveToElement(me).moveToElement(AttendanceTab).click().build().perform();
        System.out.println("\nuser is on attendance page");

    }

    public void verifyAtnpage() {
        //user is Verifying  that user is on my Attendance tab
        Assert.assertEquals("Attendance Stats", Atnstatus.getText());
        System.out.println("Verified user is on attendance tab");
    }


    public void monthWise() {

        for (int i = 1; i <= 7; i++)
        //this loop will click on 7 months one by one from may to november
        {
            getDriver().findElement(By.xpath("(//div[@role= 'group']/button)[" + i + "]")).click();

            waitABit(2000);
            //without this wait script will run without visibility of actual content and incorrect data will be printed

            if (i == 1) {

                this.months("Last 30 days logs");
            }

            if (i == 2) {

                this.months("April logs");
            }


            if (i == 3) {

                this.months("march logs");

            }

            if (i == 4) {
                this.months("Feb logs");

            }


            if (i == 5) {

                this.months("Jan logs");
            }

            if (i == 6) {

                this.months("Dec logs");

            }

            if (i == 7) {

                this.months("Nov logs");

            }
        }
    }

    public void months(String monthname)
    //This method will take out attendance log month wise
    {
        System.out.println("\n------------------------------------------------------------------------------------------------\n");
        System.out.println(monthname);
        int rowCount = getDriver().findElements(By.xpath("//span[@class='ml-40']")).size();
        //no.of rows of attendance logs month wise will be counted first
        for (int c = 1; c <= rowCount; c++) {
            String Logs = getDriver().findElement(By.xpath("(//div[contains(@class,'d-flex align-items-center p')])[" + c + "]")).getText();
            //taking out the entries of each day
            System.out.println("\nlogs of DAYS : " + c + " " + "is" + " " + Logs);

        }
    }

}






