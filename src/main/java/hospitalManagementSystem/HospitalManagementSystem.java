package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/hospital";
    private static final String username = "postgres";
    private static final String password = "mayur123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password); Scanner scanner = new Scanner(System.in);

        ) {
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);

            while (true) {
                System.out.println("[1] Add Patient");
                System.out.println("[2] View Patients");
                System.out.println("[3] View Patient By ID");
                System.out.println("[4] View Doctor");
                System.out.println("[5] View Doctor By ID");
                System.out.println("[6] Exit");
                System.out.print("Select Option from above: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        patient.addPatient();
                        break;
                    case 2:
                        patient.viewPatient();
                        break;
                    case 3:
//                        patient.getPatientById() break;
                    case 4:
                        doctor.viewDoctor();
                        break;
                    case 5:
//                        doctor.getDoctorById() break;
                    case 6:
                        System.exit(0);
                        break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


