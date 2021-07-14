package hovers;

import base.BaseTests;
import components.FigureCaption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HoversPage;

public class HoversTests extends BaseTests {
    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        FigureCaption caption = hoversPage.hoverOverFigure(1);
        Assertions.assertTrue(caption.isCaptionDisplayed());
        Assertions.assertEquals(caption.getTitle(), "name: user1");
        Assertions.assertEquals(caption.getLinkText(), "View profile");
        Assertions.assertTrue(caption.getLink().endsWith("/users/1"));
    }
}
