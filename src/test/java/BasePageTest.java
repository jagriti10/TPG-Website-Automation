
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFunctions.BasePage;
import pageFunctions.CareerOpportunities;
import pageFunctions.QaProfile;
import testBase.TestBase;

public class BasePageTest extends TestBase {
    String currentWindow;
    CareerOpportunities careerP;
    QaProfile profileP;

    @Test(priority = 1)
    public void verifyCareerLabelDisplayed(){
        BasePage baseP= new BasePage(getDriver());
        baseP.clickCareers();
        careerP = baseP.clickCareerOppur();
    }

    @Test(priority = 5)
    public void verifyStickyHeader(){
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(careerP.isCareerHeadingDisplayed());
        careerP.scrollDown(2000);
        softAssertion.assertTrue(careerP.isHeaderLogoDisplayed());
        softAssertion.assertTrue(careerP.isBtnContactUsDisplayed());
    }

    @Test(priority = 2)
    public void verifyLocation(){
        careerP.printLocations();
        Assert.assertEquals(careerP.getLengthCountry(),15);
        careerP.scrollDown(1);
        careerP.clickNoida();
        careerP.printLocationsAfterNoidaClick();
    }

    @Test(priority = 3)
    public void switchWindow(){
        currentWindow = careerP.getParentWindow();
        Assert.assertEquals(careerP.getQALabel(),"quality assurance engineer ii");
        profileP=careerP.clickSeeMore();
        careerP.switchToWindow(currentWindow);
        Assert.assertEquals(driver.getTitle().toLowerCase(),"3pillar global - quality assurance engineer ii");
    }

    @Test(priority = 4)
    public void clickApplyNow(){
        profileP.clickApply();
        driver.close();
        driver.switchTo().window(currentWindow);
    }
}
