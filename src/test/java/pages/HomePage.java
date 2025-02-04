package pages;

import core.elements.Banner;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final static Banner MAIN_UPPER_BANNER = new Banner(By.xpath("//div[@id='entry_217960']"),
            "Main upper banner");

    public HomePage() {
        super(By.xpath("//div[@id='common-home']"), "Home Page");
    }
}
