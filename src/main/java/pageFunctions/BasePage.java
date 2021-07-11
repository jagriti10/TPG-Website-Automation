package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    @FindBy(xpath="//span[contains(text(),'Careers')]")
    WebElement labelCareer;

    @FindBy(xpath = "//a[contains(text(),'Career Opportunities')]")
    WebElement drpDwnChoiceCareer;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTitle(){
        driver.getTitle();
    }

    public void clickCareers(){
        labelCareer.isDisplayed();
        labelCareer.click();
    }
    public CareerOpportunities clickCareerOppur(){
        drpDwnChoiceCareer.isEnabled();
        drpDwnChoiceCareer.click();
        return new CareerOpportunities(driver) ;
    }
}
