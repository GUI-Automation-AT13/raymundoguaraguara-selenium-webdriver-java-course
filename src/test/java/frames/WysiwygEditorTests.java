package frames;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.WysiwygEditorPage;

public class WysiwygEditorTests extends BaseTests {
    @Test
    public void testWysiwygEditor() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        String firstText = "Hello ";
        String secondText = "world";
        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.setTextArea(firstText);
        wysiwygEditorPage.clickDecreaseIndentButton();
        wysiwygEditorPage.setTextArea(secondText);
        String actual = wysiwygEditorPage.getTextFromEditor();
        String expected = firstText + secondText;
        Assertions.assertEquals(expected, actual);
    }
}
