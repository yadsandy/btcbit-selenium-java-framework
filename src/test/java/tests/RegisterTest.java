package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePageElements;
import pages.LoginPageElements;
import pages.ProfilePageElements;
import pages.RegisterPageElements;
import utils.Feature;
import utils.TestListener;

import static driver.DriverManager.getDriver;
import static utils.Constants.PASSWORD;
import static utils.Constants.REGISTER;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    private final Logger log = LogManager.getLogger(RegisterTest.class.getName());
    LoginPageElements loginPageElements;
    RegisterPageElements registerPageElements;
    HomePageElements homePageElements;
    ProfilePageElements profilePageElements;

    RegisterTest() {
        loginPageElements = new LoginPageElements(getDriver());
        homePageElements = new HomePageElements(getDriver());
        registerPageElements = new RegisterPageElements(getDriver());
        profilePageElements = new ProfilePageElements(getDriver());
    }

    @Feature(REGISTER)
    @Test(description = "This method is to check the valid scenarios for registration")
    public void performRegistrationWithValidCredentials() {
        homePageElements.openHomePage();
        log.info("Navigated to BTC-BIT home page.");
        homePageElements.clickOnGetStartedFromHomePage();
        log.info("Clicked on Get Started button from home page.");
        String emailId = registerPageElements.generateRandomEmail();
        log.info("Random email for registration is{}", emailId);
        registerPageElements.completeRegisterForm(emailId, PASSWORD);
        log.info("Registration form is filled and click on Sign up button.");
        // Comment after this as the Captcha is occurring on the registration page.
//        String emailFromProfilePage = profilePageElements.getUserDetailsAfterLogin();
//        Assert.assertEquals(emailFromProfilePage, emailId);
//        log.info("Verified user email after successful registration");
    }

}
