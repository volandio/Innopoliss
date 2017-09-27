package Date_21_09_17.BigTask;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String... args) {
        Group group01 = new Group(1, "Группа доп. подготовки");

        Student s01 = new Student((short) 1, "Иван", "Иванович",
                "Иванов", Date.parse("1995/07/07"));

        Student s02 = new Student((short) 2, "Петр", "Иванович",
                "Иванов", Date.parse("1995/07/07"));

        Student s03 = new Student((short) 3, "Сергей",
                "Иванович", "Иванов", Date.parse("1995/07/07"));

        group01.addStudent(s01);
        group01.addStudent(s02);
        group01.addStudent(s03);

        Lesson lesson01 = new Lesson(Date.parse("2017/09/21"), "Параметризованные типы", (short) 1,
                "Артем");

        Map<Student, Boolean> studentPresent = new HashMap<>();
        studentPresent.put(s01, true);
        studentPresent.put(s02, false);
        studentPresent.put(s03, true);
        Journal journal01 = new Journal(lesson01, studentPresent);

//        try {
//            MySerializationAction.serializeGroup(group01);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Group restoredGroup = MySerializationAction.readGroup("group.txt");
//            System.out.println(restoredGroup.getGroupName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        GroupReport groupReport = new GroupReport(journal01);


        try {
            MySerializationAction.serializeGroupByAttendance(groupReport.getGroupInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Set<String> set = MySerializationAction.readGroupByAttendance("journal_gr.txt");
            for (String str : set) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
