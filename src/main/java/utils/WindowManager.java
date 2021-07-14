package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigation;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigation = driver.navigate();
    }

    public void goBack() {
        navigation.back();
    }

    public void goForward() {
        navigation.forward();
    }

    public void refreshPage() {
        navigation.refresh();
    }

    public void goTo(String url) {
        navigation.to(url);
    }

    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);
        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("Curent window title: " + driver.getTitle());
            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public void switchToNextTab() {
        var windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
        }
    }
}
