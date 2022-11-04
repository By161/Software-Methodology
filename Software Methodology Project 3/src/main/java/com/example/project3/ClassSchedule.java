package com.example.project3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import myPackage.Location;

/**
 * Required class that makes the ClassSchedule object to keep track of all the classes being held at the gym
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ClassSchedule {
    private FitnessClass[] classes;
    private int numClasses;

    /**
     * ClassSchedule object constructor
     */
    public ClassSchedule() {
        numClasses = 0;
        classes = new FitnessClass[numClasses];
    }

    /**
     * Helper method to load schedule from text file
     * @throws FileNotFoundException checked exception in Java that occurs when an attempt to open a file denoted by a specified pathname fails
     * @throws URISyntaxException Constructs an instance from the given input string and reason
     */
    public void loadSchedule () throws FileNotFoundException, URISyntaxException {
        URI url = getClass().getResource("classSchedule.txt").toURI();
        File file = new File(url.getPath()); //file path
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() < 1) {
                continue;
            }
            String[] processedInput = line.split(" ");
            String classType = processedInput[0];
            String instructor = processedInput[1];
            String time = processedInput[2];
            Location location = Location.valueOf(processedInput[3].toUpperCase());
            FitnessClass newClass = new FitnessClass(classType, instructor, Time.valueOf(time.toUpperCase()), location);
            this.addClass(newClass);
        }
    }

    /**
     * Helper method to add a class to the schedule
     * @param newClass class that is meant to be added to the schedule
     */
    public void addClass(FitnessClass newClass) {
        FitnessClass[] tempClasses = new FitnessClass[numClasses + 1];
        tempClasses[numClasses] = newClass;
        for (int i = 0; i < numClasses; i++) {
            tempClasses[i] = classes[i];
        }
        classes = tempClasses;
        numClasses++;
    }

    /**
     * Helper method that prints the class schedule
     */
    public String printSchedule(){
        String out = "";
        if (numClasses == 0){
            return "Fitness class schedule is empty\n";
        }
        for (int i = 0; i < numClasses; i++){
            out += classes[i].printClass();
        }
        return out;
    }
    /**
     * Helper method that checks if the schedule has the inputted FitnessClass within today's schedule
     * @param fitnessClass
     * @return true if inputted FitnessClass is within the schedule, or false if it is not in the schedule
     */
    public boolean hasClass(FitnessClass fitnessClass){
        for (int i =0; i < numClasses; i++){
            if (classes[i].equals(fitnessClass));
            return true;
        }
        return false;
    }

    /**
     * Getter method for the inputted class within the schedule
     * @param fitnessClass
     * @return the desired class from the schedule
     */
    public FitnessClass getClass(FitnessClass fitnessClass){
        for (int i =0; i < numClasses; i++){
            if (classes[i].equals(fitnessClass));
            return classes[i];
        }
        return null;
    }

    /**
     * Getter method for the schedule
     * @return schedule of classes
     */
    public FitnessClass[] getClasses(){
        return this.classes;
    }

    /**
     * Getter method for the number of classes in the schedule
     * @return int amount of classes in schedule
     */
    public int getNumClasses(){
        return this.numClasses;
    }
}
