import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
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
    String inputLine;
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

    }

    /**
     * helper method that performs the actions that the input R is intended to do
     * @param input
     */
    private void commandR(String input){
        String[] processedInput = processLine(input);
        Member tempMember = new Member (processedInput[1], processedInput[2], null, null);
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
//    private void commandS (){
//        System.out.println("-Fitness classes-\n");
//        fitClassPilates.setClassTime(Time.MORNING);
//        System.out.println(fitClassPilates.toString());
//        fitClassSpin.setClassTime(Time.AFTERNOON);
//        System.out.println(fitClassSpin.toString());
//        fitClassCardio.setClassTime(Time.AFTERNOON);
//        System.out.println(fitClassCardio.toString());
//    }

    /**
     * helper method that performs the actions that the input C is intended to do
     * @param input
     */
    private void commandC (String input){

    }
    private void commandLS() throws FileNotFoundException {
        File file = new File("C:\\Users\\SPCHB\\Downloads\\classSchedule.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-Fitness classes loaded-");
        while (sc.hasNextLine()){                                       //reads all lines as long as there is another line after it
            String[] processedInput =  processLine(sc.nextLine());      //seperates the line into an array for easier access to the information
            Member tempMember = new Member (processedInput[1], processedInput[2], new Date(processedInput[3]), Location.valueOf(processedInput[5].toUpperCase())); //should not be a member this is based off what the fitness class is so finish this later
            addNewMember(tempMember);
        }
    }
    private void commandLM() throws FileNotFoundException {
        File file = new File("C:\\Users\\SPCHB\\Downloads\\memberList.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-list of members loaded-");
        while (sc.hasNextLine()){                                       //reads all lines as long as there is another line after it
            String[] processedInput =  processLine(sc.nextLine());
            Member tempMember = new Member (processedInput[1], processedInput[2], new Date(processedInput[3]), Location.valueOf(processedInput[5].toUpperCase()));
            addNewMember(tempMember);
        }
    }
    /**
     * Method that runs the program based off the inputted command
     */
    public void run() throws FileNotFoundException {
        System.out.print("Gym Manager Running...");
        while(running){
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
//                case "S" -> commandS();
//                case "C" -> commandC(inputLine);
                case "LS" -> commandLS();
                case "LM" -> commandLM();
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

