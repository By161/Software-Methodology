/**
 *  The required enum class for Time
 *  This class shows the possible times and their constants that identify them.
 *  @author Brandon Yuen
 */

public enum Time {
    MORNING(9,30),
    AFTERNOON(14,00),
    EVENING(18,30);


    private final int hour;
    private final int minute;

    /**
     * Time constructor class.
     * Creates an object called Time which helps identify what time the member is signed up for.
     * @param hour
     * @param minute
     */
    Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}
