import java.util.ArrayList;
import myPackage.Location;
/**
 *  FitnessClass class that keeps track of all the gym classes available for members to sign up for
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class FitnessClass {
    private String classType;
    private String fitnessInstructor;
    private Time classTime;
    private ArrayList<Member> classList;
    private ArrayList<Member> studentList;
    private Location location;
    /**
     * Constructor for the FitnessClass object
     * @param classType
     * @param instructorName
     * @param classStartingTime
     */
    public FitnessClass(String classType, String instructorName, Time classStartingTime, Location location) {
        this.classType = classType;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
        this.location = location;
    }
    /**
     * Getter method for the classType
     * @return
     */
    public String getClassType(){
        return classType;
    }
    /**
     * Method that adds students to the list when they want to check-in
     * @param member
     */
    public void addStudent(Member member){
        studentList.add(member);
    }
    public int findStudent(Member member){
        for(int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).equals(member)) {
                return i;
            }
        }
        return 0;
    }
    /**
     * Method that prints the list of students in inputted class
     */
    public void printStudentList(Member instructor) {
        if (this.fitnessInstructor.equals(instructor)) {
            int arraySize = studentList.size();
            for (int i = 0; i < arraySize; i++) {
                if (studentList.size() > 1){
                    studentList.toString();
                }
                System.out.println ("empty class");
            }
        } else {
            System.out.println("class does not exist");
        }
        System.out.println("class does not exist");
    }
    /**
     * Method to remove a student from the class list if they decide they do not want to go to the class anymore
     * @param cancelStudent
     * @return new array with updated information and the cancelled student is removed.
     */
    public String removeStudent (Member cancelStudent) {
        if (this.classType.equals(classType)) {
            for (int i = 0; i < studentList.size(); i++) {
                studentList.remove(cancelStudent);
            }
        }
        return cancelStudent.getFirstName() + " " + cancelStudent.getLastName() +" is not a participant in " + classType;
    }
    @Override
    public String toString(){
        return classType.toUpperCase() + " - " + fitnessInstructor + ", " + Time.values() + ", " + location.values();
    }
}