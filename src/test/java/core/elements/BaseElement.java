package core.elements;

import core.Browser;
import core.Constants;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement {
    private static WebDriver driver = Browser.getDriver();
    private static Logger logger = Logger.getInstance();
    protected WebElement element;
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        this.element = findElement();
    }

    public BaseElement() {
    }

    public WebElement findElement() {
        List<WebElement> list = driver.findElements(locator);
        if (list.isEmpty()) {
            return null;
        }

        return list.
                stream().
                filter(WebElement::isDisplayed).
                findFirst()
                .orElse(null);
    }

    public By getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return driver.findElement(locator).isEnabled();
    }

    public void waitForElementClickable() {
        new FluentWait<>(driver)
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click() {
        if (isPresent(Constants.DEFAULT_TIMEOUT_MS)) {
            waitForElementClickable();
            logger.info(String.format("Clicking on %s element", name));
            element.click();
        }
    }

    public List<WebElement> findElements() {
        return driver.findElements(locator);
    }

    public void sendKeys(String value) {
        if (isPresent(Constants.DEFAULT_TIMEOUT_MS)) {
            logger.info(String.format("Sending %s value in %s element", value, name));
            driver.findElement(locator).sendKeys(value);
        }
    }

    public boolean isElementPresent() {
        logger.info(String.format("Checking presence of %s element", element));
        return isPresent(Constants.DEFAULT_TIMEOUT_MS);
    }

    public boolean isPresent(int timeout) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(Browser.getDriver());
        fluentWait
                .withTimeout(Duration.ofMillis(timeout))
                .pollingEvery(Constants.DEFAULT_WAIT_TIME)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            element = fluentWait.until(driver -> {
                List<WebElement> list = driver.findElements(locator);
                if (list.isEmpty()) {
                    return null;
                }

                return list.
                        stream().
                        filter(WebElement::isDisplayed).
                        findFirst()
                        .orElse(null);
            });

            return element != null;

        } catch (Exception e) {
            logger.warn(String.format("Element %s is not found after waiting for %d milliseconds", element, timeout));
        }
        return false;
    }
}
