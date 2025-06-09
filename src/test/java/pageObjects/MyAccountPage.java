package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    public boolean isMyAccountPageExists()   // MyAccount Page heading display status
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(msgHeading));
            return msgHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
    }
}

