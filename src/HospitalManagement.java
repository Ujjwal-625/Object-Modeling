import java.util.ArrayList;
import java.util.List;

class Patient {
    private String patientName;
    private int patientId;

    public Patient(String patientName, int patientId) {
        this.patientName = patientName;
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientName='" + patientName + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

class Doctor {
    private String doctorName;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String doctorName, String specialization) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addPatient(Patient patient){
        this.patients.add(patient);
    }

    public List<Patient> getPatients(){
        return patients;
    }

    public void consult(Patient patient) {
        System.out.println(doctorName + " (Specialization: " + specialization + ") is consulting with " + patient.getPatientName() + " (ID: " + patient.getPatientId() + ").");
        addPatient(patient);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalName='" + hospitalName + '\'' +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City General Hospital");

        Doctor doctor1 = new Doctor("Dr. Alice", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Bob", "Pediatrics");
        Doctor doctor3 = new Doctor("Dr. Carol", "Dermatology");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);

        Patient patient1 = new Patient("Eve", 1001);
        Patient patient2 = new Patient("Frank", 1002);
        Patient patient3 = new Patient("Grace", 1003);

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);

        doctor1.consult(patient1);
        doctor1.consult(patient3);
        doctor2.consult(patient2);
        doctor3.consult(patient1);
        doctor3.consult(patient2);
        doctor3.consult(patient3);

        System.out.println("\n" + hospital);
        System.out.println("\n" + doctor1);
        System.out.println("Patients: " + doctor1.getPatients());
        System.out.println("\n" + doctor3);
        System.out.println("Patients: " + doctor3.getPatients());
    }
}