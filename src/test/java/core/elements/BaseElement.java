package core.elements;

import core.Browser;
import core.Constants;
import core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public abstract class BaseElement {
    private static WebDriver driver = Browser.getDriver();
    private static Logger logger = Logger.getInstance();
    private final Actions actions = new Actions(driver);
    protected WebElement element;
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public BaseElement() {
    }

    public BaseElement getElement() {
        if (element == null) {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Constants.DEFAULT_WAIT_TIME)
                    .pollingEvery(Duration.ofMillis(Constants.DEFAULT_TIMEOUT_MS))
                    .ignoring(NoSuchElementException.class);
            element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        return this;
    }

    public By getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public WebElement getWebElement() {
        return element;
    }

    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    public String getWebElementText() {
        FluentWait<WebDriver> wait = new FluentWait<>(Browser.getDriver())
                .ignoring(NullPointerException.class)
                .withTimeout(Constants.DEFAULT_WAIT_TIME).pollingEvery(Duration.ofMillis(Constants.DEFAULT_TIMEOUT_MS));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void waitForElementClickable() {
        new FluentWait<>(driver)
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(getElement().getWebElement()));
    }

    public void clickOnElement() {
        if (isPresent(Constants.DEFAULT_TIMEOUT_MS)) {
            waitForElementClickable();
            logger.info(String.format("Clicking on %s element", name));
            getElement().getWebElement().click();
        }
    }

    public void clickOnElementWithScroll() {
        if (isPresent(Constants.DEFAULT_TIMEOUT_MS)) {
            waitForElementClickable();
            logger.info(String.format("Clicking on %s element", name));
            scrollToElementForVisibility();
            getElement().getWebElement().click();
        }
    }

    void scrollToElementForVisibility() {
        if (element != null) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element: " + name);
        }
    }

    public List<WebElement> findElements() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(Constants.DEFAULT_TIMEOUT_MS))
                .ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);
            return (elements.isEmpty()) ? null : elements;
        });
    }

    public void sendKeysToElement(String value) {
        if (isPresent(Constants.DEFAULT_TIMEOUT_MS)) {
            logger.info(String.format("Sending %s value in %s element", value, name));
            element.sendKeys(value);
        }
    }

    public boolean isElementPresent() {
        logger.info(String.format("Checking presence of %s element", getElement().getName()));
        return isPresent(Constants.DEFAULT_TIMEOUT_MS);
    }

    public boolean isPresent(int timeout) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(Browser.getDriver());
        fluentWait
                .withTimeout(Duration.ofMillis(timeout))
                .pollingEvery(Constants.DEFAULT_WAIT_TIME)
                .ignoring(NoSuchElementException.class);
        try {
            element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (element != null) {
                Logger.getInstance().warn(String.format("Element %s is present and visible after waiting for %d milliseconds", locator, timeout));
                return true;
            }
        } catch (NoSuchElementException e) {
            logger.warn(String.format("Element %s is not found after waiting for %d milliseconds", locator, timeout));
        }
        return false;
    }

    public void hoveringOverWebElement() {
        Logger.getInstance().info(String.format("Hovering over the element %s", locator));
        actions.moveToElement(getElement().getWebElement()).perform();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseElement element = (BaseElement) o;
        return Objects.equals(locator, element.locator) && Objects.equals(name, element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locator, name);
    }
}
