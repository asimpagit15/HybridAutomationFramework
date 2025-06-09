package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtBillingFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtBillingLastName;

    @FindBy(xpath = "//input[@id='input-address-1']")
    WebElement txtBillingAddress;

    @FindBy(xpath = "//input[@id='input-city']")
    WebElement txtBillingCity;

    @FindBy(xpath = "//input[@id='input-postcode']")
    WebElement txtBillingPostcode;

    @FindBy(xpath = "//select[@id='input-country']")
    WebElement drpBillingCountry;

    @FindBy(xpath = "//select[@id='input-zone']")
    WebElement drpBillingState;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkTermsAndConditions;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public void setBillingFirstName(String firstName) {
        txtBillingFirstName.sendKeys(firstName);
    }

    public void setBillingLastName(String lastName) {
        txtBillingLastName.sendKeys(lastName);
    }

    public void setBillingAddress(String address) {
        txtBillingAddress.sendKeys(address);
    }

    public void setBillingCity(String city) {
        txtBillingCity.sendKeys(city);
    }

    public void setBillingPostcode(String postcode) {
        txtBillingPostcode.sendKeys(postcode);
    }

    public void selectBillingCountry(String country) {
        drpBillingCountry.sendKeys(country);
    }

    public void selectBillingState(String state) {
        drpBillingState.sendKeys(state);
    }

    public void agreeToTermsAndConditions() {
        chkTermsAndConditions.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }
}
