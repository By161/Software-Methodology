import java.io.FileNotFoundException;

/**
 * Class that runs project 2
 * Calls the gym manager class and run method inside that class
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class RunProject2 {
    /**
     * Driver class that runs project 2
     * @param args all the user inputs
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed.
     */
    public static void main (String[] args) throws FileNotFoundException {
        new GymManager().run();
    }
}
