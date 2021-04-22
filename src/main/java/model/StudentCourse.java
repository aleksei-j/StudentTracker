package model;

import java.io.Serializable;
import java.util.List;

public class StudentCourse implements Serializable {

    private List<Course> studentCourses;
    private Student student;

    public StudentCourse(List<Course> studentCourses, Student student) {
        EntriesInMemory INSTANCE = EntriesInMemory.getINSTANCE();
        this.studentCourses = studentCourses;
        student.setStudentRoll(INSTANCE.getCurrentAvailableRollAndIncrement());
        this.student = student;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }
    public Student getStudent() { return student; }

}
