package PepperiUtilites;

import Pepperi.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtils extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
    }

    public Object getElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    public void waitForElementPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findAllElements(By locator) {
        return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean waitUntilElementDisappear(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilElementPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementDisplayed(By locator) {
        return waitUntilVisible(locator).isDisplayed();
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        waitUntilElementClickable((WebElement) locator).click();
    }

    public WebElement waitUntilElementClickable(WebElement thisElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(thisElement));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitUntilTextVisible(By locator, String text) {
        TimeUtil.shortWait();
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean waitUntilValueIsVisible(By locator, String text) {
        TimeUtil.shortWait();
        return wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void waitUntilObjectNotVisible(By locator) {
        TimeUtil.shortWait();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void waitUntilUrlIncludes(String url) {
        wait.until(ExpectedConditions.urlContains(prop.getProperty(url)));
    }

    public void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        TimeUtil.mediumWait();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        TimeUtil.mediumWait();
    }

    public boolean verifyTextPresent(String text) {
        return driver.getPageSource().contains(text);
    }
}





