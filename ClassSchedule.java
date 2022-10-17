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
    public void printSchedule(){
        if (numClasses == 0){
            System.out.println("Fitness class schedule is empty.");
        }
        for (int i = 0; i < numClasses; i++){
            classes[i].printClass();
        }
    }

    /**
     * Helper method that finds the inputted FitnessClass within the class schedule.
     * @param classFromData
     * @return index of the inputted FitnessClass within the class schedule.
     */
    private int find(FitnessClass classFromData) {
        for (int i = 0; i < this.numClasses; ++i) {
            if (this.classes[i] != null && this.classes[i].equals(classFromData)) {
                return i;
            }
        }
        return -1;
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
}
