package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
