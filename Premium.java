import java.util.Calendar;
import myPackage.Date;

/**
 * required class to make the Premium membership object
* @author Anna Kryzanekas, Brandon Yuen
 */
public class Premium extends Family {
    private int numPremGuestPasses = 3; //decrease number every time you check in a guest
    private int ADD_ONE_YEAR = 1;

    /**
     * Premium member constructor
     * @param firstName
     * @param lastName
     * @param dob
     * @param expire
     * @param location
     */
    public Premium(String firstName, String lastName, String dob, Date expire, String location) {
        super(firstName, lastName, dob, expire, location); //invoke the superclass constructor
    }

    /**
     * Returns the expiration date.
     * @return the current member's expiration date of the membership.
     */
    @Override
    public Date getExpire() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, ADD_ONE_YEAR);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        return expire;
    }

    /**
     * Method for membership fee of a premium member
     * @return
     */
    @Override
    public double membershipFee() {
        return 659.89;
    }

    /**
     * toString method to show the data of the premium member
     * @return
     */
    @Override
    public String toString() {
        Date todayDate = new Date();
        return super.toString() + ", (Premium) guest-pass remaining: " + numPremGuestPasses;
        // later problem
    }

    //Any location
    // 3 guest passes - only for 1 location
}
