package com.example.project3;

import myPackage.Date;
import myPackage.Location;
/**
 * required class to make the Family membership type object
 * @author Anna Kryzanekas, Brandon Yuen
 */

public class Family extends Member{

    public int numFamGuestPasses; //decrease number every time you check in a guest


    /**
     * Creates a new instance of Member.
     * @param firstName the first name of a member.
     * @param lastName  the last name of a member.
     * @param dob       the date of birth of a member.
     * @param location  the member's gym location including town, county, and zip code.
     */
    public Family(String firstName, String lastName, String dob, Date expire, Location location) {
        super(firstName, lastName, dob, expire, location); //invoke the superclass constructor
        this.numFamGuestPasses = 1;
    }

    /**
     * Polymorphism method that returns the membership fee for a family type member
     * @return the membership fee for a family type member
     */
    @Override
    public double membershipFee() {
        return 209.96;
    }

    /**
     * toString method to show the information of the family membership member
     * @return a string representation of the family membership member
     */
    @Override
    public String toString() {
        return super.toString() + ", (Family) guest-pass remaining: " + numFamGuestPasses;
    }

    /**
     * Getter method for the number of guest passes the Family membership member has
     * @return the number of guest passes the member has
     */
    public int getNumFamGuestPasses(){
        return this.numFamGuestPasses;
    }

    /**
     * Increments the amount of guest passes the member has
     */
    public void incNumFamGuestPasses(){
        this.numFamGuestPasses++;
    }

    /**
     * Decrements the amount of guest passes the member has
     */
    public void decNumFamGuestPasses(){
        this.numFamGuestPasses--;
    }

}
