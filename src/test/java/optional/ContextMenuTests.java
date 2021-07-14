package optional;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextClick() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextClickOnHotSpot();
        String actual = contextMenuPage.getAlertMessage();
        contextMenuPage.alertClickToAccept();
        String expected = "You selected a context menu";
        Assertions.assertEquals(expected, actual);
    }
}
