

import myPackage.Date;
import myPackage.Location;
/**
 * Testbed class, shows test cases to test the requested methods to be tested.
 * @author Brandon Yuen
 */
public class testbed {
    public static void main (String[] args){
        Date newDate = new Date("3/30/2023");                                               // 3/30/2023 is a valid Date in the calendar thus returning true
        System.out.println(newDate.isValid());
        Member newMember1 = new Member("Brandon", "Yuen",  newDate, newDate, Location.BRIDGEWATER);
        Member newMember2 = new Member("Lily", "Chang", newDate, newDate, Location.BRIDGEWATER);
        System.out.println(newMember1.compareTo(newMember2));                               //Brandon Yuen comes after Lily Chang in alphabetical order thus returning -1
        System.out.println(newMember2.compareTo(newMember1));                               //Lily Chang comes before Brandon Yuen in alphabetical order thus returning 1
        Member newMember3 = new Member("Bob", "May",  newDate, newDate, Location.BRIDGEWATER);
        Member newMember4 = new Member("Amanda", "Long", newDate, newDate, Location.BRIDGEWATER);
        System.out.println(newMember3.compareTo(newMember4));                               //Bob May comes after Amanda Long in alphabetical order thus returning -1
        System.out.println(newMember4.compareTo(newMember3));                               //Amanda Long comes before Bob May in alphabetical order thus returning 1
        Member newMember5 = new Member("Bob", "May",  newDate, newDate, Location.BRIDGEWATER);
        Member newMember6 = new Member("Amanda", "May", newDate, newDate, Location.BRIDGEWATER);
        System.out.println(newMember5.compareTo(newMember6));                               //Bob comes after Amanda in alphabetical order thus returning -1
        System.out.println(newMember6.compareTo(newMember5));                               //Amanda comes after Bob in alphabetical order thus returning 1
    }
}
