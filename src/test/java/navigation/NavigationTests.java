package navigation;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DynamicLoadingSecondExamplePage;
import utils.WindowManager;

public class NavigationTests extends BaseTests {
    @Test
    public void test() {
        homePage.clickDynamicLoading().clickLinkExampleOne();
        WindowManager windowManager = new WindowManager(driver);
        windowManager.goBack();
        windowManager.refreshPage();
        windowManager.goForward();
        windowManager.goTo("https://google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHereLink();
        WindowManager windowManager = new WindowManager(driver);
        windowManager.switchToTab("New Window");
    }

    @Test
    public void testSwitchTabOnDynamicLoading() {
        DynamicLoadingSecondExamplePage dynamicLoadingSecondExamplePage = homePage.clickDynamicLoading().openExampleTwoInNewTab();
        WindowManager windowManager = new WindowManager(driver);
        windowManager.switchToNextTab();
        Assertions.assertTrue(dynamicLoadingSecondExamplePage.isStartButtonPresent());
    }
}
