package myPackage;
import java.util.Calendar;
/**
 * Date object class
 * This class creates an object for the dates to keep track of each member's memberships and dates of birth.
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int FEBRUARY = 2;
    public static final int APRIL = 4;
    public static final int JUNE = 6;
    public static final int SEPTEMBER = 9;
    public static final int NOVEMBER = 11;
    public static final int LEAP = 29;
    public static final int NONLEAP = 28;
    public static final int BIGMONTH = 31;
    public static final int SMALLMONTH = 30;
    public static final int ZERO = 0;
    public static final int DECEMBER = 12;


    /**
     * Date constructor method, creates the object "today"
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DATE);
        this.year = calendar.get(Calendar.YEAR);
        // Date today = new this.Date(calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE), calendar.get(Calendar.YEAR));
    }

    /**
     * creates a new date object using a string input
     * @param date String representation of a date that needs to be converted into a date object
     */
    public Date(String date) {
        String[] arrayDate = date.split("/");
        String month = arrayDate[0];
        this.month = Integer.parseInt(month);
        String day = arrayDate[1];
        this.day = Integer.parseInt(day);
        String year = arrayDate[2];
        this.year = Integer.parseInt(year);
    }

    /**
     * compares the two dates to see which one comes before the other and vice versa.
     * helps with membership expirations, class times, etc.
     * @param date the object to be compared.
     * @return 1 if today is past new date, return 0 if they are the same, return -1 if new date is after today.
     */
    @Override
    public int compareTo(Date date) {
        Calendar calendar = Calendar.getInstance();

        if (this.year < date.year) {
            return 1;
        }
        if (this.year == date.year && this.month < date.month) {
            return 1;
        }
        if (this.year == date.year && this.month == date.month && this.day < date.day) {
            return 1;
        }
        if (this.year == date.year && this.month == date.month && this.day == date.day) {
            return 0;
        }
        return -1;
    }

    /**
     * method to check if the input date is an actual date that exists in the calendar.
     * helps with verifying membership expiration, dates of birth, etc.
     * @return True if the date is a valid date that exists within the calendar, false otherwise.
     */
    public boolean isValid() {
        if (day == 0 || month == 0 || year == 0) {
            return false;
        }
        if (month == FEBRUARY && day == LEAP) {
            if (year % QUADRENNIAL != 0) {
                return false;
            }
            if (year % CENTENNIAL == 0 && year % QUATERCENTENNIAL != 0) {
                return false;
            }
            return true;
        }
        if (day < ZERO) {
            return false;
        }
        if (day > BIGMONTH) {
            return false;
        }
        if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && (!(day <= SMALLMONTH))) {
            return false;
        }
        if (month == FEBRUARY && day > NONLEAP) {
            return false;
        }
        if (month > DECEMBER || month <= 0) {
            return false;
        }
        return true;
    }
    /**
     * Getter method for other classes to get the month of the object.
     * @return the month
     */
    public int getMonth() {
        return month;
    }
    /**
     * Getter method for other classes to get the day of the object.
     * @return the day
     */
    public int getDay() {
        return day;
    }
    /**
     * Getter method for other classes to get the year of the object.
     * @return the year
     */
    public int getYear() {
        return year;
    }
    /**
     * toString method for the Date class
     * @return String representation of the date
     */
    @Override
    public String toString() {
        return (this.month + "/" + this.day + "/" + this.year);
    }
    /**
     * Helper method to calculate the members expiration dates.
     * @return new date that has been incremented by 3 months
     */
    public Date addThreeMonths() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 3);
        Date expireDate = new Date();
        return expireDate;
    }
    /**
     * Helper method that checks if a member is 18 old or older
     * @param date inputted date that usually represents a member's Date of Birth to check if they are atleast 18 years old
     * @return True if the member is of age based off the inputted date of birth, or false if they are younger than 18
     */
    public boolean eighteenOrOlder(Date date) {
        if (date.getYear() - getYear() > 18) {
            return true;
        }
        else if (date.getYear() - getYear() == 18) {
            if (date.getMonth() - getMonth() > 0) {
                return true;
            }
            else if (date.getMonth() - getMonth() < 0) {
                return false;
            }
            else {
                if (date.getDay() - getDay() < 0) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}