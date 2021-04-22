package input;

import model.Course;
import model.EntriesInMemory;
import model.Messages;
import model.StudentCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InputValidator {

    public static boolean yesNoValidation(String string) {
        ArrayList<String> valid = new ArrayList<>(Arrays.asList("yes", "y", "no", "n"));
        if (valid.contains(string.toLowerCase(Locale.ROOT)))
            return true;
        return false;
    }

    public static boolean userRollNumberCheck(int rollNumber) {
        EntriesInMemory INSTANCE = EntriesInMemory.getINSTANCE();

        for (StudentCourse studentCourse : INSTANCE.getList()) {
            if (rollNumber == studentCourse.getStudent().getStudentRoll())
                return true;
        }
        return false;
    }

    public static boolean mainMenuOptionValidator(List<Course> courseList, int optionNumber) {

        if (optionNumber < 1 || optionNumber > courseList.size())
            return false;
        return true;
    }

    public static boolean studentAgeValidator(int age) {

        if (age <= 0 || age > 130)
            return false;
        return true;
    }

    public static boolean studentNameValidator(String name) {

        if (name.matches("^[a-zA-Z\\s]+") && !name.trim().equals(""))
            return true;

        return false;
    }

    public static boolean validateCourseName(String courseName, List<Course> courseList, List<Course> selectedCourses) {

        if (courseList.stream().anyMatch(x -> x.getCourseName().equals(courseName.toUpperCase()))) {

            if (selectedCourses.stream().anyMatch(x -> x.getCourseName().equals(courseName.toUpperCase()))) {
                Messages.courseAlreadySelected(courseName.toUpperCase());
                return false;
            } else {
                Messages.courseAdded(courseName.toUpperCase());
                selectedCourses.add(courseList.stream().filter(x -> x.getCourseName().equals(courseName.toUpperCase())).findFirst().get());
                return true;
            }
        } else {
            Messages.courseNameError(courseName);
            Messages.coursePromptMessage();
            return false;
        }
    }

    public static boolean validateCourseNameExit(String exit) {
        return exit.trim().equalsIgnoreCase("EXIT");
    }
}
