package myPackage.Test;

import myPackage.Date;

import static org.junit.Assert.*;

/**
 * Test class for isValid method within Date
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class DateTest {

    @org.junit.Test
    public void isValid() {

    }

    /**
     * Tests if program can handle invalid days when it is not a leap year
     */
    public void test_days_in_Feb_nonLeap(){
        //28 days in Feb in a non-leap year
        Date date1 = new Date("2/29/2011");
        assertFalse(date1.isValid());
        boolean expectedOutput = false;
        boolean actualOutput = date1.isValid();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests if the program can handle valid dates correctly.
     */
    public void test_valid_dates(){
        Date date2 = new Date("2/28/2011");
        assertTrue(date2.isValid());
        boolean expectedOutput = true;
        boolean actualOutput = date2.isValid();
        assertEquals(expectedOutput, actualOutput);

        Date date4 = new Date("12/14/2000");
        assertTrue(date4.isValid());
        expectedOutput = true;
        actualOutput = date4.isValid();
        assertEquals(expectedOutput, actualOutput);
    }

    /**
     * Tests how the program handles invalid dates.
     */
    public void test_invalid_dates(){
        Date date3 = new Date("13/31/2000");
        assertFalse(date3.isValid());
        boolean expectedOutput = false;
        boolean actualOutput = date3.isValid();
        assertEquals(expectedOutput, actualOutput);

        Date date5 = new Date("-1/15/1999");
        assertFalse(date5.isValid());
        expectedOutput = false;
        actualOutput = date5.isValid();
        assertEquals(expectedOutput, actualOutput);
    }
}