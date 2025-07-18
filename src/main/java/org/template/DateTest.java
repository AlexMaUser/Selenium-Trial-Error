package org.template;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTest extends BaseTestTwo {
    @Test
    public void testSelectingDate() {
        String month = "December";
        String monthNumber = "12";
        String day = "31";
        String year = "2025";
        var datePickerPage = homePage.goToWidgets().clickDatePicker();
        datePickerPage.clickSelectDate();
        datePickerPage.selectMonth(month);
        datePickerPage.selectyear(year);
        datePickerPage.clickDay(day);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualDate = datePickerPage.getDate();
        String expectedDate = monthNumber + "/" + day + "/" + year;
        Assert.assertEquals(actualDate, expectedDate,
                "\n Dates do not match\n" +
                "\n Actual Date: \n" + actualDate +
                "\n Expected Date: \n" + expectedDate);
    }
}
