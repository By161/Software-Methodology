package com.example.project3;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Arrays;

import javafx.fxml.FXML;
// import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import java.util.Calendar;
import myPackage.Date;
import myPackage.Location;

/** This class creates the GUI for the gym manager app
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class GymManagerController {

    // @FXML private Label label;
    @FXML
    private RadioButton rbAddMember;
    @FXML
    private RadioButton rbRemoveMember;
    @FXML
    private RadioButton rbFamily;
    @FXML
    private RadioButton rbPremium;
    @FXML
    private RadioButton rbStandard;
    @FXML
    private TextField tfMembershipFirstName;
    @FXML
    private TextField tfMembershipLastName;
    @FXML
    private TextField tfMembershipBirthdate;
    @FXML
    private ChoiceBox<String> cbMembershipLocation;
    @FXML
    private Button buttonSubmitMember;
    @FXML
    private RadioButton rbCheckIn;
    @FXML
    private RadioButton rbCheckOut;
    @FXML
    private CheckBox cbCheckGuest;
    @FXML
    private TextField tfCheckFirstName;
    @FXML
    private TextField tfCheckLastName;
    @FXML
    private TextField tfCheckBirthdate;
    @FXML
    private ChoiceBox<String> cbCheckLocation;
    @FXML
    private ChoiceBox<String> cbCheckClass;
    @FXML
    private ChoiceBox<String> cbCheckInstructor;
    @FXML
    private TextArea textAreaOutput;
    @FXML
    private ScrollPane scroll;

    // initialize empty databases
    MemberDatabase database = new MemberDatabase();
    ClassSchedule schedule = new ClassSchedule();
    String[] locations = {"BRIDGEWATER","EDISON","FRANKLIN","PISCATAWAY","SOMERVILLE"};
    ToggleGroup addRemoveGroup = new ToggleGroup();
    ToggleGroup membershipTypeGroup = new ToggleGroup();
    ToggleGroup checkInOut = new ToggleGroup();
    public static final int NOT_FOUND = -1;

    /**
     * Method that initializes all required objects
     */
    public void initialize() {
        rbAddMember.setToggleGroup(addRemoveGroup);
        rbAddMember.setSelected(true);
        rbRemoveMember.setToggleGroup(addRemoveGroup);
        cbMembershipLocation.getItems().addAll(locations);
        cbCheckLocation.getItems().addAll(locations);
        rbFamily.setToggleGroup(membershipTypeGroup);
        rbStandard.setToggleGroup(membershipTypeGroup);
        rbStandard.setSelected(true);
        rbPremium.setToggleGroup(membershipTypeGroup);
        rbCheckIn.setToggleGroup(checkInOut);
        rbCheckOut.setToggleGroup(checkInOut);
        rbCheckIn.setSelected(true);
        cbCheckInstructor.setDisable(true);
        cbCheckClass.setDisable(true);
        cbCheckLocation.setDisable(true);
    }

    /**
     * Method that appends strings for the output logs of the GUI
     * @param input String input that is meant to be "printed out" into the output log panel
     */
    private void printToConsole(String input) {
        textAreaOutput.appendText(input);
        scroll.setVvalue(scroll.getVmax());
    }

    /**
     * Helper method for the radio button membership types
     */
    @FXML
    private void disableMembershipTypes(){
        rbFamily.setDisable(true);
        rbPremium.setDisable(true);
        rbStandard.setDisable(true);
        membershipTypeGroup.selectToggle(null);
        cbMembershipLocation.setDisable(true);
    }

    /**
     * Helper method for the radio button membership types
     */
    @FXML
    private void enableMembershipTypes(){
        rbFamily.setDisable(false);
        rbPremium.setDisable(false);
        rbStandard.setDisable(false);
        membershipTypeGroup.selectToggle(rbStandard);
        cbMembershipLocation.setDisable(false);
    }

    /**
     * Helper method that calls the command to load the members from the text file
     * @throws FileNotFoundException checked exception in Java that occurs when an attempt to open a file denoted by a specified pathname fails
     * @throws URISyntaxException Constructs an instance from the given input string and reason
     */
    @FXML
    private void loadMembers() throws FileNotFoundException, URISyntaxException {
        database.loadMembers();
        printToConsole("-list of members loaded-\n");
        printToConsole(database.print());
    }

    /**
     * Helper method to load the schedule from the text file
     * @throws FileNotFoundException checked exception in Java that occurs when an attempt to open a file denoted by a specified pathname fails
     * @throws URISyntaxException Constructs an instance from the given input string and reason
     */
    @FXML
    private void loadSchedule() throws FileNotFoundException, URISyntaxException {
        schedule.loadSchedule();
        cbCheckLocation.setDisable(false);
        retrieveClasses();
        printToConsole("-Fitness classes loaded-\n");
        printToConsole(schedule.printSchedule());
    }

    /**
     * Helper method to get the fitness classes that are in the schedule
     */
    @FXML
    private void retrieveClasses(){
        String currentLocation = cbCheckLocation.getValue();
        if(currentLocation==null){
            return;
        }
        String[] classTypes = new String[schedule.getNumClasses()];
        FitnessClass[] s = schedule.getClasses();
        cbCheckClass.getItems().removeAll(cbCheckClass.getItems());
        cbCheckInstructor.getItems().removeAll(cbCheckInstructor.getItems());
        cbCheckInstructor.setDisable(true);
        for(int i=0; i<schedule.getNumClasses(); i++){
            if(!Arrays.stream(classTypes).anyMatch(s[i].getClassType()::equals) && s[i].getLocationString().equals(currentLocation)){
                classTypes[i]=s[i].getClassType();
                cbCheckClass.getItems().add(s[i].getClassType());
            }
        }
        cbCheckClass.setDisable(false);
    }

    /**
     * Helper method to get all the instructors for the classes that are in the schedule
     */
    @FXML
    private void retrieveInstructors(){
        String currentLocation = cbCheckLocation.getValue();
        String selectedClass = cbCheckClass.getValue();
        String[] instructors = new String[schedule.getNumClasses()];
        FitnessClass[] s = schedule.getClasses();
        cbCheckInstructor.getItems().removeAll(cbCheckInstructor.getItems());
        for(int i=0; i<schedule.getNumClasses(); i++){
            if(!Arrays.stream(instructors).anyMatch(s[i].getFitnessInstructor()::equals) && s[i].getLocationString().equals(currentLocation) && s[i].getClassType().equals(selectedClass)){
                instructors[i] = s[i].getFitnessInstructor();
                cbCheckInstructor.getItems().add(s[i].getFitnessInstructor());
            }
        }
        cbCheckInstructor.setDisable(false);
    }

    /**
     * Helper method for the command P when the button is pressed
     */
    @FXML
    private void printP(){
        if (database.getMembers()[0] != null) {
            printToConsole("-list of members-\n");
        }
        printToConsole(database.print());
    }

    /**
     * Helper method for the command PC when the button is pressed
     */
    @FXML
    private void printPC(){
        if (database.getMembers()[0] != null) {
            printToConsole("-list of members sorted by county and zipcode-\n");
        }
        printToConsole(database.printByCounty());
    }

    /**
     * Helper method for the command PN when the button is pressed
     */
    @FXML
    private void printPN(){
        if (database.getMembers()[0] != null) {
            printToConsole("-list of members sorted by last name, and first name-\n");
        }
        printToConsole(database.printByName());
    }

    /**
     * Helper method for the command PD when the button is pressed
     */
    @FXML
    private void printPD(){
        if (database.getMembers()[0] != null) {
            printToConsole("-list of members sorted by expiration dates-\n");
        }
        printToConsole(database.printByExpirationDate());
    }

    /**
     * Helper method for the command PF when the button is pressed
     */
    @FXML
    private void printPF(){
        printToConsole(database.printWithFees());
    }

    /**
     * Helper method for thee command S when the button is pressed
     */
    @FXML
    private void printS(){
        printToConsole(schedule.printSchedule());
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
            printToConsole("Expiration date " + member.getDob() + ": invalid calendar date!\n");
            return false;
        }
        //Check that the membership has not expired
        if (member.getExpire().compareTo(todayDate) >= 1) {
            printToConsole(member.getFirstName() + " " + member.getLastName() + " " + member.getDob()
                    + " membership expired.\n");
            return false;
        }
        //Check that the member's date of birth is a valid date
        if (!member.getDob().isValid()) {
            printToConsole("DOB " + member.getDob() + ": invalid calendar date!\n");
            return false;
        }
        //Check that the member's date of birth is not today or in the future
        if (member.getDob().compareTo(todayDate) <= 0) {
            printToConsole("DOB " + member.getDob() + ": cannot be today or a future date!\n");
            return false;
        }
        //Check that the member is 18 or older
        if (member.getDob().isValid() && !member.getDob().eighteenOrOlder(todayDate)) {
            printToConsole("DOB " + member.getDob() + ": must be 18 or older to join!\n");
            return false;
        }
        //Already checked for location so no need to do so
        return true;
    }

    /**
     * Helper method to check if the input fields are null or not to disable other actions
     * @return True if there is are inputs, false if there is nothing in the required fields
     */
    private boolean checkMembershipAddNulls(){
        if(tfMembershipFirstName.getText().strip().equals("") || tfMembershipLastName.getText().strip().equals("") || tfMembershipBirthdate.getText().strip().equals("") || cbMembershipLocation.getValue()==null){
            return false;
        }
        return true;
    }

    /**
     * Helper method to check if the input fields are null or not to enable other actions
     * @return true if there are inputs, false if there is nothing in the required fields
     */
    private boolean checkMembershipRemoveNulls(){
        if(tfMembershipFirstName.getText().strip().equals("") || tfMembershipLastName.getText().strip().equals("") || tfMembershipBirthdate.getText().strip().equals("")){
            return false;
        }
        return true;
    }

    /**
     * Helper method to add/remove memberships
     */
    @FXML
    private void addRemoveMembership(){
        String firstName = tfMembershipFirstName.getText().strip();
        String lastName = tfMembershipLastName.getText().strip();
        String birthdate = tfMembershipBirthdate.getText().strip();
        String location = cbMembershipLocation.getValue();
        if(rbAddMember.isSelected()){
            if(!checkMembershipAddNulls()){
                printToConsole("All required fields must be filled out.\n");
                return;
            }
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 3);
            Date todayDate = new Date();
            Date expire = todayDate.addThreeMonths();
            try{
                Member tempMember = new Member(firstName, lastName, birthdate, expire, Location.valueOf(location));
                if(rbPremium.isSelected()){
                    tempMember = new Premium(firstName, lastName, birthdate, expire, Location.valueOf(location));
                }
                if(rbFamily.isSelected()){
                    tempMember = new Family(firstName, lastName, birthdate, expire, Location.valueOf(location));
                }
                if (isValidMemberInput(tempMember)) {
                    if(database.add(tempMember)){
                        printToConsole(firstName + " " + lastName + " added.\n");
                    }
                    else{
                        printToConsole(firstName + " " + lastName + " is already in database.\n");
                    }
                }
            }
            catch(Exception ex){
                printToConsole("Birthdate is incorrectly formatted.\n");
            }
        }
        else{
            if(!checkMembershipRemoveNulls()){
                printToConsole("All required fields must be filled out.\n");
                return;
            }
            try{
                Member tempMember = new Member(firstName, lastName, birthdate, new Date(), Location.valueOf("Bridgewater".toUpperCase()));
                if(database.remove(tempMember)){
                    printToConsole(tempMember.getFirstName() + " " + tempMember.getLastName() + " removed.\n");
                }
                else{
                    printToConsole("Member is not in database.\n");
                }
            }
            catch(NumberFormatException ex){
                printToConsole("Birthdate is incorrectly formatted.\n");
            }
        }
    }

    /**
     * Helper method to check in/out
     */
    @FXML
    private void checkInOut(){
        if(!checkCheckInOutNulls()){
            printToConsole("All required fields must be filled out.\n");
            return;
        }
        String firstName = tfCheckFirstName.getText();
        String lastName = tfCheckLastName.getText();
        String birthdate = tfCheckBirthdate.getText();
        Location location = Location.valueOf(cbCheckLocation.getValue());
        String classType = cbCheckClass.getValue();
        String instructor = cbCheckInstructor.getValue();
        try{
            Member tempMember = new Member(firstName, lastName, birthdate, new Date(), location);
            int realMemberIndex = database.find(tempMember);
            if(realMemberIndex == NOT_FOUND){
                printToConsole("Membership associated with values:\n\tFirst Name: "+firstName+"\n\tLast Name: "+lastName+"\n\tDOB: "+ birthdate +"\nnot found. Please try again.\n");
                return;
            }
            FitnessClass tempClass = new FitnessClass(classType, instructor, null, location);
            FitnessClass realClass = schedule.getClass(tempClass);
            Member realMember = database.getMembers()[realMemberIndex];
            //check in
            if(rbCheckIn.isSelected()){
                checkIn(realClass,realMember);
            }
            //check out
            else{
                checkOut(realClass,realMember);
            }
            
        }
        catch(NumberFormatException ex){
            printToConsole("Birthdate is incorrectly formatted.\n");
        }
    }

    /**
     * Helper method for checking into a class
     * @param realClass the desired class that is meant to be checked in
     * @param realMember the member that wants to check in
     */
    private void checkIn(FitnessClass realClass, Member realMember){
        if(cbCheckGuest.isSelected()){
            if(realMember.getLocation().equals(cbCheckLocation.getValue())) {
                if (realMember instanceof Premium) {
                    Premium member = (Premium) realMember;
                    if (member.getNumPremGuestPasses() > 0) {
                        realClass.addGuest(member);
                        member.decNumPremGuestPasses();
                        printToConsole("Successfully checked in guest for " + member.getFirstName() + " " + member.getLastName() + ". There are " + member.getNumPremGuestPasses() + " guest passes remaining\n");
                    } else {
                        printToConsole("There are no more guest passes available for this membership.\n");
                    }
                }
                else if (realMember instanceof Family) {
                    Family member = (Family) realMember;
                    if (member.getNumFamGuestPasses() > 0) {
                        realClass.addGuest(member);
                        member.decNumFamGuestPasses();
                        printToConsole("Successfully checked in guest for " + member.getFirstName() + " " + member.getLastName() + ". There are " + member.getNumFamGuestPasses() + " guest passes remaining\n");
                    } else {
                        printToConsole("There are no more guest passes available for this membership.\n");
                    }
                } else {
                    printToConsole("Membership is a standard membership and cannot have any guests.\n");
                }
            }
        }
        //check in member
        else{
            //make sure member is not already in a class
            for(int i=0;i<schedule.getNumClasses();i++){
                if(schedule.getClasses()[i].containsStudent(realMember)){
                    printToConsole("Member is already checked into class "+schedule.getClasses()[i].toString()+".\n");
                    return;
                }
            }
            realClass.addStudent(realMember);
            printToConsole("Successfully checked in member "+realMember.getFirstName()+" "+realMember.getLastName()+".\n");
        }
    }

    /**
     * Helper method for checking out of a class
     * @param realClass the class that the member wants to check out of
     * @param realMember the member that wants to check out
     */
    private void checkOut(FitnessClass realClass, Member realMember){
        if(cbCheckGuest.isSelected()){
            if(realClass.removeGuest(realMember)){
                if(realMember instanceof Premium){
                    Premium member = (Premium) realMember;
                    member.incNumPremGuestPasses();
                    printToConsole("Successfully checked out guest for "+member.getFirstName()+" "+member.getLastName()+". There are "+member.getNumPremGuestPasses()+" guest passes remaining\n");
                    return;
                }
                if(realMember instanceof Family){
                    Family member = (Family) realMember;
                    member.incNumFamGuestPasses();
                    printToConsole("Successfully checked out guest for "+member.getFirstName()+" "+member.getLastName()+". There are "+member.getNumFamGuestPasses()+" guest passes remaining\n");
                }
            }
            else{
                printToConsole("There are no guests for member "+realMember.getFirstName()+" "+realMember.getLastName()+" checked into this class.\n");
            }
        }
        else{
            if(realClass.removeStudent(realMember)){
                printToConsole("Successfully checked out member "+realMember.getFirstName()+" "+realMember.getLastName()+".\n");
            }
            else{
                printToConsole("Member "+realMember.getFirstName()+" "+realMember.getLastName()+" is not checked into this class.\n");
            }
        }
    }

    /**
     * Helper method to see if the required fields are null or not
     * @return false if the required fields are empty, true if they are not
     */
    private boolean checkCheckInOutNulls(){
        if(tfCheckFirstName.getText().strip().equals("") || tfCheckLastName.getText().strip().equals("") || tfCheckBirthdate.getText().strip().equals("") || cbCheckLocation.getValue()==null || cbCheckClass.getValue()==null || cbCheckInstructor.getValue()==null){
            return false;
        }
        return true;
    }
}