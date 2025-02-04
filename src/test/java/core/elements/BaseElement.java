package core.elements;

import core.Browser;
import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseElement {
    public static WebDriver driver = Browser.getDriver();
    protected WebElement element;
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
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

    public void waitFotElementVisible() {
        new FluentWait<>(driver)
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable() {
        new FluentWait<>(driver)
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementPresent() {
        new FluentWait<>(driver)
                .withTimeout(Constants.DEFAULT_WAIT_TIME)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
