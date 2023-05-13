import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

//Contins all neccessay info that a clinic may have of a patient
public class Patient implements Comparable <Patient> {
  private final static Scanner KEYBOARD = new Scanner(System.in);
  //General Info
  private String firstName;
  private String lastName;
  private String sex;
  private String age;
  private String postalCode;
  private String address;
  private String email;
  private String privateInsurance;
  private String patientID;
   
  
  public Patient(){ //default constructor
    firstName = "John";
		lastName ="Doe";
    age = "0";
    sex = "M";
    address = "unknown";
    postalCode = "000 000";
    patientID = "00000000";
    email = "unknown@gmail.com";
		privateInsurance = "unknown";
  }
  public Patient(String firstName,String lastName,String age,String postalCode,String sex,String address,String email,String privateInsurance,String patientID){//constructor with parameters

    
    setFirstName(firstName);
    setLastName(lastName);
    setAge(age);
    setSex(sex);
    setAddress(address);
    setEmail(email);
    setPrivateInsurance(privateInsurance);
    setPostalCode(postalCode);
    setPatientID(patientID);
  
  }
  //This method when called creates a new Patient object when a new pateint needs to be added and takes the information from the user and writes into the text file Patient.txt. 
  //the object created is returned at the end
  public static Patient createPatient(){
    
    Patient p1 = new Patient ();


    try {
      FileWriter writer = new FileWriter("Patients.txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
    
    
    
    System.out.println("Enter the First Name:");
    p1.setFirstName(KEYBOARD.nextLine());
    System.out.println("Enter the Last Name:");
    p1.setLastName(KEYBOARD.nextLine());
    System.out.println("Enter the Age (AA):");
    p1.setAge(KEYBOARD.nextLine());
    System.out.println("Enter the Sex (M/F):");
    p1.setSex(KEYBOARD.nextLine());
    System.out.println("Enter the Postal Code: (PPP PPP):");
    p1.setPostalCode(KEYBOARD.nextLine());
    System.out.println("Enter the Address:");
    p1.setAddress(KEYBOARD.nextLine());
    System.out.println("Enter the Email (example@gmail.com):");
    p1.setEmail(KEYBOARD.nextLine());
    System.out.println("Enter the Insurance:");
    p1.setPrivateInsurance(KEYBOARD.nextLine());
    System.out.println("Enter the PatientID (000000):");
    p1.setPatientID(KEYBOARD.nextLine());

    bufferedWriter.newLine();
    bufferedWriter.write(p1.getFirstName());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getLastName());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getAge());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getSex());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getPostalCode());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getAddress());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getEmail());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getPrivateInsurance());
    bufferedWriter.newLine();
    bufferedWriter.write(p1.getPatientID());
    bufferedWriter.newLine();
    
    
    bufferedWriter.close();

    return p1;

    } catch (IOException e) {
            e.printStackTrace();
    }

    return p1;
  }
  // This method reads the information in the text file and creates objects and stores it in a new ArrayList. 
  //the arraylist made is returned 
  public static ArrayList <Patient> createAllPatients() {
    ArrayList <Patient> createdPatients = new ArrayList <Patient>();

  try{
    FileReader fr =new FileReader("Patients.txt");
    BufferedReader reader =new BufferedReader(fr);
    

    while (reader.readLine()!=null) {
    Patient patient = new Patient();
    patient.setFirstName(reader.readLine());
    patient.setLastName(reader.readLine());
    patient.setAge(reader.readLine());
    patient.setSex(reader.readLine());
    patient.setPostalCode(reader.readLine());
    patient.setAddress(reader.readLine());
    patient.setEmail(reader.readLine());
    patient.setPrivateInsurance(reader.readLine());
    patient.setPatientID(reader.readLine());

    createdPatients.add(patient);
  
    }
    

    } catch (FileNotFoundException ex) 
    {
      return new ArrayList<Patient>();
    }
    catch(IOException ex){
        System.out.println (ex.toString());
        
    }
    
    return createdPatients;
  }

  
  
  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getSex(){
    return sex;
  }

  public String getAge(){
    return age;
  }
  
  public String getPostalCode(){
    return postalCode;
  }
  
  public String getAddress(){
    return address;
  }

  
  public String getEmail(){
    return email;
  }
  
  public String getPrivateInsurance(){
    return privateInsurance;
  }
  
  public String getPatientID(){
    return patientID;
  }

  //setters
  

  public void setFirstName(String firstName){
    this.firstName = firstName;    
  }

  public void setLastName(String lastName){
    this.lastName = lastName;    
  }

  public void setSex(String sex){
    this.sex = sex;    
  }

  public void setAge(String age){
    this.age = age;    
  }

  public void setPostalCode(String postalCode){
    this.postalCode = postalCode;    
  }


  public void setAddress(String address){
    this.address = address;    
  }

  public void setEmail(String email){
    this.email = email;    
  }

  public void setPrivateInsurance(String privateInsurance){
    this.privateInsurance = privateInsurance;    
  }
  
  public void setPatientID(String patientID){
    this.patientID = patientID;    
  }

  public String toString(){
    return "\n"+firstName+ "\n"+lastName+ "\n" +age+ "\n" +sex+ "\n"+ address+ "\n"+ postalCode+"\n"+email + "\n" + privateInsurance + "\n"+patientID+"\n";
  }

  //This method is used to compare the different patients in the arraylist and order them using their first name in alphabetical order
  public int compareTo(Patient anotherPatient){
      return this.getFirstName().compareTo(anotherPatient.getFirstName());
  }

}