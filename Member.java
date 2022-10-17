import java.util.Calendar;
import myPackage.Date;
import myPackage.Location;
/** This class creates and implements a Gym Member's objects.
 * Available information of a member includes first name, last name, date of birth,
 * membership expiration date, and the member's gym location.
 * @author Anna Kryzanekas, Brandon Yuen
 */
public class Member implements Comparable<Member> {

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;

    public static final int ADD_3_MONTHS = 3;

    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**
     * Creates a new instance of Member.
     *
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Member(String firstName, String lastName, String dob, Date Expire, String location) {
        this.fname = firstName;
        this.lname = lastName;
        this.dob = new Date(dob);
        this.expire = Expire;

        if (location.equalsIgnoreCase("Somerville")) {
            this.location = Location.SOMERVILLE;
        } else if (location.equalsIgnoreCase("Bridgewater")) {
            this.location = Location.BRIDGEWATER;
        } else if (location.equalsIgnoreCase("Franklin")) {
            this.location = Location.FRANKLIN;
        } else if (location.equalsIgnoreCase("Edison")) {
            this.location = Location.EDISON;
        } else if (location.equalsIgnoreCase("Piscataway")) {
            this.location = Location.PISCATAWAY;
        }
    }

    /**
     * Returns the first name.
     * @return the first name of the current member.
     */
    public String getFirstName() {
        return fname;
    }

    /**
     * Returns the last name.
     * @return the last name of the current member.
     */
    public String getLastName() {
        return lname;
    }

    /**
     * Returns the date of birth.
     * @return the date of birth of the member.
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Returns the expiration date.
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
     * Returns the location.
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
     * Membership fee of a standard member
     * @return
     */
    public double membershipFee() {
        return 149.96;
    }
}

    /**
     * This is the testbed main method for the Member class.
     * @param args input used for testing.
     */
//    public static void main(String[] args) {
//        Member testMember = new Member("Anna", "Kryzanekas","12/14/2000", "Piscataway");
//
//        Member test1 = new Member("Anna", "Kryzanekas","12/14/2000", "Piscataway");
//        Member test2 = new Member("anna", "kryzanekas","12/14/2000","Piscataway");
//        Member test3 = new Member("Anna", "Kryzanekas","12/14/2001","Piscataway");
//        Member test4 = new Member("Eric", "Kryzanekas", "11/02/1996","Franklin");
//        Member test5 = new Member("Shraya", "Chintalapudi", "06/14/2001", "Bridgewater");
//        Member test6 = new Member("John", "Waters", "05/05/2002", "Somerville");
//        Member test7 = new Member("Katherine", "Voynarovskiy", "12/25/1990", "Somerville");
//        Member test8 = new Member("Anna", "Apple","12/15/2000","Middlesex");
//        Member test9 = new Member("Daniel", "Smith","09/17/1993", "Piscataway");
//        Member test10 = new Member("Anna", "Walters","07/24/1999", "Franklin");
//
//        System.out.println("The following 10 test cases test for the Member class.");
//
//        System.out.println("Test Case 1 should return 0.");
//        System.out.println("Test Case 1: " + testMember.compareTo(test1)); //Same person
//        System.out.println("Test Case 2 should return 0.");
//        System.out.println("Test Case 2: " + testMember.compareTo(test2)); //Same person but lowercase
//        System.out.println("Test Case 3 should return -1.");
//        System.out.println("Test Case 3: " + testMember.compareTo(test3)); //Same name but different birthdate
//        System.out.println("Test Case 4 should return -1.");
//        System.out.println("Test Case 4: " + testMember.compareTo(test4)); //Same last name but different first name
//        System.out.println("Test Case 5 should return 1.");
//        System.out.println("Test Case 5: " + testMember.compareTo(test5)); //Different last name and first name
//        System.out.println("Test Case 6 should return -1.");
//        System.out.println("Test Case 6: " + testMember.compareTo(test6)); //Different last name and first name
//        System.out.println("Test Case 7 should return -1.");
//        System.out.println("Test Case 7: " + testMember.compareTo(test7)); //Different last name and first name
//        System.out.println("Test Case 8 should return 1.");
//        System.out.println("Test Case 8: " + testMember.compareTo(test8)); //Same first name but different last name
//        System.out.println("Test Case 9 should return -1.");
//        System.out.println("Test Case 9: " + testMember.compareTo(test9)); //Different last name and first name
//        System.out.println("Test Case 10 should return -1.");
//        System.out.println("Test Case 10: " + testMember.compareTo(test10)); //Same first name but different last name
//    }
//}