import java.util.Calendar;
import myPackage.Date;

public class Premium extends Family {

    public int numPremGuestPasses = 3; //decrease number every time you check in a guest

    /**
     * Creates a new instance of Member.
     *
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Premium(String firstName, String lastName, String dob, String location) {
        super(firstName, lastName, dob, location); //invoke the superclass constructor
    }

    /**
     * Returns the expiration date.
     * @return the current member's expiration date of the membership.
     */
    @Override
    public Date getExpire() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        return expire;
    }

    /**
     *
     * @return
     */
    @Override
    public double membershipFee() {
        return 659.89;
    }

    /**
     *
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
