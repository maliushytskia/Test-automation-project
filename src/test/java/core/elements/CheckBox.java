package core.elements;

import core.Browser;
import core.Logger;
import org.openqa.selenium.By;

public class CheckBox extends BaseElement {
    public CheckBox(By locator, String name) {
        super(locator, name);
    }

    public boolean isChecked() {
        element = getElement().element;
        scrollToElementForVisibility();
        Logger.getInstance().info(String.format("Check that %s element is checked", element));
        return element.isSelected();
    }
}
