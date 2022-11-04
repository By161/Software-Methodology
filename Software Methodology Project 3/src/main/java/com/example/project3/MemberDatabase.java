package com.example.project3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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

    /**
     * Getter method to return the database of members
     * @return the list of members in the database
     */
    public Member[] getMembers() {
        return this.mlist;
    }

    /**
     * Helper method for the program to read the input easier
     * @param line inputted line for the program to read
     * @return an array that splits up the inputted string in a more organized manner
     */
    private String[] processLine(String line) {
        String[] commandLine = line.split(" ");
        return commandLine;
    }

    /**
     * Helper method to load the members from the text file
     * @throws FileNotFoundException checked exception in Java that occurs when an attempt to open a file denoted by a specified pathname fails
     * @throws URISyntaxException Constructs an instance from the given input string and reason
     */
    public void loadMembers() throws FileNotFoundException, URISyntaxException {
        URI url = getClass().getResource("memberList.txt").toURI();
        File file = new File(url.getPath()); //file path
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {                                       //reads all lines as long as there is another line after it
            String line = sc.nextLine();
            if (line.length() < 1) {
                continue;
            }
            String[] processedInput = processLine(line);
            Member tempMember = new Member(processedInput[0], processedInput[1], processedInput[2], new Date(), Location.valueOf(processedInput[4].toUpperCase()));
            this.add(tempMember);
        }
        sc.close();
    }

    /**
     * Searches for a member in the database.
     * @param member inputted gym member.
     * @return the index of the member if found and NOT_FOUND if the member is not in the list.
     */
    public int find(Member member) {
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
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (mlist[i] == null) {
                    mlist[i] = member;
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
            return true;
        } else {
            return false;
        }
    }
    /**
     * Prints the array contents as is.
     */
    public String print() {
        String out = "";
        if (mlist[0] == null) {
            return "Member database is empty!\n";
        } else {
            for (int i = 0; i < size; i++) {
                if (mlist[i] != null) {
                    out += mlist[i]+"\n";
                }
            }
            
        }
        out+="-end of list-\n";
        return out;
    }
    /**
     * Prints the array contents for the fee method.
     */
    public String printForFee() {
        String out = "";
        for (int i = 0; i < size; i++) {
            if (mlist[i] != null) {
                out+=(mlist[i].toString() + ", Membership fee: $" +
                        mlist[i].membershipFee())+"\n";
            }
        }
        out+="-end of list-\n";
        return out;
    }
    /**
     * Sorts the database by county and then zipcode of members. This method uses insertion sort.
     */
    public String printByCounty() {
        if (mlist[0] == null) {
        } else {
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
        return this.print();
    }
    /**
     * Sorts the database by the expiration dates of members. This method uses insertion sort.
     */
    public String printByExpirationDate() {
        if (mlist[0] == null) {
        } else {
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
        return this.print();
    }
    /**
     * Sorts the database by last name and then first name of members. This method uses insertion sort.
     */
    public String printByName() {
        if (mlist[0] == null) {
        } else {
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
        return this.print();
    }
    /**
     * Sorts the database by last name and then first name of members. This method uses insertion sort.
     */
    public String printWithFees() {
        String out="";
        if (mlist[0] == null) {
            return "Member database is empty!\n";
        } else {
            out+="-list of members with membership fees-\n";
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
        out += printForFee();
        return out;
    }
}