package view;

import model.*;

import java.util.ArrayList;

public class ViewEntries {

    static EntriesInMemory INSTANCE = EntriesInMemory.getINSTANCE();

    public static void displayUserDetailsByNameAscending() {
        Messages.studentInfoHeader();
        printEntry(INSTANCE.getList());
    }

    public static void displayUserDetailsByNameDescending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByNameDescending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsByRollNumberAscending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByRollNumberAscending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsByRollNumberDescending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByRollNumberDescending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsAgeAscending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByAgeAscending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsAgeDescending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByAgeDescending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsAddressAscending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByAddressAscending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static void displayUserDetailsAddressDescending() {
        ArrayList<StudentCourse> sorted = new ArrayList<>(INSTANCE.getList());
        sorted.sort(new Sort.sortByAddressDescending());
        Messages.studentInfoHeader();
        printEntry(sorted);
    }

    public static String coursesInLine(StudentCourse studentCourse) {
        String coursesInLine = "";
        for (Course course : studentCourse.getStudentCourses()) {
            coursesInLine += course.getCourseName() + ", ";
        }
        return coursesInLine.replaceAll(", $", "");
    }

    public static void printEntry(ArrayList<StudentCourse> studentCourseList) {
        for (StudentCourse studentCourse : studentCourseList) {
            System.out.printf("%-16s %-13d %-5d %-20s %-8s\n", studentCourse.getStudent().getFullName(),
                    studentCourse.getStudent().getStudentRoll(), studentCourse.getStudent().getAge(),
                    studentCourse.getStudent().getAddress(), coursesInLine(studentCourse));
        }
    }

    public static void printSingleEntry(StudentCourse studentCourse) {
        System.out.printf("%-16s %-13d %-5d %-20s %-8s\n", studentCourse.getStudent().getFullName(),
                studentCourse.getStudent().getStudentRoll(), studentCourse.getStudent().getAge(),
                studentCourse.getStudent().getAddress(), coursesInLine(studentCourse));
    }
}
