package September2017.Date_29_09_17;

import StudentsProjects.StudentsFirst.Student;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Date;

public class MainParserJaxb {
    public static void main(String[] args) throws JAXBException {
        Student s01 = new Student((short) 1, "Иван", "Иванович", "Иванов",
                Date.parse("1994/07/07"));
        JaxbParser jaxbParser = new JaxbParser();
        File file = new File("ABC.xml");
        jaxbParser.saveObject(file, s01);

        Student s02;
        s02 = (Student) jaxbParser.getObject(file, Student.class);
        System.out.println(s02);
    }
}
