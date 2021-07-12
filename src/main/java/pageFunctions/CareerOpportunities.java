package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class CareerOpportunities{
    private WebDriver driver;

    @FindBy(css ="ul[class='careers__cities'] li a")
    List<WebElement> labelCountries;

    @FindBy(css = "li[data-city='Noida'] h3+div")
    List<WebElement> sublabelNoida;

    @FindBy(xpath="//h3[contains(text(),'Quality Assurance Engineer II')]")
    WebElement lblQA;

    @FindBy(xpath = "//h3[contains(text(),'Quality Assurance Engineer II')]/following-sibling::a")
    WebElement btnSeeMore;

    public CareerOpportunities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTitle(){
        driver.getTitle();
    }

    public void printLocations(){
        for (WebElement ele:labelCountries
             ) {
           System.out.println("The location is:"+ ele.getText());
        }
    }

    public int getLengthCountry(){
        return labelCountries.size();
    }

    public void clickNoida(){
        labelCountries.get(8).click();
    }

    public void printLocationsAfterNoidaClick(){
        for (WebElement ele:sublabelNoida
        ) {
            System.out.println("The type of job and location after clicking Noida is :" + ele.getText());
        }
    }

    public String getQALabel(){
        return lblQA.getText().toLowerCase();
    }

    public String getParentWindow(){
        String parent = driver.getWindowHandle();
        return parent;
    }

    public void switchToWindow(String parent){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String child:allWindowHandles){
            if(!parent.equalsIgnoreCase(child))
            {
                driver.switchTo().window(child);
            }
        }
    }

    public QaProfile clickSeeMore(){
        btnSeeMore.click();
        return new QaProfile(driver) ;
    }
}
