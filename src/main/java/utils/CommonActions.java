package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static driver.DriverManager.getDriver;
import static utils.Constants.WAIT_EXPLICIT;

public class CommonActions {
    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        getDriver().findElement(locator).click();

    }

    public void enterText(By locator, String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", getDriver().findElement(locator));
        getDriver().findElement(locator).sendKeys(value);
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    public String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }


    public String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_EXPLICIT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public void scrollToElement(By locator) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", getDriver().findElement(locator));
    }

    public List<String> getList(By locator) {
        List<WebElement> list = getDriver().findElements(locator);
        List<String> getValues = new ArrayList<>();
        for (WebElement value : list) {
            System.out.println(value.getText());
            getValues.add(value.getText());
        }
        return getValues;
    }

    public String randomEmailGenerator() {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        return "validuser" + randomNumber + "@gmail.com";

    }
}
