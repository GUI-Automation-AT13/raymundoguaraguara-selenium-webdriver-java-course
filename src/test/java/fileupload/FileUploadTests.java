package fileupload;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\Raymundo\\Documents\\Cursos\\Jala\\GUI testing\\raymundoguaraguara-selenium-webdriver-java-course\\resources\\chromedriver.exe");
        String actual = fileUploadPage.getUploadedFiles();
        String expected = "chromedriver.exe";
        Assertions.assertEquals(expected, actual);
    }
}
