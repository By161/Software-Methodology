package com.example.project_4;

/**
 * Required class to create a crust object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Crust {
    String crust;

    /**
     * Constructor for the crust object
     * @param crust inputted type of crust
     */
    public Crust (String crust){
        this.crust = crust;
    }

    /**
     * Getter method for the type of crust
     * @return the type of crust
     */
    public String getCrust(){
        return this.crust;
    }

    /**
     * toString method to show the crust
     * @return string that represents the crust
     */
    public String toString(){
        return this.crust;
    }
}
