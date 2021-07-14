package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPages {
    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");

    public FramesPages(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFramesLink() {
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }
}
