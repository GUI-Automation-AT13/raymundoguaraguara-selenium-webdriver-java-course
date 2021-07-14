package optional;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FramesPages;
import pages.NestedFramesPage;

public class FramesTests extends BaseTests {
    @Test
    public void test() {
        FramesPages framesPages = homePage.clickFrames();
        NestedFramesPage nestedFramesPage = framesPages.clickNestedFramesLink();
        String actualLeft = nestedFramesPage.getLeftFrameText();
        String actualBottom = nestedFramesPage.getBottomFrameText();
        String expectedLeft = "LEFT";
        String expectedBottom = "BOTTOM";
        Assertions.assertEquals(expectedLeft, actualLeft);
        Assertions.assertEquals(expectedBottom, actualBottom);
    }
}
