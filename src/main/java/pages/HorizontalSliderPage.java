package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.cssSelector(".sliderContainer input");
    private By sliderValue = By.cssSelector(".sliderContainer span");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSlider() {
        driver.findElement(slider).click();
    }

    public void moveSliderRight() {
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
    }

    public void moveSliderLeft() {
        driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
    }

    public void moveRightToRangeValue(int range) {
        for (int i = 0; i < (range * 2); i++) {
            moveSliderRight();
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }
}
