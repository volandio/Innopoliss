package StudentsProjects.StudentsWithJDBCAndDAO.DB.DAO;

import StudentsProjects.StudentsWithJDBCAndDAO.DB.ConnectionManagerPostgreSQL;
import StudentsProjects.StudentsWithJDBCAndDAO.DB.IConnectionManager;
import StudentsProjects.StudentsWithJDBCAndDAO.Pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static class StudentDAOException extends Exception {
    }

    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

    public static List<Student> getAll() throws StudentDAOException {
        List<Student> studentList = new ArrayList<>();
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                Student student = new Student(
                    (short) resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("secondName"),
                    resultSet.getString("lastName"),
                    resultSet.getDate("birth_date").toLocalDate());
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
        return studentList;
    }

    public static Student getById(int id) throws StudentDAOException {
        Student student = null;
        try {
            Statement statement = manager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE id = " + id);
            while (resultSet.next()) {
                student = new Student(
                    (short) resultSet.getInt("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("secondname"),
                    resultSet.getString("lastname"),
                    resultSet.getDate("birth_date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
        return student;
    }

    public static void updateById(Student student) throws StudentDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement("UPDATE  student SET firstName = ?" +
                ", lastName = ?, birth_date = ?, secondName = ?, group_id = ? WHERE id = ?");
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getFamilyName());
            statement.setString(4, student.getSecondName());
            statement.setDate(3, Date.valueOf(student.getBdate()));
            statement.setInt(5, 1);
            statement.setInt(6, student.getNum());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
    }

    public static void updateAll(List<Student> studentsList) throws StudentDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement("UPDATE  student SET firstName = ?" +
                ", lastName = ?, birth_date = ?, secondName = ?, group_id = ? WHERE id = ?");
            for (Student student : studentsList) {
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getFamilyName());
                statement.setString(4, student.getSecondName());
                statement.setDate(3, Date.valueOf(student.getBdate()));
                statement.setInt(5, 1);
                statement.setInt(6, student.getNum());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
    }

    public static void deleteStudent(Student student) throws StudentDAOException {
        try {
            Statement statement = manager.getConnection().createStatement();
            int deleteStudent = student.getNum();
            statement.executeUpdate("DELETE FROM student WHERE id = " + deleteStudent);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
    }

    public static void insertOne(Student student) throws StudentDAOException {
        try {
            PreparedStatement statement =
                manager.getConnection().prepareStatement("INSERT INTO student (firstName, lastName, secondName, " +
                    "birth_date, group_id) VALUES(?, ?, ?, ?, ?)");
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getFamilyName());
            statement.setString(3, student.getSecondName());
            statement.setDate(4, Date.valueOf(student.getBdate()));
            statement.setInt(5, 1);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
    }

    public static void insertAll(List<Student> studentsList) throws StudentDAOException {
        try {
            PreparedStatement statement =
                manager.getConnection().prepareStatement("INSERT INTO student (firstName, lastName, secondName, " +
                    "birth_date, group_id) VALUES(?, ?, ?, ?, ?)");
            for (Student student : studentsList) {
                statement.setString(1, student.getFirstName());
                statement.setString(2, student.getFamilyName());
                statement.setString(3, student.getSecondName());
                statement.setDate(4, Date.valueOf(student.getBdate()));
                statement.setInt(5, 1);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentDAOException();
        }
    }
}
