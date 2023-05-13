import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

public class Prescription{
  private final static Scanner KEYBOARD = new Scanner(System.in);
  private String firstName;
  private String lastName;
  private String medication; //name of medicine
  private String strength; //amount (e.g. 10mg)
  private String frequency; // how often to take the medicine
  private String reason; //why the medicine will be taken

	//default prescription constructor	
  public Prescription(){
    firstName = "John";
    lastName = "Doe";
    medication = "Advil";
    strength = "10";
    frequency = "Everyday";
    reason = "Headaches";
  }

  

	//parameterized prescription constructor
  public Prescription(String firstName,String lastName,String medication, String strength,String frequency,String reason){//constructor with parameters

    setFirstName(firstName);
    setLastName(lastName);
    setMedication(medication);
    setStrength(strength);
    setFrequency(frequency);
    setReason(reason);
  }

	//creating a new prescription
  //This method when called creates a new Prescription object when a new prescription needs to be added and takes the information from the user and writes into the text file Prescriptions.txt
  //the object created is returned at the end
  public static Prescription createPrescription (){
    
    Prescription pr1 = new Prescription ();

		
    try {
      FileWriter writer = new FileWriter("Prescriptions.txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
    
		//getting input from the user
    System.out.println("Enter the First Name:");
    pr1.setFirstName(KEYBOARD.nextLine());
    System.out.println("Enter the Last Name:");
    pr1.setLastName(KEYBOARD.nextLine());
    System.out.println("Enter the Medication:");
    pr1.setMedication(KEYBOARD.nextLine());
    System.out.println("Enter the Strength:");
    pr1.setStrength(KEYBOARD.nextLine());
    System.out.println("Enter the Frequency:");
    pr1.setFrequency(KEYBOARD.nextLine());
    System.out.println("Enter the Reason:");
    pr1.setReason(KEYBOARD.nextLine());
    
		//getting the info
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getFirstName());
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getLastName());
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getMedication());
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getStrength());
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getFrequency());
    bufferedWriter.newLine();
    bufferedWriter.write(pr1.getReason());
    bufferedWriter.newLine();
    bufferedWriter.close();
    
    

		//
    } catch (IOException e) {
            e.printStackTrace();
    }

    return pr1;
  }

  // This method reads the information in the text file and creates objects and stores it in a new ArrayList. 
  //the ArrayList made is returned
  public static ArrayList <Prescription> createAllPrescriptions() {
    ArrayList <Prescription> createdPrescriptions = new ArrayList <Prescription>();
    
  try{
    FileReader fr =new FileReader("Prescriptions.txt");
    BufferedReader reader =new BufferedReader(fr);
    

    while (reader.readLine()!=null) {
    Prescription prescription = new Prescription();
    prescription.setFirstName(reader.readLine());
    prescription.setLastName(reader.readLine());
    prescription.setMedication(reader.readLine());
    prescription.setStrength(reader.readLine());
    prescription.setFrequency(reader.readLine());
    prescription.setReason(reader.readLine());

    createdPrescriptions.add(prescription);
  
    }
    

    } catch (FileNotFoundException ex) 
    {
      return new ArrayList<Prescription>();
    }
    catch(IOException ex){
        System.out.println (ex.toString());
        
    }
    
    return createdPrescriptions;
  }

  
  //getters
  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getMedication(){
    return medication;
  }

  public String getStrength(){
    return strength;
  }
  
  public String getFrequency(){
    return frequency;
  }
  
  public String getReason(){
    return reason;
  }


  //setters
  public void setFirstName(String firstName){
    this.firstName = firstName;    
  }

  public void setLastName(String lastName){
    this.lastName = lastName;    
  }

  public void setMedication(String medication){
    this.medication = medication;    
  }

  public void setStrength(String strength){
    this.strength = strength;    
  }

  public void setFrequency(String frequency){
    this.frequency = frequency;    
  }


  public void setReason(String reason){
    this.reason = reason;    
  }

	//toString for output
  public String toString(){
    return "\n"+firstName+ "\n"+lastName+ "\n" +medication+ "\n" +strength+ "\n"+ frequency+ "\n"+ reason+"\n";
  }
   

}




  

  
  

