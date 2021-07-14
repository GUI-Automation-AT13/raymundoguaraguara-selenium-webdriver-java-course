package keypresses;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTests {
    @Test
    public void testBackSpace() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        String actual = keyPressesPage.getResult();
        String expected = "You entered: BACK_SPACE";
        Assertions.assertEquals(expected, actual);
    }
}
