package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.HomePage;
import utils.EventReporter;

import java.util.List;

public class BaseTests {
    protected EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
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

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.setHeadless(true);
        return options;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

    private void deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    private Boolean cookieExists(Cookie cookie) {
        Cookie newCookie = driver.manage().getCookieNamed(cookie.getName());
        return newCookie != null;
    }

    @Test
    public void testDeleteCookie() {
        setCookie();
        Cookie cookie = driver.manage().getCookieNamed("tau");
        deleteCookie(cookie);
        Assertions.assertFalse(cookieExists(cookie));
    }
}
