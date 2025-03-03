package pages;

import core.Logger;
import org.openqa.selenium.By;

public class AccountPage extends BasePage{
    public AccountPage(){
        super(By.xpath("//h2[.='My Account']"),"Account page");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }
}
