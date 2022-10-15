import java.io.FileNotFoundException;
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
    String inputLine;
//    ClassSchedule schedule = new ClassSchedule();
    /**
     * Creates an array to split up the information in the input line
     * @param line
     * @return an array that holds all the information inputted
     */
    public String[] processLine(String line){
        String[] commandLine = line.split(" ");
        return commandLine;
    }

    /**
     * method that adds the inputted member into the member database
     * @param member
     */
    private void addNewMember(Member member){
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
        //Check that the member's date of birth is a valid date
        if (!member.getDob().isValid()) {
            System.out.println("DOB " + member.getDob() + ": invalid calendar date!");
            return false;
        }
        //Check that the member's date of birth is not today or in the future
        if (member.getDob().compareTo(todayDate) >= 0) {
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
     * Method that takes the inputted member and removes them from the database
     * @param member
     * @return a string that shows that their membership has been cancelled
     */
    private String cancelMembership(Member member){
        database.remove(member);
        return (member.getFirstName() + " " + member.getLastName() + "removed.");
    }
    /**
     * helper method that performs the actions that the input A is intended to do
     * @param input
     */
    private void commandA(String input){
        String[] processedInput = processLine(input);
        Member tempMember = new Member (processedInput[1], processedInput[2], processedInput[3],processedInput[4]);
        if(isValidMemberInput(tempMember)){
            database.add(tempMember);
        }
        System.out.println(" ");
    }
    private void commandAF(String input){
        String[] processedInput = processLine(input);
        Family tempMember = new Family (processedInput[1], processedInput[2], processedInput[3],processedInput[4]);
        if(isValidMemberInput(tempMember)){
            database.add(tempMember);
        }
        System.out.println(" ");
    }
    private void commandAP(String input){
        String[] processedInput = processLine(input);
        Premium tempMember = new Premium (processedInput[1], processedInput[2], processedInput[3],processedInput[4]);
        if(isValidMemberInput(tempMember)){
            database.add(tempMember);
        }
        System.out.println(" ");
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
    private void commandCG(){

    }
    /**
     * helper method that performs the actions that the input C is intended to do
     * @param input
     */
    private void commandC (String input){
        String[] processedInput = processLine(input);
        String classType = processedInput[1];
        String fitnessInstructor = processedInput[2];
        String location = processedInput[3];
        String fname = processedInput[4];
        String lname = processedInput[5];
        String dateOfBirth = processedInput[6];
        Member tempMember=  new Member (fname, lname, dateOfBirth, location);
        FitnessClass tempClass = new FitnessClass(classType, fitnessInstructor, null, Location.valueOf(location.toUpperCase()));
//        if (schedule.hasClass(tempClass)){
//            schedule.getClass(tempClass).addStudent(tempMember);
        }
//        System.out.println("Class does not exist within the schedule");
//    }
    private void commandPF(){
        database.printWithFees();
    }

    /**
     * Helper method that performs the actions that the input LS is intended to do
     * @throws FileNotFoundException
     */
    public void commandLS() throws FileNotFoundException {
        File file = new File("C:\\Users\\Brandon\\Downloads\\classSchedule.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-Fitness classes loaded-");
        String[] processedInput =  processLine(sc.nextLine());
        while (sc.hasNextLine()) {
            String classType = processedInput[0];
            String instructor = processedInput[1];
            String time = processedInput[2];
            String location = processedInput[3];
            FitnessClass newClass = new FitnessClass(classType,instructor,Time.valueOf(time.toUpperCase()), Location.valueOf(location.toUpperCase()));
//            schedule.addClass(newClass);
//            schedule.printClasses();
        }
    }

    /**
     * Helper method that performs the actions that the input LM is intended to do
     * @throws FileNotFoundException
     */
    private void commandLM() throws FileNotFoundException {
        File file = new File("C:\\Users\\Brandon\\Downloads\\memberList.txt"); //file path
        Scanner sc = new Scanner(file);
        System.out.println("-list of members loaded-");
        while (sc.hasNextLine()){                                       //reads all lines as long as there is another line after it
            String[] processedInput =  processLine(sc.nextLine());
            Member tempMember = new Member (processedInput[1], processedInput[2], processedInput[3], processedInput[5]);
            addNewMember(tempMember);
            System.out.println(tempMember);
        }
    }
    /**
     * Method that runs the program based off the inputted command
     */
    public void run() throws FileNotFoundException {
        System.out.print("Gym Manager Running...");
        Scanner sc = new Scanner(System.in);
        while(running){
            String inputLine = sc.nextLine();
            String[] inputArray = processLine(inputLine);
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
                case "C" -> commandC(inputLine);
                case "LS" -> commandLS();
                case "LM" -> commandLM();
                case "PF" -> commandPF();
                case "AF" -> commandAF(inputLine);
                case "AP" -> commandAP(inputLine);
                case "Q" -> {
                    System.out.println("Gym Manager terminated.");
                    running = false;
                }
                default -> System.out.println(command + " is an invalid command!");
            }
        }
    }
}

