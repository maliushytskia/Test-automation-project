package core.elements;

import core.Constants;
import core.Logger;
import org.openqa.selenium.By;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void eraseValueFromField() {
        Logger.getInstance().info(String.format("Clearing %s field", element));
        isPresent(Constants.DEFAULT_TIMEOUT_MS);
        element.clear();
    }
}
