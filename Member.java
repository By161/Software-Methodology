import java.util.Calendar;
import myPackage.Date;
import myPackage.Location;
/** This class creates and implements a Gym Member's objects.
 * Available information of a member includes first name, last name, date of birth,
 * membership expiration date, and the member's gym location.
 * @author Anna Kryzanekas, Brandon Yuen
 */
public class Member implements Comparable<Member> {
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**
     * Creates a new instance of Member.
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Member(String firstName, String lastName, String dob, Date Expire, Location location) {
        this.fname = firstName;
        this.lname = lastName;
        this.dob = new Date(dob);
        this.expire = Expire;
        this.location = location;
    }
    /**
     * Getter method for the first name.
     * @return the first name of the current member.
     */
    public String getFirstName() {
        return fname;
    }

    /**
     * Getter method for the last name.
     * @return the last name of the current member.
     */
    public String getLastName() {
        return lname;
    }

    /**
     * Getter method for the date of birth.
     * @return the date of birth of the member.
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Getter method for the expiration date.
     * @return the current member's expiration date of the membership.
     */
    public Date getExpire() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        return expire;
    }

    /**
     * Getter method for the location.
     * @return the location of the member's gym specified by town,county, and zip code.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns a textual representation of a member.
     * @return a String value that can be printed.
     */
    @Override
    public String toString() {
        Date todayDate = new Date();
        return fname + " " + lname + ", " + "DOB: " + dob + ", " + "Membership expires " + getExpire() + ", "
                + "Location: " + location + ", " + location.getZipcode() + ", " + location.getCounty();
    }

    /**
     * Compares the current gym member with an inputted member by checking first name, last name, and date
     * of birth to see if they are the same members.
     * @param obj object of member.
     * @return true if the members are the same and false if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        Member member = (Member) obj;
        if (member.getFirstName().equalsIgnoreCase(fname) && member.getLastName().equalsIgnoreCase(lname)
                && member.getDob().compareTo(dob) == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Compares the current gym member with an inputted member sorted by last name and then first name.
     * Date of birth is also checked if last name and first name are the same to see if the members are
     * the same person.
     * @param member the object to be compared to an inputted member.
     * @return -1 if inputted member is sorted before current member, 1 if the inputted date is sorted
     * after the current member, and 0 if the members are the same.
     */
    @Override
    public int compareTo(Member member) {
        if (lname.toLowerCase().compareTo(member.getLastName().toLowerCase()) > 0) {
            return 1;
        } else if (lname.toLowerCase().compareTo(member.getLastName().toLowerCase()) < 0) {
            return -1;
        } else {
            if (fname.toLowerCase().compareTo(member.getFirstName().toLowerCase()) > 0) {
                return 1;
            } else if (fname.toLowerCase().compareTo(member.getFirstName().toLowerCase()) < 0) {
                return -1;
            } else {
                if (dob.compareTo(member.getDob()) > 0) {
                    return 1;
                } else if (dob.compareTo(member.getDob()) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    /**
     * polymorphism method to show the fee of a standard member
     * @return membership fee for a standard member
     */
    public double membershipFee() {
        return 149.96;
    }
}


