package dropdown;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        int actual = selectedOptions.size();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(selectedOptions.contains(option));
    }

    @Test
    public void testChangeToMultipleSelectionOption() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        String firstOption = "Option 1";
        String secondOption = "Option 2";
        dropdownPage.setAttributeMultiple();
        dropdownPage.selectFromDropdown(firstOption);
        dropdownPage.selectFromDropdown(secondOption);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        List<String> expectedList = List.of(firstOption, secondOption);
        int actual = selectedOptions.size();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedList, selectedOptions);
    }
}
