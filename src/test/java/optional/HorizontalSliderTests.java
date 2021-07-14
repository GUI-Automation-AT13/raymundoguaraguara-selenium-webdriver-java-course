package optional;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTests extends BaseTests {
    @Test
    public void testHorizontalSliderGetsTo4() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveRightToRangeValue(4);
        String actual =horizontalSliderPage.getSliderValue();
        String expected = "4";
        Assertions.assertEquals(expected, actual);
    }
}
