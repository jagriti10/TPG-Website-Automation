
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFunctions.BasePage;
import pageFunctions.CareerOpportunities;
import pageFunctions.QaProfile;
import testBase.TestBase;

import java.lang.annotation.Target;

public class BasePageTest extends TestBase {
    @Test(priority = 1)
    public void verifyCareerLabelDisplayed(){
        BasePage baseP= new BasePage(getDriver());
        baseP.clickCareers();
        baseP.clickCareerOppur();
    }

    @Test(priority = 2)
    public void verifyLocation(){
        CareerOpportunities careerP = new CareerOpportunities((getDriver()));
        careerP.printLocations();
        Assert.assertEquals(careerP.getLengthCountry(),15);
        careerP.clickNoida();
        careerP.printLocationsAfterNoidaClick();
        String currentWindow = careerP.getParentWindow();
        Assert.assertEquals(careerP.getQALabel(),"quality assurance engineer II");
        careerP.clickSeeMore();
        careerP.switchToWindow(currentWindow);
        Assert.assertEquals(driver.getTitle().toLowerCase(),"3pillar global - quality assurance engineer II");
    }

    @Test(priority = 3)
    public void clickApplyNow(){
        QaProfile profileP = new QaProfile((getDriver()));
        profileP.clickApply();
    }
}
