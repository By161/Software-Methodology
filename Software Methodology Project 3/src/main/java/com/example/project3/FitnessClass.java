package com.example.project3;

import java.util.ArrayList;
import myPackage.Location;

/**
 * FitnessClass class that keeps track of all the gym classes available for
 * members to sign up for
 * 
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class FitnessClass {
    private String classType;
    private String fitnessInstructor;
    private Time classTime;
    private ArrayList<Member> studentList;
    private ArrayList<Member> guestList;
    private Location location;

    /**
     * Constructor for the FitnessClass object
     * @param classType         type of class that's being taught
     * @param instructorName    the name of the fitness instructor
     * @param classStartingTime the time when the class will start
     * @param location          location of where the class will be held
     */
    public FitnessClass(String classType, String instructorName, Time classStartingTime, Location location) {
        this.classType = classType;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
        this.location = location;
        this.studentList = new ArrayList<Member>();
        this.guestList = new ArrayList<Member>();
    }

    /**
     * Method that adds students to the list when they want to check-in
     *
     * @param member object that is meant to be added to the class
     * @return
     */
    public boolean addStudent(Member member) {
        return studentList.add(member);
    }

    public boolean containsStudent(Member member){
        return studentList.contains(member);
    }

    /**
     * Method that adds guest to the list when they want to check-in
     *
     * @param member object that is meant to be added to the class
     * @return
     */
    public boolean addGuest(Member member) {
        return guestList.add(member);
    }

    /**
     * Helper method that finds the inputted student within the student "database"
     * @param member inputted member that needs to be found
     * @return the index of the member inside the "database"
     */
    public int findStudent(Member member) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equals(member)) {
                return i;
            }
        }
        return 0;
    }
    /**
     * Method to remove a student from the class list if they decide they do not
     * want to go to the class anymore
     * @param cancelStudent the student that is meant to be removed
     * @return new array with updated information and the cancelled student is
     * removed.
     */
    public boolean removeStudent(Member cancelStudent) {
        return studentList.remove(cancelStudent);
    }
    
    /**
     * Method to remove a student from the class list if they decide they do not
     * want to go to the class anymore
     * @param cancelGuest the student that is meant to be removed
     * @return new array with updated information and the cancelled student is
     * removed.
     */
    public boolean removeGuest(Member cancelGuest) {
        return this.guestList.remove(cancelGuest);
        
    }
    /**
     * toString method to create a string representation of the FitnessClass
     * @return a string that represents the FitnessClass information in the desired
     * format
     */
    @Override
    public String toString() {
        return classType.toUpperCase() + " - " + fitnessInstructor + ", " + Time.values() + ", " + location.values();
    }

    /**
     * Helper method that prints class information.
     */
    public String printClass() {
        String out = "";
        String strClassType = this.classType.toUpperCase();
        out += strClassType + " - " + this.fitnessInstructor.toUpperCase() + ", " + this.classTime.getHour() + ":"
                + this.classTime.getMinute() + ", " + this.location.toString() + "\n";
        if (studentList.size() > 0) {
            out += "\t** participants **\n";
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(0) != null) {
                    out += studentList.get(i).toString() + "\n";
                }
            }
        }
        if (guestList.size() > 0) {
            out += "\t** guests **\n";
            for (int i = 0; i < guestList.size(); i++) {
                if (guestList.get(0) != null) {
                    out += guestList.get(i).toString() + "\n";
                }
            }
        }
        return out;
    }

    /**
     * Getter method for class type
     * @return class type
     */
    public String getClassType(){
        return this.classType;
    }

    /**
     * Getter method for fitness instructor
     * @return name of fitness instructor
     */
    public String getFitnessInstructor(){
        return this.fitnessInstructor;
    }

    /**
     * Getter method for location
     * @return name of location
     */
    public String getLocationString(){
        return this.location.toString();
    }
}