package September2017.Date_29_09_17;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface Parser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;
}
