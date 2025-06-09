package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test(priority = 1)
    public void verify_login_with_valid_credentials() {
        logger.info("**** Starting verify_login_with_valid_credentials ****");
        try {
            driver.get(p.getProperty("appURL")); // Navigate to Home Page at the start
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("validEmail"));
            lp.setPassword(p.getProperty("validPassword"));
            lp.clickLogin();

            MyAccountPage myaccpage = new MyAccountPage(driver);
            Assert.assertTrue(myaccpage.isMyAccountPageExists(), "Login failed with valid credentials");

            myaccpage.clickLogout();
            logger.info("Clicked on logout link");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_valid_credentials ****");
    }

    @Test(priority = 2)
    public void verify_login_with_invalid_password() {
        logger.info("**** Starting verify_login_with_invalid_password ****");
        try {
            driver.get(p.getProperty("appURL")); // Navigate to Home Page at the start
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("validEmail"));
            lp.setPassword(p.getProperty("invalidPassword"));
            lp.clickLogin();

            String actualErrorMessage = lp.getLoginFailureMessage();
            String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message displayed for invalid password");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_invalid_password ****");
    }

    @Test(priority = 3)
    public void verify_login_with_invalid_email() {
        logger.info("**** Starting verify_login_with_invalid_email ****");
        try {
            driver.get(p.getProperty("appURL")); // Navigate to Home Page at the start
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("invalidEmail"));
            lp.setPassword(p.getProperty("validPassword"));
            lp.clickLogin();

            String actualErrorMessage = lp.getLoginFailureMessage();
            String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message displayed for invalid email");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_invalid_email ****");
    }

    @Test(priority = 4)
    public void verify_login_with_invalid_email_and_password() {
        logger.info("**** Starting verify_login_with_invalid_email_and_password ****");
        try {
            driver.get(p.getProperty("appURL")); // Navigate to Home Page at the start
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("invalidEmail"));
            lp.setPassword(p.getProperty("invalidPassword"));
            lp.clickLogin();

            String actualErrorMessage = lp.getLoginFailureMessage();
            String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message displayed for invalid email and password");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_invalid_email_and_password ****");
    }

    @Test(priority = 5)
    public void verify_login_with_empty_credentials() {
        logger.info("**** Starting verify_login_with_empty_credentials ****");
        try {
            driver.get(p.getProperty("appURL")); // Navigate to Home Page at the start
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail("");
            lp.setPassword("");
            lp.clickLogin();

            String actualErrorMessage = lp.getLoginFailureMessage();
            String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message displayed for empty credentials");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_empty_credentials ****");
    }

    @Test(priority = 6)
    public void verify_login_with_blank_email() {
        logger.info("**** Starting verify_login_with_blank_email ****");
        try {
            driver.get(p.getProperty("appURL"));
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail("");
            lp.setPassword(p.getProperty("validPassword"));
            lp.clickLogin();
            Assert.assertTrue(lp.getLoginFailureMessage().contains("Warning"));
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_blank_email ****");
    }

    @Test(priority = 7)
    public void verify_login_with_blank_password() {
        logger.info("**** Starting verify_login_with_blank_password ****");
        try {
            driver.get(p.getProperty("appURL"));
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("validEmail"));
            lp.setPassword("");
            lp.clickLogin();
            Assert.assertTrue(lp.getLoginFailureMessage().contains("Warning"));
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_with_blank_password ****");
    }

    @Test(priority = 8)
    public void verify_login_page_forgot_password_link_present() {
        logger.info("**** Starting verify_login_page_forgot_password_link_present ****");
        try {
            driver.get(p.getProperty("appURL"));
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            Assert.assertTrue(lp.isForgotPasswordLinkPresent());
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
        logger.info("**** Finished verify_login_page_forgot_password_link_present ****");
    }
}
