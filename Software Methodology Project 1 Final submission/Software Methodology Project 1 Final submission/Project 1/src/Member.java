import myPackage.Date;
import myPackage.Location;

/**
 *  Member class
 *  creates an object for the gym members to hold all their relevant information
 *  @author @author Brandon Yuen, Kathan Patelhan Patel
 */
public class Member implements Comparable<Member> {
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**
     * Member constructor
     * Creates an object that represents all members
     * @param fname
     * @param lname
     * @param dob
     * @param expire
     * @param location
     */
    public Member(String fname, String lname, Date dob, Date expire, Location location) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }

    /**
     * Getter method for fname of the member
     * @return fname of the member
     */
    public String getfname() {
        return this.fname;
    }

    /**
     * Getter method for lname of the member
     * @return lname of the member
     */
    public String getlname() {
        return this.lname;
    }

    /**
     * Getter method for date of birth of the member
     * @return String of the date of birth of the member
     */
    public Date getdob() {
        return this.dob;
    }

    /**
     * Getter method for date of when the membership expiration date
     * @return String of the date of when the membership expires
     */
    public Date getexpire() {
        return this.expire;
    }

    /**
     * Getter method for the location of the gym the member is at
     * @return location of the gym the member goes to
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Convert the member class to a string, describing all the elements of the member
     * class.
     * @return string represents all elements of Member.
     */

    @Override
    public String toString() {
        return this.fname + " " + this.lname + ", DOB:" + this.dob.toString() + ", Membership expires " + this.expire.toString() + ", Location: " + location.toString();
    }

    @Override
    /**
     * Method to check if two first name and last name are equal.
     * if the string fname and lname inputs are similar then the class returns true.
     * @param obj Object type input obj
     * @return true, if the names are similar. False otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Member))
            return false;

        Member objMember = (Member) obj;

        return this.fname.equals(objMember.fname)
                && this.lname.equals(objMember.lname);
    }

    /**
     * Compares the members based off their names, sees which one goes before or after in alphabetical order
     * @param member the object to be compared.
     * @return 1 if the member comes before, -1 if member comes after, 0 if they have the same name
     */
    @Override
    public int compareTo(Member member) {
        if (member.lname.toLowerCase().equals(this.lname.toLowerCase())) {// if they have the same last name
            if (member.fname.toLowerCase().compareTo(this.fname.toLowerCase()) > 0) {
                return 1;
            }
            if (member.fname.toLowerCase().compareTo(this.fname.toLowerCase()) < 0) {
                return -1;
            } else return 0;
        }
        if (member.lname.toLowerCase().compareTo(this.lname.toLowerCase()) > 0) {// if they don't have the same last name.
            return 1;
        }
        return -1;
    }
}

