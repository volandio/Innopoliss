package September2017.Date_29_09_17;

import StudentsProjects.StudentsFirst.Student;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Date;

public class MyParserStudent {
    public static void main(String[] args) throws Exception {
        Student s01 = new Student((short) 1, "Иван", "Иванович", "Иванов", Date.parse("1994/07/07"));
        createXML("src/Main/java/September2017.Date_29_09_17/result.xml", s01);
    }

    public static void createXML(String fileName, Student student) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

        DOMImplementation implementation = documentBuilder.getDOMImplementation();

        Document document = implementation.createDocument(null, null, null);
        Element element = document.createElement("fields");
        Element element2 = document.createElement("num");
        document.appendChild(element);
        element.appendChild(element2);
        Field field = Student.class.getDeclaredField("firstName");
        field.setAccessible(true);


        element2.setTextContent((String) field.get(student));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File(fileName));
        Source source = new DOMSource(document);
        transformer.transform(source, output);
    }
}
