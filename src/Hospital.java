public class Hospital {

    ArrayList<String> symptoms = new ArrayList<String>();
    String medicine;
    String doctor;

    Hospital(String doctor, String medicine, ArrayList<String> symptoms) {
        this.doctor = doctor;
        this.medicine = medicine;
        this.symptoms = symptoms;
    }

    ArrayList<String> getSymptoms() {
        return this.symptoms;
    }

    void getMedicine() {
        System.out.println(this.medicine);
    }

    void getDoctor() {
        System.out.println(this.doctor);
    }    
}