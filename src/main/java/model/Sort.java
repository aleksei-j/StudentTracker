package model;

import model.StudentCourse;

import java.util.Comparator;

public class Sort {

    public static class sortByNameAscending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getFullName().equals(o2.getStudent().getFullName())) {
                return o1.getStudent().getStudentRoll() - o2.getStudent().getStudentRoll();
            }
            return o1.getStudent().getFullName().compareTo(o2.getStudent().getFullName());
        }
    }

    public static class sortByNameDescending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getFullName().equals(o2.getStudent().getFullName())) {
                return o2.getStudent().getStudentRoll() - o1.getStudent().getStudentRoll();
            }
            return o2.getStudent().getFullName().compareTo(o1.getStudent().getFullName());
        }
    }

    public static class sortByRollNumberAscending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {
            return o1.getStudent().getStudentRoll() - (o2.getStudent().getStudentRoll());
        }
    }

    public static class sortByRollNumberDescending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {
            return o2.getStudent().getStudentRoll() - (o1.getStudent().getStudentRoll());
        }
    }

    public static class sortByAgeAscending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getAge() == (o2.getStudent().getAge())) {
                return o1.getStudent().getStudentRoll() - o2.getStudent().getStudentRoll();
            }
            return o1.getStudent().getAge() - (o2.getStudent().getAge());
        }
    }

    public static class sortByAgeDescending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getAge() == (o2.getStudent().getAge())) {
                return o2.getStudent().getStudentRoll() - o1.getStudent().getStudentRoll();
            }
            return o2.getStudent().getAge() - (o1.getStudent().getAge());
        }
    }

    public static class sortByAddressAscending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getAddress().equals(o2.getStudent().getAddress())) {
                return o1.getStudent().getStudentRoll() - o2.getStudent().getStudentRoll();
            }
            return o1.getStudent().getAddress().compareTo(o2.getStudent().getAddress());
        }
    }

    public static class sortByAddressDescending implements Comparator<StudentCourse> {

        @Override
        public int compare(StudentCourse o1, StudentCourse o2) {

            if (o1.getStudent().getAddress().equals(o2.getStudent().getAddress())) {
                return o2.getStudent().getStudentRoll() - o1.getStudent().getStudentRoll();
            }
            return o2.getStudent().getAddress().compareTo(o1.getStudent().getAddress());
        }
    }
}
