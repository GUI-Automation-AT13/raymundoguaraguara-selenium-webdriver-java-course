package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void contextClickOnHotSpot() {
        WebElement webElement = driver.findElement(hotSpot);
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).perform();
    }

    public void alertClickToAccept() {
        driver.switchTo().alert().accept();
    }

    public String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }
}
