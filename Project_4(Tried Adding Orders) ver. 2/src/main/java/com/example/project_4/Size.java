package com.example.project_4;

public class Size {
    String size;
    public Size(String size){
        this.size = size;
    }
    public String getSize(){
        return this.size;
    }
    public void setSize(String input){
        this.size = input;
    }
    public boolean equals(String input){
        if (input.equals(this.size)){
            return true;
        }
        else{
            return false;
        }
    }
}
