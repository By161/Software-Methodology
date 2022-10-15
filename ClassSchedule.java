///**
// * Required ClassSchedule class to make the schedule object that keeps track of all the gym classes happening at the time.
// * @author Brandon Yuen, Anna Kryzanekas
// */
//public class ClassSchedule extends GymManager {
//
//    private FitnessClass[] classes;
//    private int numClasses;
//
//    /**
//     * Constructor method to create the ClassSchedule object
//     */
//    public ClassSchedule(){
//        classes = null;
//        numClasses = 0;
//    }
//
//    /**
//     * Helper method that returns all the classes within the schedule "database" to print in the gym manager class.
//     */
//    public void printClasses(){
//        for(int i = 0; i < classes.length; i++){
//            classes[i].toString();
//        }
//    }
//    /**
//     * Helper method that adds the classes to the schedule when loading the class schedule file.
//     * @param fitnessclass
//     * @return
//     */
//    public boolean addClass(FitnessClass fitnessclass){
//        if (classes[numClasses - 1] != null) {
//            for (int i = 0; i < numClasses; i++) {
//                if (classes[i] == null){
//                    classes[i] = fitnessclass;
//                }
//            }
//            classes = new FitnessClass[numClasses++];
//            return true;
//        }
//        return false;
//    }
//    /**
//     * Helper method that checks if the inputted class exists within the schedule.
//     * @param fitnessClass
//     * @return
//     */
//    public boolean hasClass(FitnessClass fitnessClass){
//        for (int i =0; i < numClasses; i++){
//            if (classes[i].equals(fitnessClass));
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * Helper method that returns the inputted class for easier access from the GymManager class
//     * @param fitnessClass
//     * @return
//     */
//    public FitnessClass getClass(FitnessClass fitnessClass){
//        for (int i =0; i < numClasses; i++){
//            if (classes[i].equals(fitnessClass));
//            return classes[i];
//        }
//        return null;
//    }
//}
