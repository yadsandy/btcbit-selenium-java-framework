package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageElements;
import pages.LoginPageElements;
import pages.ProfilePageElements;
import utils.Feature;

import static driver.DriverManager.getDriver;
import static utils.Constants.*;


public class LoginTest extends BaseTest {
    private final Logger log = LogManager.getLogger(LoginTest.class.getName());
    LoginPageElements loginPageElements;
    HomePageElements homePageElements;
    ProfilePageElements profilePageElements;

    LoginTest() {
        loginPageElements = new LoginPageElements(getDriver());
        homePageElements = new HomePageElements(getDriver());
        profilePageElements = new ProfilePageElements(getDriver());

    }

    @BeforeMethod
    public void navigateToLoginPage() {
        homePageElements.openHomePage();
        log.info("Navigated to BTC-BIT home page.");
        homePageElements.clickOnLoginFromHomePage();
        log.info("Clicked on login button from home page");
    }

    @Feature(LOGIN)
    @Test(description = "This method is to check the valid scenarios for login page")
    public void performLoginWithValidCredentials() {
        loginPageElements.completeLoginForm(USER, PASSWORD);
        log.info("Completed login submission from login page");
        String emailFromProfilePage = profilePageElements.getUserDetailsAfterLogin();
        Assert.assertEquals(emailFromProfilePage, USER);
        log.info("Verified user email after successful loggedIn");
        String profileURL = profilePageElements.getCurrentPageUrlAfterLogin();
        Assert.assertEquals(profileURL, PROFILE_URL);
        log.info("Verified profile url after successful loggedIn");
    }

    @Feature(LOGIN)
    @Test(description = "This method is to check the invalid scenarios for login page")
    public void performLoginWithInvalidCredentials() {
        loginPageElements.completeLoginForm("", "");
        Assert.assertEquals(loginPageElements.getInvalidLoginError(), BLANK_EMAIL);
        log.info("verified invalid login for blank user and password");
        loginPageElements.completeLoginForm(PASSWORD, "");
        Assert.assertEquals(loginPageElements.getInvalidLoginError(), INVALID_EMAIL);
        log.info("verified invalid login for invalid user and password");
        loginPageElements.completeLoginForm(USER, "1234");
        Assert.assertEquals(loginPageElements.getInvalidLoginError(), INVALID_PASS);
        log.info("verified invalid login for valid user and invalid password");
        loginPageElements.completeLoginForm(USER, USER);
        Assert.assertEquals(loginPageElements.getWrongCredentialsError(), WRONG_CREDENTIALS);
        log.info("verified invalid login for wrong credentials");

    }
}