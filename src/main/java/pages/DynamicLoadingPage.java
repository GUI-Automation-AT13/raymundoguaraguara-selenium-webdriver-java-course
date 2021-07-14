package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpathFormat = ".//a[contains(text(), \"is\")]";
    private By linkExampleOne = By.xpath(linkXpathFormat);
    private By linkExampleTwo = By.xpath(".//a[contains(text(), \"rendered\")]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingFirstExamplePage clickLinkExampleOne() {
        driver.findElement(linkExampleOne).click();
        return new DynamicLoadingFirstExamplePage(driver);
    }

    public DynamicLoadingSecondExamplePage clickLinkExampleTwo() {
        driver.findElement(linkExampleTwo).click();
        return new DynamicLoadingSecondExamplePage(driver);
    }

    public DynamicLoadingSecondExamplePage openExampleTwoInNewTab() {
        driver.findElement(linkExampleTwo).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingSecondExamplePage(driver);
    }
}
