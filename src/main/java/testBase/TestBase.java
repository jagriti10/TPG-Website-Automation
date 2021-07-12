package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class TestBase {
    protected WebDriver driver;

    public void initialize(){
        System.setProperty("webdriver.chrome.driver","C://Users//jagriti.sharma//selenium//"+"chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.3pillarglobal.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
    public WebDriver getDriver(){
        return driver;
    }


    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        initialize();
    }

    @AfterSuite
    public void closeDriver(){ driver.quit(); }

}
