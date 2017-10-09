package StudentsProjects.MonitoringStudentWithSerializeAndDAO;

import StudentsProjects.MonitoringStudentWithSerializeAndDAO.ClassesProject.Student;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseManagerExample {
    public static void main(String[] args)
        throws ClassNotFoundException {
        saveStudent(
            new Student((short) 0, "Сара", "Луиза", "Коннор",
                LocalDate.of(1995, 10, 25)));
        showStudents();
    }

    public static void showStudents() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;
        try {
            connection =
                DriverManager
                    .getConnection(
                        "jdbc:postgresql://localhost:5432/students",
                        "postgres",
                        "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                .executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                Student student = new Student(
                    (short) resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("secondName"),
                    resultSet.getString("lastName"),
                    resultSet.getDate("birth_date").toLocalDate());
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudent(Student student) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;
        try {
            connection =
                DriverManager
                    .getConnection(
                        "jdbc:postgresql://localhost:5432/students",
                        "postgres",
                        "root");

            PreparedStatement statement =
                connection.prepareStatement("INSERT INTO student (firstName, lastName, secondName, birth_date, group_id) VALUES(?, ?, ?, ?, ?)");
            statement.setString(1,
                student.getFirstName());
            statement.setString(2,
                student.getFamilyName());
            statement.setString(3,
                student.getSecondName());
            statement.setDate(4,
                Date.valueOf(student.getBdate()));
            statement.setInt(5, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
