import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    ArrayList<Hospital> hospital = new ArrayList<Hospital>();

    public void loadFile(String filePath) throws IOException{

        FileReader fread = new FileReader(filePath);
        BufferedReader bread = new BufferedReader(fread);
        String line;

        while((line = bread.readLine()) != null) {
            
            String expertSystem[] = line.split(" ");
            ArrayList<String> symptoms = new ArrayList<String>();
            for(int i=2; i<expertSystem.length; i++){
                symptoms.add(expertSystem[i];)
            }
            Hospital a = new Hospital(expertSystem[0], expertSystem[1], symptoms);
            hospital.add(a);
        }

        bread.close();
        fread.close();
    }
    public void storeFile(String filePath) throws IOException {
        
        FileWriter fwrite = new FileWriter(filePath, false);
        BufferedWriter bwrite = new BufferedWriter(fwrite);

        for(Hospital a: hospital){
            String symptoms = "";
            for(String symptom: a.symptoms ){
                symptoms += " " + symptom ;  
            }
            String line = a.doctor + " " + a.medicine  + symptoms "\n";
            bwrite.write(line);
        }

        bwrite.close();
        fwrite.close();
        System.exit(0);
    }

    public ArrayList<String> getUserSymptoms(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Symptoms:(Enter E to denote end of symptoms)");
        ArrayList<String> symptoms = new ArrayList<String>();
        do{
            System.out.println("Enter Symptom:");
            String symptom = scan.nextLine();
            if(symptom.equals("E")){
                break;
            }else{
                symptoms.add(symptom);
            }
        }while(true);
        return symptoms;
    }

    public void checkSymptoms(){
        ArrayList<String> symptoms = this.getUserSymptoms();
        int flag = 0;
        for(Hospital a: hospital){
            ArrayList<String> currentSymptom = a.getSymptoms();
            for(int i=0;i<symptoms.size();i++){
                for(int j=0;j<currentSymptom.size();j++){
                    if(symptoms.get(i).equals (currentSymptom.get(i)){
                        flag += 1;
                    }else{
                        break;
                    }
                }
            }
            
        }
        if(flag = symptoms.size()){
            a.getMedicine();
            a.getDoctor();
        }
        else{
            System.out.println("No Solution available for your symptom");
        }
    }

    public void addDetails(){
        System.out.println("Enter Medicine:");
        String medicine = scan.nextLine();
        System.out.println("Enter Doctor:");
        String doctor = scan.nextLine();
        ArrayList<String> symptoms = this.getUserSymptoms();
        Hospital a = new Hospital(doctor, medicine, symptoms);
        hospital.add(a);
    }

    public static void main(String[] Args)throws IOException {
        Scanner scan = new Scanner(System.in);

        Main ob = new Main();

        int choice;

        ob.loadFile("Hospital.txt");

        do{
            ob.getUserSymptoms();
            System.out.println("1-Add Symptoms 2-Check Symptoms 3-Exit");
            System.out.println("Enter your choice : ");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    ob.addSymptoms();
                    break;

                case 2:
                    ob.checkSymptoms();
                    break;

                case 3:
                    ob.storeFile("Hospital.txt");
                    exit(0);
                    break;
            }

        }while(true);
    }
}