package biz.sviatoslav.wt;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WtTest extends BaseTest {
    WtPage wtPage = new WtPage(Browser.getDriver());

    @Test
    public void testSiteOpened() {
        WebElement element = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td"));
        String actual = element.getText();
        String expected = "© CoolSoft by Somebody\n" +
                "fhlrhwelrwerhwerh";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void happyPath() {
        wtPage.typeName("Joe")
                .typeHeight("100")
                .typeWeight("50")
                .selectMale()
                .clickCalculateButton();
        Assertions.assertEquals("Значительный избыток массы тела, тучность", wtPage.getResultMessage());
    }

    @Test
    public void idealManProportion() {
        wtPage.typeName("Joe")
                .typeHeight("180")
                .typeWeight("80")
                .selectMale()
                .clickCalculateButton();
        Assertions.assertEquals("Идеальная масса тела", wtPage.getResultMessage());
    }

}
