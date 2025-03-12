package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;

import static utils.Constants.URL;

public class HomePageElements extends CommonActions {

    // All objects should be defined here
    private final By getStarted_Btn = By.xpath("//a[contains(@class,'header_signup__') and text()='Get Started']");
    private final By login_Btn = By.xpath("//a[contains(@class,'header_login')]");
    private final By menu_Lbl = By.xpath("//button[@title='Open menu']//*[name()='svg']");
    private final By contacts_Txt = By.xpath("(//a[text()='Contacts'])[1]");


    public HomePageElements(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        navigateTo(URL);
    }

    public void clickOnGetStartedFromHomePage() {
        click(getStarted_Btn);
    }

    public void clickOnLoginFromHomePage() {
        click(login_Btn);
    }

    public void clickOnContactsFromHomePage() {
        click(menu_Lbl);
        click(contacts_Txt);
    }

}
