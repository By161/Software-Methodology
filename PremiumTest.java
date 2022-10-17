import myPackage.Date;
import org.junit.Test;
import static myPackage.Location.BRIDGEWATER;
import static org.junit.Assert.*;

/**
 * Testing class for Premium class and its membership
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class PremiumTest {

    @Test
    /**
     * Checks if the membership fee is correct
     */
    public void membershipFee() {
    }
    public void check_Premium_Membership_Fee(){
        Premium member = new Premium ("Brandon", "Yuen", "5/5/2000", new Date("10/20/2025"), BRIDGEWATER);
        assertTrue(member.membershipFee() == 659.89);
        boolean expectedOutput = true;
        boolean actualOutput = (659.89 == member.membershipFee());
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    /**
     * Checks if the membership fee is incorrect
     */
    public void not_Premium_Membership_Fee(){
        Premium member = new Premium ("Brandon", "Yuen", "5/5/2000", new Date("10/20/2025"), BRIDGEWATER);
        assertFalse(member.membershipFee() == 700);
        boolean expectedOutput = false;
        boolean actualOutput = (700 == member.membershipFee());
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    /**
     * Checks if the inheritance/polymorphism is correct
     */
    public void check_polymorphism(){
        Member newMember = new Premium ("Brandon", "Yuen", "5/5/2000", new Date("10/20/2025"), BRIDGEWATER);
        assertTrue(newMember.membershipFee() == 659.89);
        boolean expectedOutput = true;
        boolean actualOutput = (659.89 == newMember.membershipFee());
        assertEquals(expectedOutput, actualOutput);
    }
}