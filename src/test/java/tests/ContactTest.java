package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactsPageElements;
import pages.HomePageElements;
import utils.Feature;
import utils.TestListener;

import java.util.HashMap;
import java.util.List;

import static driver.DriverManager.getDriver;
import static utils.Constants.*;

@Listeners(TestListener.class)
public class ContactTest extends BaseTest {

    private final Logger log = LogManager.getLogger(ContactTest.class.getName());
    ContactsPageElements contactsPageElements;
    HomePageElements homePageElements;

    ContactTest() {
        contactsPageElements = new ContactsPageElements(getDriver());
        homePageElements = new HomePageElements(getDriver());

    }

    @Feature(CONTACTS)
    @Test(description = "This method is to check the contact section and hyperlinks")
    public void verifyContactsSectionAndHyperLinks() {
        homePageElements.openHomePage();
        log.info("Navigated to BTC-BIT home page.");
        homePageElements.clickOnContactsFromHomePage();
        log.info("Clicked on contacts section from home page");
        contactsPageElements.goToContactsSection();
        log.info("Scrolled to contacts area in Contacts page");
        List<String> emailList=contactsPageElements.getContactsEmail();
        Assert.assertEquals(emailList.get(0),CONTACT_EMAIL);
        Assert.assertEquals(emailList.get(1),CONTACT_EMAIL);
        log.info("Verified Contacts email in Contacts page");
        List<String> phoneList=contactsPageElements.getContactPhone();
        Assert.assertEquals(phoneList.get(0),PHONE_1);
        Assert.assertEquals(phoneList.get(1),PHONE_2);
        log.info("Verified Contacts phone in Contacts page");
        List<String> addressList=contactsPageElements.getContactsAddress();
        Assert.assertEquals(addressList.get(0).replaceAll("\\n", " "),CONTACT_ADDRESS_1);
        Assert.assertEquals(addressList.get(1).replaceAll("\\n", " "),CONTACT_ADDRESS_2);
        log.info("Verified Contacts address in Contacts page");
        contactsPageElements.checkEmailLinksInContactsPage();
        log.info("Verified email links in Contacts page");
        contactsPageElements.checkWorkingAndBrokenURLLinksInContactsPage();
        log.info("Verified working and broken urls in Contacts page");
    }


}
