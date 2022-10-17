import myPackage.Date;
import org.junit.Test;

import static myPackage.Location.BRIDGEWATER;
import static org.junit.Assert.*;

/**
 * Testing class for fitnessClass adding and removing
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class FitnessClassTest {

    @Test
    public void addStudent() {
    }
    @Test
    /**
     * Tests if you can add a student to a fitness class
     */
    public void adding_Student(){
        Member newMember = new Member ("Brandon", "Yuen", "5/5/2000", new Date("10/20/2025"), BRIDGEWATER);
        FitnessClass newClass = new FitnessClass("Lily", "Chang", Time.AFTERNOON, BRIDGEWATER);
        boolean expectedResult = true;
        boolean actualResult = newClass.addStudent(newMember);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    /**
     * Tests if you can remove a student from a fitness class
     * in this case, you cannot because the member was never added in the first place.
     */
    public void remove_student(){
        Member newMember = new Member ("Brandon", "Yuen", "5/5/2000", new Date("10/20/2025"), BRIDGEWATER);
        FitnessClass newClass = new FitnessClass("Lily", "Chang", Time.AFTERNOON, BRIDGEWATER);
        boolean expectedResult = false;
        boolean actualResult = newClass.removeStudent(newMember);
        assertEquals(expectedResult, actualResult);
    }
}