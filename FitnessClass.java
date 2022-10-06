/**
 *  FitnessClass class that keeps track of all the gym classes available for members to sign up for
 *  @author Brandon Yuen, Kathan Patelhan Patel
 */

public class FitnessClass {
    private String classType;
    private String fitnessInstructor;
    private Time classTime;
    private Member[] classList = new Member[1];
    private int size = classList.length;

    /**
     * Constructor for the FitnessClass object
     * @param type
     * @param instructorName
     * @param classStartingTime
     */
    public FitnessClass(String type, String instructorName, Time classStartingTime) {
        this.classType = type;
        this.fitnessInstructor = instructorName;
        this.classTime = classStartingTime;
    }


    /**
     * Method that adds students to the list when they want to check-in
     * @param newStudent
     */
    public void addStudent(String classType, Member newStudent){
        Member[] newClassList = new Member[size++];
        newClassList[size] = newStudent;
        classList = newClassList;
    }

    /**
     *
     * @param className
     */
    public String printStudentList(String className) {
        if (this.classType.equals(className)) {
            int arraySize = classList.length;
            for (int i = 0; i < arraySize; i++) {
                if (classList.length > 1){
                    return classList[i].toString();
                }
                return "empty class";
            }
        } else {
            return ("class does not exist");
        }
        return ("class does not exist");
    }


    public void setClassTime(Time classTime){
        this.classTime = classTime;
    }

    /**
     * method to remove a student from the class list if they decide they do not want to go to the class anymore
     * @param cancelStudent
     * @return new array with updated information and the cancelled student is removed.
     */
    public Member[] removeStudent (String classType, Member cancelStudent){
        Member[] updatedClassList = new Member[size--];
        if (this.classType.equals(classType)){
            int size = classList.length;
            for (int i = 0; i < classList.length; i++){
                if (cancelStudent.equals(classList[i])){
                    for(int a = 0; a < size; a++) {
                        int pointer = 0;
                        updatedClassList[a] = classList[pointer];
                    }
                    return updatedClassList;
                }
            }
        }
        return updatedClassList;
    }
    /**
     * toString method for fitness class
     * @return string(s) that shows the type of class, instructor name, class time, the members who signed up, etc.
     */
    @Override
    public String toString(){
        return classType + " - " + fitnessInstructor + " " + classTime.toString() + "\n" + "**participants**" + "\n" + printStudentList(classType);
    }
}