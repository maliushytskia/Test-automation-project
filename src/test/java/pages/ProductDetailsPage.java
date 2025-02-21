package pages;

import core.Logger;
import core.elements.Button;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage() {
        super(By.xpath("//span[@class='ls-label' and .='Product Code:']"), "Product Code");
        Logger.getInstance().info(String.format("%s is opened", this.getClass().getSimpleName()));
    }

    public String getButtonState(String buttonName) {
        Button button = new Button(By.xpath(
                "//div[@id='entry_216840']//child::button[@title='" + buttonName + "']"),
                "ButtonName");
        return button.findElement().getText();
    }

    public ProductDetailsPage navigateToShoppingCategoryBreadcrumbs(String page) {
        Button button =
                new Button(By.xpath(
                        "//nav[@aria-label='breadcrumb']//child::a[.='" + page + "']"),
                        "Breadcrumbs main list");
        button.click();
        return this;
    }
}
