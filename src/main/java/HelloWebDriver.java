import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://svyatoslav.biz/testlab/wt/index.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        Wait<ChromeDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30));



        try {
            By calculate = By.xpath("//input[@type='submit']");
            By name = By.xpath("//input[@name='name']");
            By height = By.xpath("//input[@name='height']");
            By weight = By.xpath("//input[@name='weight']");
            By gender = By.xpath("//input[@name='gender' and @value='m']");
            By result = By.xpath("//td[.='menu']/following-sibling::td[1]");

            WebElement btn = driver.findElement(calculate);
            WebElement findName = driver.findElement(name);
            WebElement findHeight = driver.findElement(height);
            WebElement findWeight = driver.findElement(weight);
            WebElement findGender = driver.findElement(gender);

            findName.sendKeys("Joe");
            findHeight.sendKeys("100");
            findWeight.sendKeys("50");

            wait.until(ExpectedConditions.elementToBeClickable(btn));
            wait.until(ExpectedConditions.presenceOfElementLocated(result));
            findGender.click();
            btn.click();
            WebElement findResult = driver.findElement(result);
           Assertions.assertEquals("Значительный избыток массы тела, тучность", findResult.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
