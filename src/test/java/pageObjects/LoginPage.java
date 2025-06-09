package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; // Import Duration for WebDriverWait

public class LoginPage extends BasePage {

    // Constructor: Initializes the WebDriver instance for this Page Object
    // It calls the constructor of the parent class (BasePage)
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // WebElements: Using @FindBy annotations to locate elements on the page.
    // These elements are automatically initialized by PageFactory when this class is instantiated.

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement txtLoginFailureMessage; // For displaying login error messages

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement txtMyAccountTitle; // Used to verify successful login by checking for "My Account" title

    @FindBy(linkText = "Forgotten Password")
    WebElement lnkForgotPassword; // Link to the "Forgotten Password" page

    // Action Methods: These methods encapsulate interactions with the WebElements.

    /**
     * Sets the email address in the email input field.
     * Waits for the email field to be visible before interacting.
     * @param email The email address to enter.
     */
    public void setEmail(String email) {
        // Use Duration.ofSeconds for WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
        txtEmailAddress.clear(); // Clears any existing text in the field
        txtEmailAddress.sendKeys(email); // Enters the provided email
    }

    /**
     * Sets the password in the password input field.
     * Waits for the password field to be visible before interacting.
     * @param pwd The password to enter.
     */
    public void setPassword(String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.clear(); // Clears any existing text in the field
        txtPassword.sendKeys(pwd); // Enters the provided password
    }

    /**
     * Clicks the Login button.
     * Waits for the button to be clickable before clicking.
     */
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }

    // Verification/Helper Methods: These methods help verify the state of the page.

    /**
     * Retrieves the text of the login failure message.
     * Waits for the error message to be visible.
     * Returns an empty string if the element is not found within the timeout (e.g., no error occurred).
     * @return The text of the login failure message, or an empty string if not present.
     */
    public String getLoginFailureMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(txtLoginFailureMessage));
            return txtLoginFailureMessage.getText();
        } catch (Exception e) {
            // Log the exception if needed for debugging, but return "" for test flow.
            // System.err.println("Login failure message not found: " + e.getMessage());
            return "";
        }
    }

    /**
     * Checks if the "My Account" title is displayed, indicating successful login.
     * Waits for the title to be visible.
     * @return true if "My Account" title is displayed, false otherwise.
     */
    public boolean isMyAccountPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(txtMyAccountTitle));
            return txtMyAccountTitle.isDisplayed();
        } catch (Exception e) {
            // Log the exception if needed for debugging
            // System.err.println("My Account title not displayed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if the "Forgotten Password" link is present and displayed on the page.
     * Waits for the link to be visible.
     * @return true if the link is displayed, false otherwise.
     */
    // FIX: This method was incorrectly nested inside isMyAccountPageDisplayed().
    // It has been moved to be a direct member of the LoginPage class.
    public boolean isForgotPasswordLinkPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(lnkForgotPassword));
            return lnkForgotPassword.isDisplayed();
        } catch (Exception e) {
            // Log the exception if needed
            // System.err.println("Forgotten Password link not found: " + e.getMessage());
            return false;
        }
    }
}
