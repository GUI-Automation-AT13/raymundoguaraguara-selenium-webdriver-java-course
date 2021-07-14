package base;

import com.google.common.io.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    //Only available on TestNG, since I used Junit could not make it work.
//    @AfterMethod
//    public void recordFailure(ITestResult result) {
//        if (ITestResult.Failure == result.getStatus()) {
//            var camera = (TakesScreenshot)driver;
//            File screenshot = camera.getScreenshotAs(OutputType.FILE);
//            try {
//                Files.move(screenshot, new File("resources/screenshots/test.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Test
    public void testClickOnInputs() {
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();
        WebElement title = driver.findElement(By.cssSelector("h3"));
        Assertions.assertEquals("Inputs",title.getText());
    }

    @Test
    public void testGetAllLinksWithTagNameA() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int actual = links.size();
        int expected = 46;
        Assertions.assertEquals(expected, actual);
    }
}
