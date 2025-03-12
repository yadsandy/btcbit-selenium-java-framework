package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonActions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import static driver.DriverManager.getDriver;


public class ContactsPageElements extends CommonActions {

    private static final By mailLink = By.xpath("//a[contains(@href, 'mailto:')]");
    private static final By hyperlinks = By.tagName("a");
    private final Logger log = LogManager.getLogger(ContactsPageElements.class.getName());
    private final By contactFooter = By.xpath("//div[contains(@class,'footer_copyright')]");
    private final By contactAddress = By.xpath("//div[contains(@class,'footer_address')]/p");
    private final By contactPhone = By.xpath("//div/div[1]/a[contains(@class,'footer_link')]");
    private final By contactEmail = By.xpath("//div/div[2]/a[contains(@class,'footer_link')]");

    public ContactsPageElements(WebDriver driver) {
        super(driver);
    }

    public void goToContactsSection() {
        scrollToElement(contactFooter);
    }

    public List<String> getContactsEmail() {
       return getList(contactEmail);
    }

    public List<String> getContactsAddress() {
        return getList(contactAddress);
    }

    public List<String> getContactPhone() {
        return getList(contactPhone);
    }

    public void checkEmailLinksInContactsPage() {
        List<WebElement> emailLinks = getDriver().findElements(mailLink);
        for (WebElement emailLink : emailLinks) {
            String emailHref = emailLink.getDomAttribute("href");
            if (emailHref.matches("mailto:[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                log.info("✅ Valid Email Link: {}", emailHref);
            } else {
                log.info("❌ Invalid Email Link Format: {}", emailHref);
            }
        }
    }

    public void checkWorkingAndBrokenURLLinksInContactsPage() {
        List<WebElement> allLinks = getDriver().findElements(hyperlinks);
        for (WebElement link : allLinks) {
            String url = link.getDomAttribute("href");
            if (url != null && (url.startsWith("http") || url.startsWith("https"))) {
                checkBrokenURLLinks(url);
            }
        }

    }

    public void checkBrokenURLLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                log.info("❌ Broken Link: {} (Response Code: {})", linkUrl, responseCode);
            } else {
                log.info("✅ Working Link: {} (Response Code: {})", linkUrl, responseCode);
            }
        } catch (Exception e) {
            log.info("⚠\uFE0F Error Checking Link: {}", linkUrl);
        }
    }

}
