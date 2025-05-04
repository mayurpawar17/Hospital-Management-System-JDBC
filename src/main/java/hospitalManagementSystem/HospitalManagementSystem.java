package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/hospital";
    private static final String username = "postgres";
    private static final String password = "mayur123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Scanner scanner = new Scanner(System.in);

        ) {
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);

            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("[1] Add Patient");
                System.out.println("[2] View Patients");
                System.out.println("[3] View Doctor");
                System.out.println("[4] Book Appointment");
                System.out.println("[5] Exit");
                System.out.println();
                System.out.print("Select Option from above: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatient();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctor();
                        System.out.println();
                        break;
                    case 4:
                        bookAppointment(connection, scanner, patient, doctor);
                        System.out.println();

                        break;
                    case 5:
                        System.exit(0);
                        break;

                    default:
                        System.err.println("Enter valid choice");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bookAppointment(Connection connection, Scanner scanner, Patient patient, Doctor doctor) {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        System.out.println("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();

        System.out.println("Enter appointment date (YYYY-MM-DD)");
        String appointmentDate = scanner.next();
        if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)) {
            if (checkDoctorAvailibity(doctorId, appointmentDate, connection)) {
                String appointmentQuery = "insert into appointments (patient_id,doctor_id,appointment_date) values(?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, patientId);
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setString(3, appointmentDate);
                    int rowAffected = preparedStatement.executeUpdate();
                    if (rowAffected > 0) {
                        System.out.println("Appointment Booked");
                    } else {
                        System.out.println("Failed to book Appointment");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("doctor not available on this date");
            }
        } else {
            System.out.println("Either doctor or patient doesn't exit!!");
        }


    }

    private static boolean checkDoctorAvailibity(int doctorId, String appointmentDate, Connection connection) {
        String query = "select count(*) from appointments where doctor_id=? and appointment_date=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, doctorId);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                int count = resultSet.getInt(2);
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}


