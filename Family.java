import myPackage.Date;
/**
 * required class to make the Family membership type object
 * @author Anna Kryzanekas, Brandon Yuen
 */

public class Family extends Member{

    public int numFamGuestPasses = 1; //decrease number every time you check in a guest


    /**
     * Creates a new instance of Member.
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Family(String firstName, String lastName, String dob, Date expire, String location) {
        super(firstName, lastName, dob, expire, location); //invoke the superclass constructor
        this.numFamGuestPasses = 1;
    }

    @Override
    public double membershipFee() {
        return 209.96;
    }

    /**
     * toString method to show the information of the family membership member
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + ", (Family) guest-pass remaining: " + numFamGuestPasses;
    }

    //Any location
    //1 guest pass - only for membership location





}
