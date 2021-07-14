package optional;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShiftingContentTests extends BaseTests {
    @Test
    public void testGetsAllTitlesOnMenuElement() {
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();
        WebElement menuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElement.click();
        List<WebElement> titles = driver.findElements(By.cssSelector("ul li a"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
        }
        int actual = titles.size();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }
}
