package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Doctor {
    private Connection connection;


    public Doctor(Connection connection) {
        this.connection = connection;

    }


    public void viewDoctor() {
        String query = "select * from doctor";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctor: ");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.println("ID: " + id + " Name: " + name + " Specialization: " + specialization);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getDoctorById(int id) {
        String query = "select * from doctor where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}


