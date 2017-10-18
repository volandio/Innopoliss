package September2017.Date_29_09_17.xmls;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.parse(new File("src/Main/ural/September2017.Date_29_09_17/Order.xml"));
//        parseXML(document);
        createXML("src/Main/ural/September2017.Date_29_09_17/newOrder.xml");
    }

    public static void parseXML(Node document) {
        NodeList tags = document.getChildNodes();
        for (int i = 0; i < tags.getLength(); i++) {
            Node node = tags.item(i);
            System.out.println(node.getNodeName());

            if (node instanceof Element) {
                Element elem = (Element) node;
                System.out.println(elem.getTextContent());
            } else {
                parseXML(node);
            }
        }
    }

    public static void createXML(String fileName) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

        DOMImplementation implementation = documentBuilder.getDOMImplementation();

        Document document = implementation.createDocument(null, null, null);
        Element element = document.createElement("Person");
        element.setTextContent("sdf");
        document.appendChild(element);


        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File(fileName));
        Source source = new DOMSource(document);
        transformer.transform(source, output);
    }


}
