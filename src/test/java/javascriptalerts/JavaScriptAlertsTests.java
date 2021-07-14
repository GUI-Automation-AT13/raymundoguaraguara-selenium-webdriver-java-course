package javascriptalerts;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTests extends BaseTests {
    @Test
    public void testAcceptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickTriggerAlertButton();
        javaScriptAlertsPage.alertClickToAccept();
        String actual = javaScriptAlertsPage.getResult();
        String expected = "You successfully clicked an alert";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTextFromAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickTriggerConfirmButton();
        String actual = javaScriptAlertsPage.alertGetText();
        javaScriptAlertsPage.alertClickToDismiss();
        String expected = "I am a JS Confirm";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetInputInAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickTriggerPromptButton();
        String text = "TAU rocks!";
        javaScriptAlertsPage.alertSetInput(text);
        javaScriptAlertsPage.alertClickToAccept();
        String actual = javaScriptAlertsPage.getResult();
        String expected = "You entered: " + text;
        Assertions.assertEquals(expected, actual);
    }
}
