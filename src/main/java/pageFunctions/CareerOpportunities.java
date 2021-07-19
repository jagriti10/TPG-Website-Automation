package pageFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Set;

public class CareerOpportunities{
    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(css ="ul[class='careers__cities'] li a")
    List<WebElement> labelCountries;

    @FindBy(css = "li[data-city='Noida'] h3+div")
    List<WebElement> sublabelNoida;

    @FindBy(xpath="//h3[contains(text(),'Quality Assurance Engineer II')]")
    WebElement lblQA;

    @FindBy(xpath = "//h3[contains(text(),'Quality Assurance Engineer II')]/following-sibling::a")
    WebElement btnSeeMore;

    @FindBy(css="h1[class*='headline billboard']")
    WebElement lblCarrerOppurtunity;

    @FindBy(css="span[class='header-logo']")
    WebElement headerLogo;

    @FindBy(css="a[class*='button button-cta']")
    WebElement btnContactUs;

    @FindBy(css="a[aria-label='Search Icon Link'] svg")
    WebElement iconSearch;

    @FindBy(css="[id*='is-search-input-0']")
    WebElement searchBox;

    public CareerOpportunities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickSearchIcon(){
        iconSearch.click();
    }

    public boolean isSearchbarDisplayed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(btnSeeMore));
        btnSeeMore.click();
        return new QaProfile(driver) ;
    }

    public boolean isCareerHeadingDisplayed(){
        return lblCarrerOppurtunity.isDisplayed();
    }

    public boolean isHeaderLogoDisplayed(){
        return headerLogo.isDisplayed();
    }

    public boolean isBtnContactUsDisplayed(){
        return btnContactUs.isDisplayed();
    }

    public void scrollDown(int i){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+i+")");
    }
}
