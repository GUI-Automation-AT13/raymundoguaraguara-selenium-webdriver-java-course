package optional;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.InternalServerErrorPage;

public class ForgoPasswordTests extends BaseTests {
    /*
    On the original exercise we were supposed to get a success message,
    but the web page is not working as expected and is only returning an
    internal server error. The test for this will be to assert that error.
    */
    @Test
    public void testPasswordRetrievedFailed() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("email@test.com");
        InternalServerErrorPage internalServerErrorPage = forgotPasswordPage.clickRetrievePasswordButton();
        String actual = internalServerErrorPage.getMessage();
        String expected = "Internal Server Error";
        Assertions.assertEquals(expected, actual);
    }
}
