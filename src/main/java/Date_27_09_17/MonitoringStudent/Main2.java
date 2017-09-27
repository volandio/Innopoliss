package Date_27_09_17.MonitoringStudent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        Lesson lesson01 = new Lesson(Date.parse("2017/09/21"), "Параметризованные типы", (short) 1, "Артем");
        Journal journal = new Journal(lesson01);
        Group group01 = new Group(1, "Группа доп. подготовки");

        journal.addGroup(group01);


        Student s01 = new Student((short) 1, "Иван", "Иванович", "Иванов", Date.parse("1994/07/07"));
        journal.addPresentSet(s01);

        printJournal(journal);
        System.out.println("______________________________________________");
        printJournal2(journal);
    }

    public static void printJournal(Journal journal) {
        for (Field f : journal.getClass().getFields()) {
            System.out.println(f.getName() + " " + f.getType() + " " + f.getModifiers());
        }
        for (Method m : journal.getClass().getMethods()) {
            System.out.println(m.getName() + " " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("\t" + p.getName() + " " + p.getType().getName());
            }
        }
    }

    public static void printJournal2(Journal journal) {
        for (Field f : journal.getClass().getDeclaredFields()) {
            System.out.println(f.getClass().getDeclaredFields());
            System.out.println(f.getName() + " " + f.getType() + " " + f.getModifiers());
        }
        for (Method m : journal.getClass().getDeclaredMethods()) {
            System.out.println(m.getName() + " " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("\t" + p.getName() + " " + p.getType().getName());
            }
        }
    }
}
