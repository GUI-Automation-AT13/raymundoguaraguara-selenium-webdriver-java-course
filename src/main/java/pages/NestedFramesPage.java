package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topIFrameName = "frame-top";
    private String bottomIFrameName = "frame-bottom";
    private String leftIFrameName = "frame-left";
    private By body = By.cssSelector("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToBottomFrame() {
        driver.switchTo().frame(bottomIFrameName);
    }

    private void switchToTopFrame() {
        driver.switchTo().frame(topIFrameName);
    }

    private void switchToTheMainFrame() {
        driver.switchTo().parentFrame();
    }

    private void switchToTheLeftFrame() {
        switchToTopFrame();
        driver.switchTo().frame(leftIFrameName);
    }

    private void switchToTheMainFrameFromDeeperLevel() {
        driver.switchTo().parentFrame();
        switchToTheMainFrame();
    }

    public String getLeftFrameText() {
        switchToTheLeftFrame();
        String text = driver.findElement(body).getText();
        switchToTheMainFrameFromDeeperLevel();
        return text;
    }

    public String getBottomFrameText() {
        switchToBottomFrame();
        String text = driver.findElement(body).getText();
        switchToTheMainFrame();
        return text;
    }
}
