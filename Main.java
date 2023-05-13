/************************
* Programmers: Finnley Howald, Shubho Mukherjee, and Koushik Paul
* Date:10-11-2020 to 18-11-2020
* Program Name: Medical Database
* Program Description: This program is a medical database that stores the information of patients, their prescriptions, and their appointments. The user is given the option to sign in as a receptionist or a doctor. Depending on which option they chose, they will have to enter a certain password and username to successfully log in. Once logged in successfully (if you chose receptionist), you will be able to 1) View All Appointments, 2) Add Appointment, 3) Register New Patient, 4) View All Patients, 5) Find Patient, 6) View All Prescriptions, or 7) Exit. If the user chose doctor and have logged in successfully, they will be able to 1) Check Your Appointments, 2) Add Prescription, or 3) Exit. Once the user chooses to exit, the program will end.
*************************/

//imports
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;

public class Main {
  public static final Scanner KEYBOARD=new Scanner(System.in);
  //ArrayLists for the patients, appointments, and prescriptions
  public static ArrayList<Patient> allPatients= new ArrayList<Patient>();
  public static ArrayList<Appointment> allAppointments= new ArrayList<Appointment>();
  public static ArrayList<Prescription> allPrescriptions= new ArrayList<Prescription>();
  public static boolean loginSuccess = false;//keeps track of if the login was successful
  
  
  public static void main(String[] args) throws FileNotFoundException {
    //these 3 .addAll statements call the createAll methods and add the Patients, Appointments, and Prescriptions from the text files and combines them with the ArrayList that takes in the newly added ones during the session that the program is running 
    allPatients.addAll(Patient.createAllPatients());
    allPrescriptions.addAll(Prescription.createAllPrescriptions());
    allAppointments.addAll(Appointment.createAllAppointments());
    
    int userOption;

    //login screen
    System.out.println("***** LOGIN SCREEN *****");
    System.out.println("1) Receptionist Sign-In");
    System.out.println("2) Doctor Sign-In");
    System.out.println("3) Exit");
    System.out.println("\n\nSelect an Option: ");

    //user chooses if they want to sign in as a receptionist or doctor
    userOption= KEYBOARD.nextInt();
      
    switch(userOption) {
      case 1:
        //Receptionist log in
        KEYBOARD.nextLine();
        System.out.println("Option 1 Receptionist Sign-In");
        //the user will be prompted to log in using a username and password
        loginChecker();
        //if the username and password is input correctly you will be sent to the receptionist menu
        if(loginSuccess==true){
          receptionistMenu();
        }
        //if its incorrect the program will stop
        break;
      case 2:
        //Doctor log in
        KEYBOARD.nextLine();
        System.out.println("Option 2 Doctor Sign-In");
        //the user will be prompted to log in using a username and password
        loginChecker();
        //if the username and password is input correctly you will be sent to the receptionist menu
        if(loginSuccess==true){
          doctorMenu();
        }
        //if its incorrect the program will stop
        break;
      case 3:
        break;
    }
    KEYBOARD.close();
  }

  //this method promps the user to enter a username and password and checks if they are correct or incorrect
  public static void loginChecker() throws FileNotFoundException {
    try{
			//counter for the number of attempts to login
      int n = 0;
      while(n<3){
        File file = new File ("userPass.txt");
        Scanner scan = new Scanner (file);
        //Scanner KEYBOARD = new Scanner (System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan

        System.out.println("Enter Username:");
        String inpUser = KEYBOARD.nextLine();
        System.out.println("Enter Password:");
        String inpPass = KEYBOARD.nextLine(); // gets input from user

        if (inpUser.equals(user) && inpPass.equals(pass)) {//if the username and password are correct you will be able to enter the database
            System.out.println("Welcome!");
            n=4;
            loginSuccess = true;
        } else {//if its incorrect your number of attemps will increase by one
            n++;
            System.out.println("Your username and/or password was incorrect\n" + n + "/3 attempts.\n");
        }
        //closing the scanner            
        scan.close();
      }
      if(n==3){//if the number of failed attemps is 3, the program ends
        System.out.println("You have locked out of the system. Please try again later.");
      }
    }
    catch (FileNotFoundException ex) 
    {
      throw ex;
    }
  }


  public static void doctorMenu(){
    int userOptionDoctor;

    //outputs the doctor menu
    System.out.println("\n***** DOCTOR MENU *****");
    System.out.println("1) Check All Appointments");
    System.out.println("2) Add Prescription");
    System.out.println("3) Remove Prescription");
    System.out.println("4) View All Prescription");
    System.out.println("5) Exit");
    System.out.println("\n\nSelect an Option: ");

    userOptionDoctor= KEYBOARD.nextInt();
      
    switch(userOptionDoctor) {
      case 1:
        //outputs a list of all of the patients sorted in alphabetical order by first name
        KEYBOARD.nextLine();
        System.out.println("Option 1: List of All Appointments");
        
        Collections.sort(allAppointments);//this is used to sort the appointments by their time
        System.out.println(allAppointments);
        doctorMenu();
        break;
      case 2:
        //allows user to add a prescription
        KEYBOARD.nextLine();
        System.out.println("Option 2: Add Prescription");
        Prescription pr1 = Prescription.createPrescription();
        allPrescriptions.add(pr1);
        System.out.println(pr1.toString());
        doctorMenu();
        break;
      case 3:
        //allows the user to remove a prescription
        KEYBOARD.nextLine();
        System.out.println("Option 3: Remove Prescription");
        System.out.println("Enter the First Name of the Patient's Prescription You Want to Remove:");
        String key = KEYBOARD.nextLine();
        System.out.println("Enter the Last Name of the Patient's Prescription You Want to Remove:");
        String keyLast = KEYBOARD.nextLine();
        removePrescription(allPrescriptions, key, keyLast);
        doctorMenu();
        break;
      case 4:
        //allows the user to remove a prescription
        KEYBOARD.nextLine();
        System.out.println("Option 4: View all Prescriptions");
        System.out.println(allPrescriptions);
        doctorMenu();
        break;
      case 5: //exits the program
        break;
    }	
  }

  public static void receptionistMenu(){
    int userOptionReceptionist;

    //outputs the receptionist menu
    System.out.println("\n***** RECEPTIONIST MENU *****");
    System.out.println("1) View All Appointments");
    System.out.println("2) Add Appointment");
    System.out.println("3) Register New Patient");
    System.out.println("4) View All Patients");
    System.out.println("5) Find Patient");
    System.out.println("6) View All Prescriptions");
    System.out.println("7) Remove a Patient");
    System.out.println("8) Remove an Appointment");
    System.out.println("9) Exit");
    System.out.println("\n\nSelect an Option: ");

    userOptionReceptionist= KEYBOARD.nextInt();
      
    switch(userOptionReceptionist) {
      case 1:
        //outputs a list of all appointments in alphabetical order by first name
        KEYBOARD.nextLine();
        System.out.println("Option 1: List of Appointments");
        
        Collections.sort(allAppointments);//sorts the appointments by their time
        System.out.println(allAppointments);
        receptionistMenu();
        break;
      case 2:
        //allows the user to add an appointment
        KEYBOARD.nextLine();
        System.out.println("Option 2: Add Appointment");
        Appointment a1 = Appointment.createAppointment();
        System.out.println(a1.toString());
        allAppointments.add(a1);
        receptionistMenu();
        break;
      case 3:
        //allows the user to add a new patient
        KEYBOARD.nextLine();
        System.out.println("Option 3: Register New Patient");
        Patient p3 = Patient.createPatient();
        //System.out.println(p3.toString());
        allPatients.add(p3);
        receptionistMenu();
        break;
      case 4:
        //outputs the list of all patients
        KEYBOARD.nextLine();
        System.out.println("Option 4: List of All Patient");
        
        Collections.sort(allPatients);//this is used to sort patients in alphabetical order by their first names
        System.out.println(allPatients);
        receptionistMenu();
        break;
      case 5:
        //allows the user to search for a patient
        KEYBOARD.nextLine();
        System.out.println("Option 5: Find a Patient");
        System.out.println("Enter the First Name of the Patient You Want to Find:");
        String key = KEYBOARD.nextLine();
        findPatient(allPatients, key);
        receptionistMenu();
        break;
      case 6:
        //outputs all of prescriptions
        KEYBOARD.nextLine();
        System.out.println("Option 6: View all Prescriptions");
        
        System.out.println(allPrescriptions);
        receptionistMenu();
        break;
      case 7:
        //allows the user to remove a patient from the database
        KEYBOARD.nextLine();
        System.out.println("Option 7: Remove Patient");
        System.out.println("Enter the First Name of the Patient You Want to Remove:");
        String key2 = KEYBOARD.nextLine();
        System.out.println("Enter the Last Name of the Patient You Want to Remove:");
        String keyLast2 = KEYBOARD.nextLine();
        removePatient(allPatients, key2, keyLast2);
        receptionistMenu();
        break;
      case 8:
        //allows the user to remove an appointment from the database
        KEYBOARD.nextLine();
        System.out.println("Option 8: Remove Appointment");
        System.out.println("Enter the First Name of the Patient's Appointment You Want to Remove:");
        String key3 = KEYBOARD.nextLine();
        System.out.println("Enter the Last Name of the Patient's Appointment You Want to Remove:");
        String keyLast3 = KEYBOARD.nextLine();
        removeAppointment(allAppointments, key3, keyLast3);
        receptionistMenu();
        break;
      case 9: //exits the program
        break;
    }	
  }

  //this method is used to find the patient
  public static void findPatient(ArrayList<Patient> allPatients, String key){

		//checks if the patient is found, updates throughout program
    boolean found = false;

    //goes through the entire array list and compares the first name of each patient to the key
    for(int i=0; i<allPatients.size(); i++){
      if(key.equals(allPatients.get(i).getFirstName())){
        System.out.println(allPatients.get(i));//if a match is found the patient is outputted
				found = true;
      }
    }
    //if the patient is not found in the ArrayList a message will be outputted
    if(found == false){
      System.out.println("Patient Not Registered.");
    }
  }
  
  //this method is used to remove a patient
  public static void removePatient(ArrayList<Patient> allPatients, String key, String keyLast){

		//checks if the patient is found, updates throughout program
    boolean found = false;

    //goes through the entire arraylist and compares the first and last names of each patient to the keys
    for(int i=0; i<allPatients.size(); i++){
      //if true, the patient is removed
      if(key.equals(allPatients.get(i).getFirstName()) && keyLast.equals(allPatients.get(i).getLastName())){
				found = true;
        System.out.println(allPatients.get(i).getFirstName() +" "+ allPatients.get(i).getLastName()+" has been removed from the system.");
        allPatients.remove(i);
      }
    }
    //if the patient is not in the list, a message is output
    if(found == false){
      System.out.println("Patient Not Registered. Therefore, it cannot be removed.");
    }
  }
  
  //this method reomoves an appointment from the database
  public static void removeAppointment(ArrayList<Appointment> allAppointments, String key, String keyLast){

		//checks if the appointment is found, updates throughout program
    boolean found = false;

    //checks each appointment in the arraylist and compares their first and last names to the keys
    for(int i=0; i<allAppointments.size(); i++){
      //if true the appointment is removed
      if(key.equals(allAppointments.get(i).getFirstName()) && keyLast.equals(allAppointments.get(i).getLastName())){
				found = true;
        System.out.println(allAppointments.get(i).getFirstName() +" "+ keyLast +"'s appointment at "+ allAppointments.get(i).getTime()+" has been removed from the system.");
        allAppointments.remove(i);
      }
    }
    //if the appointment is not found, a message is output
    if(found == false){
      System.out.println("Appointment for "+key+" "+ keyLast+" was not found. Therefore, it cannot be removed.");
    }
  }
  
  //this method removes a prescription
  public static void removePrescription(ArrayList<Prescription> allPrescriptions, String key, String keyLast){

		//checks if the prescription is found, updates throughout program
    boolean found = false;

    //goes through each prescription in the arraylist and compares their first and last names to the keys
    for(int i=0; i<allPrescriptions.size(); i++){
      //if the prescription is found, it is removed
      if(key.equals(allPrescriptions.get(i).getFirstName()) && keyLast.equals(allPrescriptions.get(i).getLastName())){
				found = true;
        System.out.println(allPrescriptions.get(i).getFirstName() + " "+keyLast+"'s prescription has been removed from the system.");
        allPrescriptions.remove(i);
      }
    }
    //if the prescription is not found, a message will be output
    if(found == false){
      System.out.println("Prescription for "+key+" "+keyLast+" was not found. Therefore, it cannot be removed.");
    }
  }
}