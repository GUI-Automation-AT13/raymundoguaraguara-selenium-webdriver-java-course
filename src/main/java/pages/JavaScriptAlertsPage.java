package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[text()=\"Click for JS Alert\"]");
    private By triggerConfirmButton = By.xpath("//button[text()=\"Click for JS Confirm\"]");
    private By triggerPromptButton = By.xpath("//button[text()=\"Click for JS Prompt\"]");
    private By results = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTriggerAlertButton() {
        driver.findElement(triggerAlertButton).click();
    }

    public void clickTriggerConfirmButton() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void clickTriggerPromptButton() {
        driver.findElement(triggerPromptButton).click();
    }

    public void alertClickToAccept() {
        driver.switchTo().alert().accept();
    }

    public String getResult() {
        return driver.findElement(results).getText();
    }

    public void alertClickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alertGetText() {
        return driver.switchTo().alert().getText();
    }

    public void alertSetInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
