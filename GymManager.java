import java.util.Calendar;
import java.util.Scanner;
import myPackage.Date;
import myPackage.Location;
/**
 * GymManager class that handles all the functions that maintain the gym
 * Main class that is called to run the software
 * @author Brandon Yuen
 */
public class GymManager {
    private boolean running = true;
    MemberDatabase database = new MemberDatabase();
    FitnessClass fitClassPilates = new FitnessClass("Pilates","JENNIFER", Time.MORNING);
    FitnessClass fitClassSpin = new FitnessClass("Spinning","DENISE", Time.AFTERNOON);
    FitnessClass fitClassCardio = new FitnessClass("Cardio","KIM", Time.AFTERNOON);
    /**
     * Creates an array to split up the information in the input line
     * @param line
     * @return an array that holds all the information inputted
     */
    private String[] processLine(String line){
        String[] commandLine = line.split(" ");
        return commandLine;
    }

    /**
     * method that adds the inputted member into the member database
     * @param member
     */
    private void addNewMember(Member member){
        database.add(member);
        member.getfname();
        member.getlname();
    }

    /**
     * Method that takes the inputted member and removes them from the database
     * @param member
     * @return a string that shows that their membership has been cancelled
     */
    private String cancelMembership(Member member){
        database.remove(member);
        return (member.getfname() + " " + member.getlname() + "removed.");
    }

    /**
     * helper method that performs the actions that the input A is intended to do
     * @param input
     */
    private void commandA(String input){
        Calendar calendar = Calendar.getInstance();
        String[] processedInput = processLine(input);
        Member tempMember = null;
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int year = calendar.get(Calendar.YEAR);
        Date today = new Date();
        if (processedInput.length == 6) {
            try {
                tempMember = new Member(processedInput[1], processedInput[2], new Date(processedInput[3]), new Date(processedInput[4]), Location.valueOf(processedInput[5].toUpperCase()));
            } catch (Exception e) {
                System.out.println(processedInput[5] + ": invalid location!");
                return;
            }
            if (!tempMember.getdob().isValid()){
                System.out.println("DOB " + tempMember.getdob().toString() + ": invalid calendar date!");
                return;
            }
            if (!tempMember.getexpire().isValid()){
                System.out.println("Expiration date " + tempMember.getexpire().toString() + ": invalid calendar date!");
                return;
            }
            if (tempMember.getdob().compareTo(today) <= 0){
                System.out.println(tempMember.getdob().toString() + ": cannot be today or a future date!");
                return;
            }
            if (!is18(tempMember)){
                System.out.println(tempMember.getdob().toString() + ": must be 18 or older to join!");
                return;
            }
            if(!database.add(tempMember)){
                System.out.println(tempMember.getfname() + " " + tempMember.getlname() + " is already in the database.");
            }
            else{
                System.out.println(tempMember.getfname() + " " + tempMember.getlname() + " added.");
            }
        }
        else{
            System.out.println("Error");
        }
    }

    /**
     * helper method that performs the actions that the input R is intended to do
     * @param input
     */
    private void commandR(String input){
        String[] processedInput = processLine(input);
        Member tempMember = new Member (processedInput[1], processedInput[2], new Date(processedInput[3]), null, null);
        if (processedInput.length == 4) {
           database.remove(tempMember);
           System.out.println(processedInput[1] + " " + processedInput[2] + " removed");
        }
        else{
            System.out.println("Error");
        }
    }

    /**
     * helper method that performs the actions that the input P is intended to do
     * @param input
     */
    private void commandP(String input){
        if (database.getSize() < 0){
            System.out.println("Member database is empty!");
        }
        database.print();
    }

    /**
     * helper method that performs the actions that the input PD is intended to do
     */
    private void commandPD(){
        database.printByExpirationDate();
    }

    /**
     * helper method that performs the actions that the input PN is intended to do
     */
    private void commandPN(){
        database.printByName();
    }

    /**
     * helper method that performs the actions that the input PC is intended to do
     */
    private void commandPC(){
        database.printByCounty();
    }

    /**
     * helper method that performs the actions that the input S is intended to do
     */
    private void commandS (){
        System.out.println("-Fitness classes-\n");
        fitClassPilates.setClassTime(Time.MORNING);
        System.out.println(fitClassPilates.toString());
        fitClassSpin.setClassTime(Time.AFTERNOON);
        System.out.println(fitClassSpin.toString());
        fitClassCardio.setClassTime(Time.AFTERNOON);
        System.out.println(fitClassCardio.toString());
    }

    /**
     * helper method that performs the actions that the input C is intended to do
     * @param input
     */
    private void commandC (String input){
        String[] processedInput = processLine(input);
        String classType = processedInput[1];
        String fname = processedInput[2];
        String lname = processedInput[3];
        Date dob = new Date(processedInput[4]);
        Member tempMember = new Member (fname, lname, dob, null, null);
        if(dob.isValid()){
            switch(classType){
                case "Pilates" -> fitClassPilates.removeStudent("Pilates", tempMember);
                case "Spinning" -> fitClassSpin.removeStudent("Spinning", tempMember);
                case "Cardio" -> fitClassCardio.removeStudent("Cardio", tempMember);
                default -> System.out.println(classType + " class does not exist");
            }
        }
    }

    /**
     * helper method that performs the actions that the input D is intended to do
     * @param input
     */
    private void commandD(String input){
        String[] processedInput = processLine(input);
        Member tempMember = new Member (processedInput[2], processedInput[3], new Date(processedInput[4]), null, null);
    }

    /**
     * Method that runs the program based off the inputted command
     */
    public void run() {
        System.out.print("Gym Manager Running...");
        Scanner sc = new Scanner(System.in);
        while(running){
            String inputLine = sc.nextLine();
            String[] inputArray= processLine(inputLine);
            if (inputLine.length() < 1){
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
                case "S" -> commandS();
//                case "C" -> commandC(inputLine);                          // not enough time (solo'd this project I emailed the professor)
//                case "D" -> commandD(inputLine);                          // not enough time (solo'd this project I emailed the professor)
                case "Q" -> {
                    System.out.println("Gym Manager terminated.");
                    running = false;
                }
                default -> System.out.println(command + " is an invalid command!");
            }
        }
    }

    /**
     * Helper method that calculates the members age and see if they are at least 18
     * @param member
     * @return boolean value of whether or not they are at least 18 years of age
     */
    public boolean is18 (Member member){
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.YEAR) - member.getdob().getYear() < 18){
            return false;
        }
        if (calendar.get(Calendar.YEAR) - member.getdob().getYear() == 18 && calendar.get(Calendar.MONTH ) + 1 - member.getdob().getMonth() < 0){
            return false;
        }
        if (calendar.get(Calendar.YEAR) - member.getdob().getYear() == 18 && calendar.get(Calendar.MONTH) + 1 - member.getdob().getMonth() == 0 && calendar.get(Calendar.DATE) - member.getdob().getDay() < 0){
            return false;
        }
        if(!member.getdob().isValid()){
            return false;
        }
        return true;
    }
}

