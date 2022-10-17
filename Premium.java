import myPackage.Date;

import java.util.Calendar;

public class Premium extends Family {

    private int numPremGuestPasses = 3; //decrease number every time you check in a guest
    private int ADD_ONE_YEAR = 1;

    /**
     * Creates a new instance of Member.
     *
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param expire
     * @param location  the member's gym location including town, county, and zip code.
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
