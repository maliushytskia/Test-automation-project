package core.elements;

import org.openqa.selenium.By;

public class RadioButton extends BaseElement {
    public RadioButton(By locator, String name) {
        super(locator, name);
    }

    public boolean isSelected() {
        return element.isSelected();
    }
}
