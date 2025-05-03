# 🏥 Hospital Management System 

A Java-based Hospital Management System that allows efficient management of patients, doctors, appointments, and medical records using JDBC and PostgreSQL. This project was developed using **IntelliJ IDEA** and follows a modular structure using **Maven**.

## 🚀 Features

- Add, update, and delete patient records
- Manage doctor information
- Schedule and view appointments
- Store and retrieve medical records
- PostgreSQL used as the backend database
- JDBC for database connectivity
- Maven for dependency management and build automation

> **Note:** Billing functionality is not included in this version.

## 🛠️ Technologies Used

- Java (JDK 8+)
- JDBC
- PostgreSQL
- Maven
- IntelliJ IDEA

## 📁 Project Structure

```
HospitalManagementSystem/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/hms/...
│ │ └── resources/
├── pom.xml
└── README.md
```

## 🗃️ Database Setup

1. Install PostgreSQL and create a database:
   ```sql
   CREATE DATABASE hospital_db;
   ```

2. Execute the provided SQL script (if available) to create tables:

   ```sql
   \c hospital_db
   -- Run CREATE TABLE statements here
   ```

3. Update database credentials in the Java source file where the connection is established:

   ```java
   String url = "jdbc:postgresql://localhost:5432/hospital_db";
   String user = "your_username";
   String password = "your_password";
   ```



## 🧑‍💻 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/hospital-management-system.git
   ```

2. Open the project in IntelliJ IDEA.

3. Configure the PostgreSQL database connection if needed.

4. Build and run the project from IntelliJ.

## 📌 Future Improvements

- Add billing feature
- Add user authentication and role management
- Improve GUI (if using Swing/JavaFX)
- Add REST API layer (Spring Boot integration)

## 📝 License

This project is for educational purposes. Feel free to use and modify.

