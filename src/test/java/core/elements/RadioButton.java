package core.elements;

import core.Browser;
import org.openqa.selenium.By;

public class RadioButton extends BaseElement {
    public RadioButton(By locator, String name) {
        super(locator, name);
        element = Browser.getDriver().findElement(locator);
    }

    public boolean isSelected() {
        return element.isSelected();
    }
}
