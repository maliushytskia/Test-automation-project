package pages;

import core.elements.Label;
import org.openqa.selenium.By;

public abstract class BasePage {
    private By locator;
    private String name;

    protected BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
        isPageOpen();
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
