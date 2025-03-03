package pages;

import core.Logger;
import core.elements.Button;
import org.openqa.selenium.By;

public class SuccessPage extends BasePage {
    private final Button CONTINUE = new Button(
            By.xpath("//a[.='Continue']"), "Continue");

    public SuccessPage() {
        super(By.xpath("//h1[@class='page-title my-3']"), "Success Page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public void clickContinue(){
        CONTINUE.clickOnElement();
    }
}
