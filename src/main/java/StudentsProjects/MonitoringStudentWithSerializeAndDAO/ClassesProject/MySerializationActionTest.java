package StudentsProjects.MonitoringStudentWithSerializeAndDAO.ClassesProject;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MySerializationActionTest {
    @Test
    void readJournal() throws IOException, ClassNotFoundException {
        ObjectInputStream mockStream = mock(ObjectInputStream.class);
        Lesson lesson01 = new Lesson(Date.parse("2017/09/21"), "Параметризованные типы", (short) 1, "Артем");

        try {
            when(mockStream.readUnshared()).thenReturn(new Journal(lesson01));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        HashSet<Journal> journals = new HashSet<>();
        Student s01 = new Student((short) 5, "Вера", "Петровна", "Жигалова", LocalDate.of(2000, 10, 29));
        Group group01 = new Group(1, "Группа доп. подготовки");
        group01.addStudent(s01);
        journals.add((Journal) mockStream.readUnshared());
        String result= Main.journalAttendanceGroup(journals,group01);
    }

}