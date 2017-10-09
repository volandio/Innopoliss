package StudentsProjects.StudentsFirst;

import java.io.*;
import java.util.Set;

public class MySerializationAction {

    static void serializeGroupByAttendance(Set set) throws IOException {
        File file = new File("journal_gr.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(set);
    }

    static Set readGroupByAttendance(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Set<String> set = (Set<String>) ois.readObject();
        return set;
    }

    static Group readGroup(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Group group = (Group) ois.readObject();
        return group;
    }

    static void serializeGroup(Group group) throws IOException {
        File file = new File("group.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(group);
    }
}
