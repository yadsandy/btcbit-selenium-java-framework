package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;

public class ProfilePageElements extends CommonActions {


    private final By profileEmail_Txt = By.xpath("//span[text()='Email']/following-sibling::span");

    public ProfilePageElements(WebDriver driver) {
        super(driver);
    }

    public String getUserDetailsAfterLogin() {
        return getText(profileEmail_Txt);
    }

    public String getCurrentPageUrlAfterLogin() {
        return getCurrentPageUrl();
    }
}
