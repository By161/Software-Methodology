package com.example.project_4;

/**
 * Required class for the size of the pizza
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Size {
    String size;

    /**
     * Constructor for a size object
     * @param size the size
     */
    public Size(String size){
        this.size = size;
    }

    /**
     * Getter method for the size
     * @return the size
     */
    public String getSize(){
        return this.size;
    }

    /**
     * Setter method for the size
     * @param input the new size to be set
     */
    public void setSize(String input){
        this.size = input;
    }

    /**
     * Helper method to check if sizes are the same
     * @param input the compared input to see if the size is equal
     * @return true if the sizes are the same, false otherwise
     */
    public boolean equals(String input){
        if (input.equals(this.size)){
            return true;
        }
        else{
            return false;
        }
    }
}
