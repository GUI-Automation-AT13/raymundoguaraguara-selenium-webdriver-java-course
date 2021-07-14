package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph with index specified in view.
     * @param index 1-based
     */
    public void scrollToParagrah(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var JsExecutor = (JavascriptExecutor)driver;
        while (getNumberOfParagraphsPresent() < index) {
            JsExecutor.executeScript(script);
        }
    }

    public int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }
}
