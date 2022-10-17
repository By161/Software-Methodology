import java.util.ArrayList;
import myPackage.Location;
/**
 * FitnessClass class that keeps track of all the gym classes available for members to sign up for
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class FitnessClass {
    private String classType;
    private String fitnessInstructor;
    private Time classTime;
    private ArrayList<Member> classList = new ArrayList<Member>(0);
    private ArrayList<Member> studentList = new ArrayList<Member>(0);
    private ArrayList<Member> guestList = new ArrayList<Member>(0);
    private Location location;

    /**
     * Constructor for the FitnessClass object
     * @param classType type of class that's being taught
     * @param instructorName the name of the fitness instructor
     * @param classStartingTime the time when the class will start
     * @param location location of where the class will be held
     */
    public FitnessClass(String classType, String instructorName, Time classStartingTime, Location location) {
        this.classType = classType;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
        this.location = location;
    }


    /**
     * Method that adds students to the list when they want to check-in
     *
     * @param member object that is meant to be added to the class
     * @return
     */
    public boolean addStudent(Member member) {
        studentList.add(member);
        return true;
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
     * Method that prints the list of students in inputted class
     */
    public void printStudentList() {
        if (this.studentList.size() > 0) {
            int arraySize = studentList.size();
            for (int i = 0; i < arraySize; i++) {
                if (studentList.size() > 1) {
                    studentList.toString();
                }
                System.out.println("empty class");
            }
        } else {
            System.out.println("class does not exist");
        }
        System.out.println("class does not exist");
    }

    /**
     * Method to remove a student from the class list if they decide they do not want to go to the class anymore
     *
     * @param cancelStudent the student that is meant to be removed
     * @return new array with updated information and the cancelled student is removed.
     */
    public boolean removeStudent(Member cancelStudent) {
        if (this.classType.equals(classType)) {
            for (int i = 0; i < studentList.size(); i++) {
                studentList.remove(cancelStudent);
                return true;
            }
        }
        return false;
    }

    /**
     * toString method to create a string representation of the FitnessClass
     * @return a string that represents the FitnessClass information in the desired format
     */
    @Override
    public String toString() {
        return classType.toUpperCase() + " - " + fitnessInstructor + ", " + Time.values() + ", " + location.values();
    }

    /**
     * Helper method that prints class information.
     */
    public void printClass() {
        String strClassType = this.classType.toUpperCase();
        System.out.println(strClassType + " - " + this.fitnessInstructor.toUpperCase() + ", " + this.classTime.getHour() + ":" + this.classTime.getMinute() + ", " + this.location.toString());
        if (studentList.size() > 0) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(0) != null) {
                    System.out.println("\t** participants **");
                    System.out.println(studentList.get(i).toString());
                }
                if (studentList.get(0) != null) {
                    System.out.println("\t** guests **");
                    System.out.println(guestList.get(i).toString());
                }
            }
            System.out.println();
        }
    }
}