package StudentsProjects.StudentsWithJDBCAndDAO.Pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private short num;
    private String firstName;
    private String secondName;
    private String familyName;
    private  LocalDate bdate;

    public void setBdate(LocalDate bdate) {
        this.bdate = bdate;
    }

    public Student(short num, String fName, String sName, String familyName, LocalDate bdate) {
        this.num = num;
        this.firstName = fName;
        this.secondName = sName;

        this.familyName = familyName;
        this.bdate = bdate;
    }

    public short getNum() {
        return num;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public LocalDate getBdate() {
        return bdate;
    }

    public void setNum(short num) {
        this.num = num;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        return "Student{" +
            "num=" + num +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            ", familyName='" + familyName + '\'' +
            ", bdate=" + bdate +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getNum() != student.getNum()) return false;
        if (getFirstName() != null ? !getFirstName().equals(student.getFirstName()) : student.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(student.getSecondName()) : student.getSecondName() != null)
            return false;
        if (getFamilyName() != null ? !getFamilyName().equals(student.getFamilyName()) : student.getFamilyName() != null)
            return false;
        return getBdate() != null ? getBdate().equals(student.getBdate()) : student.getBdate() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) getNum();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getFamilyName() != null ? getFamilyName().hashCode() : 0);
        result = 31 * result + (getBdate() != null ? getBdate().hashCode() : 0);
        return result;
    }
}
