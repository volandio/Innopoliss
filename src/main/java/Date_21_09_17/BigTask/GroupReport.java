package Date_21_09_17.BigTask;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupReport implements Serializable {
    Set<String> set = new HashSet<>();
    Journal journal;

    public GroupReport(Journal journal) {
        this.journal = journal;
    }

    public Set<String> getGroupInfo() {
        DateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map.Entry<Student, Boolean> map : journal.getPresentSet().entrySet()) {
            set.add(map.getKey().getFamilyName() + " " + map.getKey().getFirstName() + " " +
                    map.getKey().getSecondName() + ", " + journal.getLesson().getTopic() +
                    ", " + TIMESTAMP.format(journal.getLesson().getDateTime()) + ", " + map.getValue());
        }
        return set;
    }
}
