package com.example.project3;

import myPackage.Date;
import myPackage.Location;
import java.util.Calendar;

/**
 * Required Premium class that makes an object to represent the Premium version of a membership
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Premium extends Member {

    private int numPremGuestPasses; //decrease number every time you check in a guest
    private static int ADD_ONE_YEAR = 1;

    /**
     * Creates a new instance of Member.
     *
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param expire    the date of when the member's membership expires
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Premium(String firstName, String lastName, String dob, Date expire, Location location) {
        super(firstName, lastName, dob, expire, location); //invoke the superclass constructor
        this.numPremGuestPasses=3;
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
     * Override method to show the membership fee
     * @return membership fee for this type of membership
     */
    @Override
    public double membershipFee() {
        return 659.89;
    }

    /**
     * toString method for premium membership to help represent their information
     * @return string representation of premium membership
     */
    @Override
    public String toString() {
        return super.toString() + ", (Premium) guest-pass remaining: " + numPremGuestPasses;
    }

    /**
     * Getter method for the amount of premium guest passes the member has
     * @return int number of guest passes the member has
     */
    public int getNumPremGuestPasses(){
        return this.numPremGuestPasses;
    }

    /**
     * Increment the number of guest passes the member has
     */
    public void incNumPremGuestPasses(){
        this.numPremGuestPasses++;
    }

    /**
     * Decrement the amount of guest passes the member has
     */
    public void decNumPremGuestPasses(){
        this.numPremGuestPasses--;
    }

}
