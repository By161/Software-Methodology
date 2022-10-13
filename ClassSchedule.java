public class ClassSchedule {

    private FitnessClass[] classes;
    private int numClasses;


    public ClassSchedule(FitnessClass[] classes, int numClasses){
        this.classes = classes;
        this.numClasses = numClasses;
    }

    public void printClasses(){
        for(int i = 0; i < classes.length; i++){
            System.out.println(classes[i]);
        }
    }



}
