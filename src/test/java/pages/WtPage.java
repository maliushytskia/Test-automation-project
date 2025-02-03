package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WtPage {
    private static final String submitButton = "//input[@type='submit']";
    private static final String nameField = "//input[@name='name']";
    private static final String heightField = "//input[@name='height']";
    private static final String weightField = "//input[@name='weight']";
    private static final String maleRadioButton = "//input[@name='gender' and @value='m']";
    private static final String femaleRadioButton = "//input[@name='gender' and @value='f']";
    private static final String resultMessage = "//td[.='menu']/following-sibling::td[1]";

    WebDriver driver;
    WebDriverWait wait;

    public WtPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WtPage clickCalculateButton() {
        By calculate = By.xpath(submitButton);
        WebElement btn = driver.findElement(calculate);
        btn.click();
        return this;
    }

    public WtPage typeName(String value) {
        By name = By.xpath(nameField);
        WebElement findName = driver.findElement(name);
        findName.sendKeys(value);
        return this;
    }

    public WtPage typeHeight(String value) {
        By height = By.xpath(heightField);
        WebElement findHeight = driver.findElement(height);
        findHeight.sendKeys(value);
        return this;
    }

    public WtPage typeWeight(String value) {
        By weight = By.xpath(weightField);
        WebElement findWeight = driver.findElement(weight);
        findWeight.sendKeys(value);
        return this;
    }

    public WtPage selectMale() {
        By gender = By.xpath(maleRadioButton);
        WebElement findGender = driver.findElement(gender);
        findGender.click();
        return this;
    }

    public WtPage selectFemale() {
        By gender = By.xpath(femaleRadioButton);
        WebElement findGender = driver.findElement(gender);
        findGender.click();
        return this;
    }

    public String getResultMessage() {
        By result = By.xpath(resultMessage);
        WebElement findResult = wait.until(ExpectedConditions.presenceOfElementLocated(result));
        return findResult.getText();
    }
}
