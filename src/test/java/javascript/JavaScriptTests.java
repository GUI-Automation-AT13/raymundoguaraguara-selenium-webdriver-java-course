package javascript;

import base.BaseTests;
import org.junit.jupiter.api.Test;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagrah(5);
    }
}
