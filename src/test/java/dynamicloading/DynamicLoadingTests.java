package dynamicloading;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DynamicLoadingFirstExamplePage;
import pages.DynamicLoadingPage;
import pages.DynamicLoadingSecondExamplePage;

public class DynamicLoadingTests extends BaseTests {
    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingFirstExamplePage dynamicLoadingFirstExamplePage = dynamicLoadingPage.clickLinkExampleOne();
        dynamicLoadingFirstExamplePage.clickStart();
        String actual = dynamicLoadingFirstExamplePage.getLoadedText();
        String expected = "Hello World!";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWaitUntilFact() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingSecondExamplePage dynamicLoadingSecondExamplePage = dynamicLoadingPage.clickLinkExampleTwo();
        dynamicLoadingSecondExamplePage.clickStart();
        String actual = dynamicLoadingSecondExamplePage.getLoadedText();
        String expected = "Hello World!";
        Assertions.assertEquals(expected, actual);
    }
}
