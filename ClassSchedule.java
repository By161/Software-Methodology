/**
 * Required class that makes the ClassSchedule object to keep track of all the classes being held at the gym
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ClassSchedule {
    private FitnessClass[] classes;
    private int numClasses;

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
    public void printSchedule(){
        for (int i = 0; i < numClasses; i++){
            classes[i].printClass();
        }
    }
    private int find(FitnessClass classFromData) {
        for (int i = 0; i < this.numClasses; ++i) {
            if (this.classes[i] != null && this.classes[i].equals(classFromData)) {
                return i;
            }
        }
        return -1;
    }
    public boolean hasClass(FitnessClass fitnessClass){
        for (int i =0; i < numClasses; i++){
            if (classes[i].equals(fitnessClass));
            return true;
        }
        return false;
    }

    public FitnessClass findClass(FitnessClass classFromData) {
        int indexOfClass = find(classFromData);
        if (indexOfClass != -1) {
            FitnessClass actualClass = classes[indexOfClass];
            return actualClass;
        }
        else {
            return null;
        }
    }
    public FitnessClass[] getClasses () {
        return classes;
    }
    public int getNumClasses () {
        return numClasses;
    }
    public FitnessClass getClass(FitnessClass fitnessClass){
        for (int i =0; i < numClasses; i++){
            if (classes[i].equals(fitnessClass));
            return classes[i];
        }
        return null;
    }
    public void print() {
        if (this.classes[0] == null) {
            System.out.println("no classes");
        } else {
            System.out.println();
            System.out.println("- list of classes -");

            for(int i = 0; i < this.numClasses && this.classes[i] != null; i++) {
                this.classes[i].printClass();
            }
            System.out.println("- end of list -");
            System.out.println();
        }
    }
}
