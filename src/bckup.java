import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    /*Create an ArrayList which is made up of objects of the ATM Class where each
    object stores the details of an individual user */
    ArrayList<Hospital> hospital = new ArrayList<Hospital>();

    public void loadFile(String filePath) throws IOException{

        /*This function reads the file line by line. In the file each line contains the details of every user, each
        detail is delimited by a whitespace. So, the first word contains the Name, the second contains the account
        Number and the third contains the amount available in the respective account.*/

        FileReader fread = new FileReader(filePath);
        BufferedReader bread = new BufferedReader(fread);

        String line;//Line variable to store a single line from the file.

        while((line = bread.readLine()) != null) {
            //loop until end of the file.
            /*Split the line with whitespace as the delimiter*/
            String symptomDetails[] = line.split(" ");
            /*Next, create an object for the ATM class and pass the name, account number and amount to the
            constructor in the same order*/
            Hospital a = new Hospital(accountDetails[0], (accountDetails[1]), (accountDetails[2]));
            /*Add the newly created object to the ArrayList*/
            hospital.add(a);
        }
        bread.close();
        fread.close();

    }
    public void storeFile(String filePath) throws IOException {
        /*This function is used to store the customer details to the file by retrieving individual objects from
        the ArrayList. Using a for each loop we retrieve each element from the ArrayList, where each element
        is an object of the ATM class. Then we add the customer details into the file where each line
        consists of details about one customer ONLY.*/
        FileWriter fwrite = new FileWriter(filePath, false);
        BufferedWriter bwrite = new BufferedWriter(fwrite);

        for(ATM a: hospital){
            String line = a.symptoms + " " + a.medicine + " " + a.doctor + "\n";
            bwrite.write(line);
        }

        bwrite.close();
        fwrite.close();
        System.exit(0);
    }

    public void getUserSymptoms(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Symptoms:(Enter E to denote end of symptoms)");
        ArrayList<String> symptoms = new ArrayList<String>();
        do{
            System.out.println("Enter Symptoms:");
            String temp = scan.nextLine();
            if(temp.equals("E")){
                break;
            }
            else{
                symptoms.add(temp);
            }
        }while(true);
    }

    public void checkSymptoms(){
        for(Hospital a: hospital){
            if(a.getSymptoms() == symptoms){
                a.getMedicine();
                a.getDoctor();
                break;
            }
        }
    }

    public void addSymptoms(){
        
        System.out.println("Enter Medicine:");
        String medicine = scan.nextLine();
        System.out.println("Enter Doctor:");
        String doctor = scan.nextLine();
        Hospital a = new Hospital(symptoms, medicine, doctor);
        hospital.add(a);
    }

    public static void main(String[] Args)throws IOException {
        Scanner scan = new Scanner(System.in);

        Main ob = new Main();

        int choice;

        ob.loadFile("Hospital.txt");

        do{
            ob.getUserSymptoms();
            System.out.println("1-Check Symptoms 2-Add Symptoms 3-Exit");
            System.out.println("Enter your choice : ");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    ob.checkMed();
                    break;

                case 2:
                    ob.addDetails();
                    ob.storeFile("Hospital.txt");
                    break;

                case 3:
                    exit(0);
                    break;
            }

        }while(true);
    }
}
