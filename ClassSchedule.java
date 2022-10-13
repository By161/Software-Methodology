import myPackage.Date;
import myPackage.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClassSchedule extends GymManager {

    private FitnessClass[] classes;
    private int numClasses;


    public ClassSchedule(){
        numClasses = 0;
    }

    public void printClasses(){
        for(int i = 0; i < classes.length; i++){
            classes[i].toString();
        }
    }
    public boolean addClass(FitnessClass newClass){
        FitnessClass[] tempList = new FitnessClass[numClasses++];
        if (classes[numClasses - 1] != null) {
            for (int i = 0; i < numClasses; i++) {
                tempList[i] = classes[i];
            }
            classes = tempList;
            numClasses++;
            return true;
        }
        return false;
    }
    public int getSize(){
        return numClasses;
    }
    public FitnessClass getClass(){
        return classes;
    }

}
