package core.elements;

import org.openqa.selenium.By;

public class CheckBox extends BaseElement {
    public CheckBox(By locator, String name) {
        super(locator, name);
    }

    public boolean isChecked() {
        return element.isSelected();
    }
}
