import java.io.FileNotFoundException;

/**
 * Class that runs project 2
 * Calls the gym manager class and run method inside that class
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class RunProject2 {
    /**
     * Calls the run method within the GymManager class
     * Runs all of project 2
     * @param args
     */
    public static void main (String[] args) throws FileNotFoundException {
        new GymManager().run();
    }
}
