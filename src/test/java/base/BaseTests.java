package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

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
