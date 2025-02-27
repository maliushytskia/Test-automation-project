package pages;

import core.Browser;
import core.Constants;
import core.Logger;
import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private By locator;
    private String name;

    protected BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    protected void isPageOpen() {
        Label lbl = new Label(locator, name);
        try {
            lbl.isElementPresent();
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
