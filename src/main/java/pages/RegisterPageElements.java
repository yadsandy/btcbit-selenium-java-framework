package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;


public class RegisterPageElements extends CommonActions {

    // All objects should be defined here
    private final By email_Txt = By.id("email");
    private final By password_Txt = By.id("password");
    private final By passwordConfirm_Txt = By.id("confirmPassword");
    private final By terms_Checkbox = By.xpath("//span[contains(@class,'input-bool_check')]");
    private final By signUp_Btn = By.xpath("//button[text()='Sign up']");
    public CommonActions commonActions;


    public RegisterPageElements(WebDriver driver) {
        super(driver);
    }

    // To fill the login form using email and password and click on sign in button
    public void completeRegisterForm(String email, String password) {
        enterText(email_Txt, email);
        enterText(password_Txt, password);
        enterText(passwordConfirm_Txt, password);
        click(terms_Checkbox);
        click(signUp_Btn);
    }

    public String generateRandomEmail() {
        return randomEmailGenerator();
    }
}
