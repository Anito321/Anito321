import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Student {
    private final int studentNumber;
    private final Collection <Section> sections;

    Student(int studentNumber) {
        this.studentNumber = studentNumber;

        Student(int studentNumber) {
            if (studentNumber < 0) {
                throw new IllegalArgumentExecption("StudentNumber must be non-zero, "+ studentNumber);
            }
            if (sections == null){
                throw new NullPointerException("section can't be null");
            }
            this.sections = new ArrayList<>(sections);
            this.sections.removeIf(Objects::isNull);
            this.studentNumber = studentNumber;
        }
    }

    void enlist(Section section){
        if (section == null){
            throw new NullPointerException("section can't be null");
        }
        sections.add(section);
    }

    class Section{
        private final Schedule schedule;
        ...Schedule getSchedule() {
            return schedule;
        }

    }

    public String toString(){
        return "Student #" + studentNumber;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student)) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return studentNumber == student.studentNumber;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), studentNumber);
    }
}
