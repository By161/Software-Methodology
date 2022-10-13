import java.util.ArrayList;
/**
 *  FitnessClass class that keeps track of all the gym classes available for members to sign up for
 *  @author Brandon Yuen
 */
public class FitnessClass {
    private String classType;
    private Member fitnessInstructor;
    private Time classTime;
    private MemberDatabase classList;
    /**
     * Constructor for the FitnessClass object
     * @param classType
     * @param instructorName
     * @param classStartingTime
     */
    public FitnessClass(String classType, Member instructorName, Time classStartingTime) {
        this.classType = classType;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
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
        classList.add(member);
    }
    public int findStudent(Member member){
        return this.classList.find(member);
    }
    /**
     * Method that prints the list of students in inputted class
     */
    public void printStudentList(Member instructor) {
        if (this.fitnessInstructor.equals(instructor)) {
            int arraySize = classList.getSize();
            for (int i = 0; i < arraySize; i++) {
                if (classList.getSize() > 1){
                    classList.print();
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
            for (int i = 0; i < classList.getSize(); i++) {
                classList.remove(cancelStudent);
            }
        }
        return cancelStudent.getfname() + " " + cancelStudent.getlname() +" is not a participant in " + classType;
    }
}