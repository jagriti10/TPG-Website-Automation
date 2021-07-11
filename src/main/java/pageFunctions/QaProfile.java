package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class QaProfile {
    private WebDriver driver;

    @FindBy(css="div[class*='btn'] a[class*='btn-submit']")
    protected WebElement btnApplyForThis;

    public QaProfile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickApply(){
        btnApplyForThis.click();
    }
}
