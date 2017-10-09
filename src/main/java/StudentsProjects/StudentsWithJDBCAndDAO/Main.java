package StudentsProjects.StudentsWithJDBCAndDAO;

import StudentsProjects.StudentsWithJDBCAndDAO.DB.DAO.StudentDAO;
import StudentsProjects.StudentsWithJDBCAndDAO.Pojo.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static StudentsProjects.StudentsWithJDBCAndDAO.DB.DAO.StudentDAO.updateById;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student((short) 6, "Max", "Ivanovich", "Petrov",
            LocalDate.of(1995, 10, 8));
        Student st2 = new Student((short) 7, "Ivan", "DA", "Sidorov",
            LocalDate.of(2005, 9, 9));
        Student st3 = new Student((short) 8, "Parker", "Pontileevich", "Ivanov",
            LocalDate.of(2015, 8, 10));
        List<Student> studentsList = Arrays.asList(st1, st2, st3);
//        try {
//            List<Student> studentList = StudentDAO.getAll();
//            for (Student student : studentList) {
//                System.out.println(student.toString());
//            }
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(getById(2));
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
//        try {
        try {
            updateById(st2);
        } catch (StudentDAO.StudentDAOException e1) {
            e1.printStackTrace();
        }
    }
//        try {
//            deleteStudent(st3);
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
//        try {
//            insertOne(st2);
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
//        try {
//            insertAll(studentsList);
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
//        try {
//            updateAll(studentsList);
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
}

