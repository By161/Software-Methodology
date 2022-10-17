/**
 *  The required enum class for Time
 *  This class shows the possible times and their constants that identify them.
 * @author Brandon Yuen, Anna Kryzanekas
 */

public enum Time {
    MORNING(9,"30"),
    AFTERNOON(14,"00"),
    EVENING(18,"30");


    private final int hour;
    private final String minute;

    /**
     * Time constructor class.
     * Creates an object called Time which helps identify what time the member is signed up for.
     * @param hour
     * @param minute
     */
    Time(int hour, String minute){
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Getter method for hour
     * @return the hour
     */
    public int getHour(){
        return this.hour;
    }

    /**
     * Getter method for minute
     * @return the minute
     */
    public String getMinute(){
        return this.minute;
    }
}
