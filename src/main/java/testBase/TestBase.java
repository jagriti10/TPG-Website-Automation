package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;

    public void initialize(){
        System.setProperty("webdriver.chrome.driver","C://Users//jagriti.sharma//selenium//"+"chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.3pillarglobal.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
