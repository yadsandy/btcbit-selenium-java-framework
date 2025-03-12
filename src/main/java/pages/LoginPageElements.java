package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;


public class LoginPageElements extends CommonActions {

    private final By email_Lbl = By.id("email");
    private final By password_Lbl = By.id("password");
    private final By signIn_Btn = By.xpath("//button[text()='Sign in']");
    private final By errorMsg_Txt = By.xpath("//div[contains(@class, 'error-message')]");
    private final By wrongCredential_Txt = By.xpath("//div[contains(@class, 'Toastify__toast')]//div[contains(@class, 'bg-error')]");

    public LoginPageElements(WebDriver driver) {
        super(driver);
    }

    public void completeLoginForm(String email, String password) {
        enterText(email_Lbl, email);
        enterText(password_Lbl, password);
        click(signIn_Btn);
    }

    public String getInvalidLoginError() {
        return getText(errorMsg_Txt);
    }

    public String getWrongCredentialsError() {
        return getText(wrongCredential_Txt);
    }

}
