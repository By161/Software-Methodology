import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import myPackage.Date;
import myPackage.Location;

/**
 * GymManager class that handles all the functions that maintain the gym
 * Main class that is called to run the software
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class GymManager {
    private boolean running = true;
    MemberDatabase database = new MemberDatabase();
    ClassSchedule schedule = new ClassSchedule();
    public static final int NOT_FOUND = -1;

    /**
     * Creates an array to split up the information in the input line
     * @param line
     * @return an array that holds all the information inputted
     */
    public String[] processLine(String line) {
        String[] commandLine = line.split(" ");
        return commandLine;
    }

    /**
     * method that adds the inputted member into the member database
     * @param member
     */
    private void addNewMember(Member member) {
        database.add(member);
        member.getFirstName();
        member.getLastName();
    }

    /**
     * Checks date of birth and expiration date to ensure that the member input is valid.
     * @param member member wanting to be added to the database.
     * @return true if member information is valid and false if it is not.
     */
    private boolean isValidMemberInput(Member member) {
        //Create an instance variable of today's date
        Date todayDate = new Date();

        //Check that the member's expiration date is a valid date
        if (!member.getExpire().isValid()) {
            System.out.println("Expiration date " + member.getDob() + ": invalid calendar date!");
            return false;
        }
        //Check that the membership has not expired
        if (member.getExpire().compareTo(todayDate) >= 1) {
            System.out.println(member.getFirstName() + " " + member.getLastName() + " " + member.getDob()
                    + " membership expired.");
            return false;
        }
        //Check that the member's date of birth is a valid date
        if (!member.getDob().isValid()) {
            System.out.println("DOB " + member.getDob() + ": invalid calendar date!");
            return false;
        }
        //Check that the member's date of birth is not today or in the future
        if (member.getDob().compareTo(todayDate) <= 0) {
            System.out.println("DOB " + member.getDob() + ": cannot be today or a future date!");
            return false;
        }
        //Check that the member is 18 or older
        if (member.getDob().isValid() && !member.getDob().eighteenOrOlder(todayDate)) {
            System.out.println("DOB " + member.getDob() + ": must be 18 or older to join!");
            return false;
        }
        //Already checked for location so no need to do so
        return true;
    }
    /**
     * Differentiates between valid and invalid locations to be used in createMember().
     * @param townName string input of a location that was entered.
     * @return true if the location is valid and false if it is invalid.
     */
    private boolean isValidLocation(String townName) {
        String[] townArray = new String[] {"Piscataway", "Bridgewater", "Somerville", "Franklin", "Edison"};
        for (int i = 0; i < townArray.length; i++) {
            if (townName.equalsIgnoreCase(townArray[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to check if the member is able to check in to their desired class
     * @param input the inputted line from the command
     * @return true or false if the member is allowed to check in to the desired class
     */
    private boolean isValidForCheckIn(String input) {
        //Create an instance variable of today's date
        String[] processedInput = processLine(input);
        String classType = processedInput[1];
        String instructor = processedInput[2];
        Location location = Location.valueOf(processedInput[3].toUpperCase());
        FitnessClass tempClass = new FitnessClass(classType, instructor, null, location);
        String fname = processedInput[4];
        String lname = processedInput[5];
        String dob = processedInput[6];
        Member tempMember = new Member(fname, lname, dob, null, null);
        Date dateOfBirth = new Date(dob);
        //check if location is valid
        //check if member input is valid
        //check if member is in the database
        if (!isValidLocation(location.name())){
            return false;
        }
        if (!isValidMemberInput(tempMember)) {
            return false;
        }
        if (database.find(tempMember) == NOT_FOUND) {
            System.out.println(tempMember.getFirstName() + " " + tempMember.getLastName() + " " + tempMember.getDob()
                    + " is not in the database.");
            return false;
        }
        if (classType.equalsIgnoreCase("pilates") || classType.equalsIgnoreCase("cardio")
                || classType.equalsIgnoreCase("spinning")) {
            if (instructor.equalsIgnoreCase("jennifer") || instructor.equalsIgnoreCase("kim")
                    || instructor.equalsIgnoreCase("davis") || instructor.equalsIgnoreCase("denise") || instructor.equalsIgnoreCase("emma")) {
                if (schedule.hasClass(tempClass)) {
                    if (tempClass.findStudent(tempMember) >= 0) {
                        System.out.println(fname + " " + lname + " has already checked in.");
                        return false;
                    } else {
                        return true;
                    }
                }
                System.out.println(classType + " by " + instructor + " does not exist at " + location);
                return false;
            }
            System.out.println(instructor + " - does not exist");
            return false;
        }
        System.out.println(classType + " - class does not exist");
        return false;
    }

    /**
     * Helper method that performs the actions that the input A is intended to do
     * @param input the inputted line from the command
     */
    private void commandA(String input) {
        String[] processedInput = processLine(input);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        if (!isValidLocation(processedInput[4])){
            System.out.println(processedInput[4] + ": invalid location!");
        }else{
            Member tempMember = new Member(processedInput[1], processedInput[2], processedInput[3], expire, Location.valueOf(processedInput[4]));
            if (isValidMemberInput(tempMember)) {
                database.add(tempMember);
                if (database.find(tempMember) == NOT_FOUND) {
                    System.out.println(processedInput[1] + " " + processedInput[2] + " added.");
                }
                System.out.println(" ");
            }
        }

    }

    /**
     * Helper method that performs the actions that the input AF is intended to do
     * @param input the inputted line from the command
     */
    private void commandAF(String input) {
        String[] processedInput = processLine(input);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        if (!isValidLocation(processedInput[4])) {
            System.out.println(processedInput[4] + ": invalid location!");
        } else{
            Family tempMember = new Family(processedInput[1], processedInput[2], processedInput[3], expire, Location.valueOf(processedInput[4].toUpperCase()));
            if (isValidMemberInput(tempMember)) {
                database.add(tempMember);
            }
            if (database.find(tempMember) == NOT_FOUND) {
                System.out.println(processedInput[1] + " " + processedInput[2] + " added.");
            }
            System.out.println(" ");
        }
    }

    /**
     * Helper method that performs the actions that the input AP is intended to do
     * @param input the inputted line from the command
     */
    private void commandAP(String input) {
        String[] processedInput = processLine(input);
        Date todayDate = new Date();
        Date expire = todayDate.addThreeMonths();
        if (!isValidLocation(processedInput[4])) {
            System.out.println(processedInput[4] + ": invalid location!");
        } else {
            Premium tempMember = new Premium(processedInput[1], processedInput[2], processedInput[3], expire, Location.valueOf(processedInput[4].toUpperCase()));
            if (isValidMemberInput(tempMember)) {
                database.add(tempMember);
            }
            if (database.find(tempMember) == NOT_FOUND) {
                System.out.println(processedInput[1] + " " + processedInput[2] + " added.");
            }
            System.out.println(" ");
        }
    }
    /**
     * Helper method that performs the actions that the input R is intended to do
     * @param input the inputted line from the command
     */
    private void commandR(String input) {
        String[] processedInput = processLine(input);
        Member tempMember = new Member(processedInput[1], processedInput[2], processedInput[3], new Date(), Location.valueOf("Bridgewater".toUpperCase()));
        if (processedInput.length == 4) {
            database.remove(tempMember);
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Helper method that performs the actions that the input P is intended to do
     * @param input the inputted line from the command
     */
    private void commandP(String input) {
        if (database.getSize() < 0) {
            System.out.println("Member database is empty!");
        }
        database.print();
    }

    /**
     * Helper method that performs the actions that the input PD is intended to do
     */
    private void commandPD() {
        database.printByExpirationDate();
    }

    /**
     * Helper method that performs the actions that the input PN is intended to do
     */
    private void commandPN() {
        database.printByName();
    }

    /**
     * Helper method that performs the actions that the input PC is intended to do
     */
    private void commandPC() {
        database.printByCounty();
    }

    /**
     * Helper method that performs the actions that the input CG is intended to do
     */
    private void commandCG() {

    }

    /**
     * Helper method that performs the actions that the input C is intended to do
     * @param input the inputted line from the command
     */
    private void commandC(String input) {
        String[] processedInput = processLine(input);
        String classType = processedInput[1];
        String fitnessInstructor = processedInput[2];
        String fname = processedInput[4];
        String lname = processedInput[5];
        String dateOfBirth = processedInput[6];
        if(isValidLocation(processedInput[3])){
            Location location = Location.valueOf(processedInput[3].toUpperCase());
            Member tempMember = new Member(fname, lname, dateOfBirth, null, location);
            FitnessClass tempClass = new FitnessClass(classType, fitnessInstructor, null, location);
            if (schedule.hasClass(tempClass) && isValidForCheckIn(input)) {
                schedule.getClass(tempClass).addStudent(tempMember);
            }
        }
    }

    /**
     * Helper method that performs the actions that the input PF is intended to do
     */
    private void commandPF() {
        database.printWithFees();
    }

    /**
     * Helper method that performs the action that the input D is intended to do
     * @param input the inputted line from the command
     */
    private void commandD(String input) {
        String[] processedInput = processLine(input);
        String classType = processedInput[1];
        String fitnessInstructor = processedInput[2];
        String fname = processedInput[4];
        String lname = processedInput[5];
        String dateOfBirth = processedInput[6];
        if (isValidLocation(processedInput[3])){
            Location location = Location.valueOf(processedInput[3].toUpperCase());
            Member tempMember = new Member(fname, lname, dateOfBirth, null, location);
            FitnessClass tempClass = new FitnessClass(classType, fitnessInstructor, null, location);
            if (schedule.hasClass(tempClass) && isValidMemberInput(tempMember) && schedule.getClass(tempClass).findStudent(tempMember) >= 0) {
                schedule.getClass(tempClass).removeStudent(tempMember);
            }
        }
    }
    /**
     * Helper method that performs the action that the input DG is intended to do
     * @param input the inputted line from the command
     */
    private void commandDG(String input) {

    }
    /**
     * Helper method that performs the actions that the input S is intended to do
     */
    private void commandS () {
        schedule.printSchedule();
    }
    /**
     * Helper method that performs the actions that the input LS is intended to do
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed.
     */
    public void commandLS () throws FileNotFoundException {
        File file = new File("classSchedule.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-Fitness classes loaded-");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() < 1) {
                continue;
            }
            String[] processedInput = processLine(line);
            String classType = processedInput[0];
            String instructor = processedInput[1];
            String time = processedInput[2];
            Location location = Location.valueOf(processedInput[3].toUpperCase());
            FitnessClass newClass = new FitnessClass(classType, instructor, Time.valueOf(time.toUpperCase()), location);
            schedule.addClass(newClass);
        }
        schedule.printSchedule();
    }
    /**
     * Helper method that performs the actions that the input LM is intended to do
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed.
     */
    private void commandLM () throws FileNotFoundException {
        File file = new File("memberList.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-list of members loaded-");
        while (sc.hasNextLine()) {                                       //reads all lines as long as there is another line after it
            String line = sc.nextLine();
            if (line.length() < 1) {
                continue;
            }
            String[] processedInput = processLine(line);
            Member tempMember = new Member(processedInput[0], processedInput[1], processedInput[2], new Date(), Location.valueOf(processedInput[4].toUpperCase()));
            addNewMember(tempMember);
            System.out.println(tempMember);
        }
    }

    /**
     * Run method that calls all the necessary helper methods for the respective command
     * @throws FileNotFoundException Signals that an attempt to open the file denoted by a specified pathname has failed.
     */
    public void run () throws FileNotFoundException {
        System.out.print("Gym Manager Running...");
        Scanner sc = new Scanner(System.in);
        while (running) {
            String inputLine = sc.nextLine();
            String[] inputArray = processLine(inputLine);
            if (inputLine.length() < 1) {
                continue;
            }
            String command = inputArray[0];
            switch (command) {
                case "A" -> commandA(inputLine);
                case "R" -> commandR(inputLine);
                case "P" -> commandP(inputLine);
                case "PD" -> commandPD();
                case "PN" -> commandPN();
                case "PC" -> commandPC();
                case "C" -> commandC(inputLine);
                case "CG" -> commandCG();
                case "LS" -> commandLS();
                case "LM" -> commandLM();
                case "PF" -> commandPF();
                case "AF" -> commandAF(inputLine);
                case "AP" -> commandAP(inputLine);
                case "D" -> commandD(inputLine);
                case "DG" -> commandDG(inputLine);
                case "S" -> commandS();
                case "Q" -> {
                    System.out.println("Gym Manager terminated.");
                    running = false;
                }
                default -> System.out.println(command + " is an invalid command!");
            }
        }
    }
}


