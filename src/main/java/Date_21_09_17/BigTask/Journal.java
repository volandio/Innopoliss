package Date_21_09_17.BigTask;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Journal implements Serializable {
    private Lesson lesson;
    private Map<Student, Boolean> presentSet = new HashMap<>();
    //  private Set<Student> presentSet = new HashSet<>();
    private Set<Group> groups = new HashSet<>();

    public Set<Group> getGroups() {
        return groups;
    }

    public void setPresentSet(Map<Student, Boolean> presentSet) {
        this.presentSet = presentSet;
    }

    public Map<Student, Boolean> getPresentSet() {

        return presentSet;
    }

    public Journal(Lesson lesson, Map<Student, Boolean> presentSet) {
        this.lesson = lesson;
        this.presentSet = presentSet;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

//  public Journal(Lesson lesson, Set<Student> presentSet) {
//    this.lesson = lesson;
//    this.presentSet = presentSet;
//  }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

//  public Set<Student> getPresentSet() {
//    return presentSet;
//  }
//
//  public void setPresentSet(Set<Student> presentSet) {
//    this.presentSet = presentSet;
//  }
}
