import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

//Contins all neccessay info that a clinic may have of a Appointment
public class Appointment implements Comparable <Appointment>{
  private final static Scanner KEYBOARD = new Scanner(System.in);
  private String firstName;
  private String lastName;
  private String time; //name of medicine
  private String roomNumber; //amount (e.g. 10mg)
  private String doctor; // how often to take the medicine
  private String reason; //why the medicine will be taken
  
  public Appointment(){
    firstName = "John";
		lastName ="Doe";
    time = "10:00 am";
    roomNumber = "A1";
    doctor = "Dr. Ryan Patel";
    reason = "Routine";
  }

  
  public Appointment(String firstName,String lastName,String time, String roomNumber,String doctor,String reason){//constructor with parameters

    setFirstName(firstName);
    setLastName(lastName);
    setTime(time);
    setRoomNumber(roomNumber);
    setDoctor(doctor);
    setReason(reason);
  }

  //This method when called creates a new Appointment object when a new appointment needs to be added and takes the information from the user and writes into the text file Appointments.txt. 
  //the object created is returned at the end
  public static Appointment createAppointment (){
    
    Appointment a1 = new Appointment ();

    try {
      FileWriter writer = new FileWriter("Appointments.txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);
    
    System.out.println("Enter the First Name");
    a1.setFirstName(KEYBOARD.nextLine());
    System.out.println("Enter the Last Name");
    a1.setLastName(KEYBOARD.nextLine());
    System.out.println("Enter the Time");
    a1.setTime(KEYBOARD.nextLine());
    System.out.println("Enter the Room Number");
    a1.setRoomNumber(KEYBOARD.nextLine());
    System.out.println("Enter the Doctor: ");
    a1.setDoctor(KEYBOARD.nextLine());
    System.out.println("Enter the Reason");
    a1.setReason(KEYBOARD.nextLine());
    
    
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getFirstName());
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getLastName());
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getTime());
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getRoomNumber());
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getDoctor());
    bufferedWriter.newLine();
    bufferedWriter.write(a1.getReason());
    bufferedWriter.newLine();
    
    
    bufferedWriter.close();
    
    return a1;

    } catch (IOException e) {
            e.printStackTrace();
    }

    return a1;
  }

  // This method reads the information in the text file and creates objects and stores it in a new ArrayList. 
  //the arraylist made is returned
  public static ArrayList <Appointment> createAllAppointments() {
    ArrayList <Appointment> createdAppointments = new ArrayList <Appointment>();
     
  try{
    FileReader fr =new FileReader("Appointments.txt");
    BufferedReader reader =new BufferedReader(fr);
    

    while (reader.readLine()!=null) {
    Appointment appointment = new Appointment();
    appointment.setFirstName(reader.readLine());
    appointment.setLastName(reader.readLine());
    appointment.setTime(reader.readLine());
    appointment.setRoomNumber(reader.readLine());
    appointment.setDoctor(reader.readLine());
    appointment.setReason(reader.readLine());

    createdAppointments.add(appointment);
  
    }
    

    } catch (FileNotFoundException ex) 
    {
      return new ArrayList<Appointment>();
    }
    catch(IOException ex){
        System.out.println (ex.toString());
        
    }
    
    return createdAppointments;
  }
  
  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getTime(){
    return time;
  }

  public String getRoomNumber(){
    return roomNumber;
  }
  
  public String getDoctor(){
    return doctor;
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

  public void setTime(String time){
    this.time = time;    
  }

  public void setRoomNumber(String roomNumber){
    this.roomNumber = roomNumber;    
  }

  public void setDoctor(String doctor){
    this.doctor = doctor;    
  }


  public void setReason(String reason){
    this.reason = reason;    
  }

   public String toString(){
    return "\n"+firstName+ "\n"+lastName+ "\n" +time+ "\n" +roomNumber+ "\n"+ doctor+ "\n"+ reason+"\n";
  }

  //This method is used to compare all the appointments in the arraylist and order them from earliest to latest in the day
  public int compareTo(Appointment anotherAppointment){
      return this.getTime().compareTo(anotherAppointment.getTime());
  }

}