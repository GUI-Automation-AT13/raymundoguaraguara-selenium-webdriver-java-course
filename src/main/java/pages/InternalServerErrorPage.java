package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InternalServerErrorPage {
    private WebDriver driver;
    private By message = By.cssSelector("h1");

    public InternalServerErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage() {
        return driver.findElement(message).getText();
    }
}
