import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import myPackage.Date;
import myPackage.Location;
/** This class implements methods that handle the member database for the gym.
 * @author Anna Kryzanekas, Brandon Yuen
 */
public class MemberDatabase {
    private Member[] mlist;
    private int size = 4;
    //added variables
    public static final int NOT_FOUND = -1;

    /**
     * This constructor defines mlist where members will be stored and the size of mlist.
     */
    public MemberDatabase() {
        this.mlist = new Member[size];
    }

    public int getSize() {
        return this.size;
    }

    /**
     * Searches for a member in the database.
     * @param member inputted gym member.
     * @return the index of the member if found and NOT_FOUND if the member is not in the list.
     */
    private int find(Member member) {
        for (int i = 0; i < size; i++) {
            if (mlist[i] != null && mlist[i].equals(member)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Increases the capacity of the list, or database, by 4. The capacity never decreases.
     */
    private void grow() {
        int newListLength = size + 4;
        Member[] tempList = new Member[newListLength];
        if (mlist[size - 1] != null) {
            for (int i = 0; i < size; i++) {
                tempList[i] = mlist[i];
            }
            mlist = tempList;
            size += 4;
        }
    }

    /**
     * Adds a member to the database if they are not already in the list.
     * @param member current member being added to the database.
     * @return true once the member is successfully added and false if not.
     */
    public boolean add(Member member) {
        grow();
        if (find(member) != NOT_FOUND) {
            System.out.println(member.getfname() + " " + member.getlname() +
                    " is already in the database.");
            return false;
        }
        else {
            for (int i = 0; i < size; i++) {
                if (mlist[i] == null) {
                    mlist[i] = member;
                    System.out.println(member.getfname() + " " + member.getlname() + " added.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes a member from the database if they are in the list.
     * @param member current member that wants to be removed from the database.
     * @return true if the member is successfully removed from the database and false if the member
     * is not in the database to begin with.
     */
    public boolean remove(Member member) {
        int memberToRemove = find(member);
        if (memberToRemove != NOT_FOUND) {
            mlist[memberToRemove] = null;
            for (int i = memberToRemove; i < size - 1; i++) {
                mlist[i] = mlist[i + 1];
                mlist[i + 1] = null;
            }
            System.out.println(member.getfname() + " " + member.getlname() + " removed.");
            return true;
        } else {
            System.out.println(member.getfname() + " " + member.getlname() + " is not in the database.");
            return false;
        }
    }

    /**
     * Prints the array contents as is.
     */
    public void print () {
        if (mlist[0] == null) {
            System.out.println("Member database is empty!");
        }
        else {
            System.out.println();
            System.out.println("-list of members-");
            for (int i = 0; i < size; i++) {
                if (mlist[i] != null) {
                    System.out.println(mlist[i]);
                }
            }
            System.out.println("-end of list-");
            System.out.println();
        }
    }

    /**
     * Prints the array contents for the sorting methods.
     */
    public void printForSort () {
        if (mlist[1] == null) {
            System.out.println("Member database is empty!");
        }
        else {
            for (int i = 0; i < size; i++) {
                if (mlist[i] != null) {
                    System.out.println(mlist[i]);
                }
            }
            System.out.println("-end of list-");
            System.out.println();
        }
    }

    /**
     * Sorts the database by county and then zipcode of members. This method uses insertion sort.
     */
    public void printByCounty() {
        if (mlist[0] == null) {
            System.out.println("Member database is empty!");
        }
        else {
            System.out.println();
            System.out.println("-list of members sorted by county and zipcode-");
            for (int i = 0; i < size; i++) {
                Member key = mlist[i];
                if (key == null) {
                    continue;
                }
                int j = i - 1;

                while (j >= 0 && (key.getLocation().getCounty().compareTo((mlist[j].getLocation().getCounty())) < 0
                        || (key.getLocation().getCounty().compareTo(mlist[j].getLocation().getCounty()) == 0
                        && key.getLocation().getZipcode().compareTo(mlist[j].getLocation().getZipcode()) < 0))) {
                    mlist[j + 1] = mlist[j];
                    j--;
                }
                mlist[j + 1] = key;
            }
        }
        printForSort();
    }

    /**
     * Sorts the database by the expiration dates of members. This method uses insertion sort.
     */
    public void printByExpirationDate() {
        if (mlist[1] == null) {
            System.out.println("Member database is empty!");
        }
        else {
            System.out.println();
            System.out.println("-list of members sorted by membership expiration date-");
            for (int i = 0; i < size; i++) {
                Member key = mlist[i];
                if (key == null) {
                    continue;
                }
                int j = i - 1;

                while (j >= 0 && key.getExpire().compareTo(mlist[j].getExpire()) < 0) {
                    mlist[j + 1] = mlist[j];
                    j--;
                }
                mlist[j + 1] = key;
            }
        }
        printForSort();
    }

    /**
     * Sorts the database by last name and then first name of members. This method uses insertion sort.
     */
    public void printByName () {
        if (mlist[1] == null) {
            System.out.println("Member database is empty!");
        }
        else {
            System.out.println();
            System.out.println("-list of members sorted by last name, and first name-");
            for (int i = 0; i < size; i++) {
                Member key = mlist[i];
                if (key == null) {
                    continue;
                }
                int j = i - 1;

                while (j >= 0 && key.compareTo(mlist[j]) < 0) {
                    mlist[j + 1] = mlist[j];
                    j--;
                }
                mlist[j + 1] = key;
            }
        }
        printForSort();
    }

    /**
     * Added public method searches for a member in the database so that we can later refer to
     * this in the FitnessClass.
     * @param member inputted gym member.
     * @return the index of the member if found and NOT_FOUND if the member is not in the list.
     */
    public int findForClass(Member member) {
        return find(member);
    }

    /**
     * Checks if the membership has expired.
     * @param member inputted gym member.
     * @return true if membership has expired and false if it has not.
     */
    public boolean isExpired(Member member) {
        Member key = mlist[find(member)];
        Date today = new Date();
        if (key.getExpire().compareTo(today) < 0) {
            return false;
        }
        else {
            System.out.println(member + key.getExpire().toString() + " membership expired.");
            return true;
        }
    }
}