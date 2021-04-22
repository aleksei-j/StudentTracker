package input;

import model.*;
import view.ViewEntries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InputAcceptor {

    private List<Course> courseList = new ArrayList<>();

    public InputAcceptor () {
        readCourseListFile("courseList.txt");
    }

    public static String yesNoAcceptor(Scanner scanner, String message) {
        String input = "";
        boolean exit = false;
        ArrayList<String> yesOption = new ArrayList<>(Arrays.asList("yes", "y"));

        while(!exit) {
            System.out.print(message);
            input = scanner.nextLine();
            if (InputValidator.yesNoValidation(input)) {
                if (yesOption.contains(input.toLowerCase()))
                    input = "Yes";
                else
                    input = "No";
                exit = true;
            }
        }
        return input;
    }

    public int deleteUserRollNumber(Scanner scanner) {

        int choice = 0;
        String input = "";
        boolean valid = false;
        ViewEntries.displayUserDetailsByNameAscending();

        while (!valid) {
            System.out.print(Messages.deleteStudentMenu());
            try {
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit"))
                    return 0;
                choice = Integer.parseInt(input);
                if (InputValidator.userRollNumberCheck(choice)) {
                    valid = true;
                } else {
                    System.out.println(Messages.invalidRollNumber());
                }
            } catch (NumberFormatException e) {
                Messages.menuInputInvalid();
            }
        }
        return choice;
    }

    public int mainMenuAcceptor(Scanner scanner) {

        int choice = 0;
        String input = "";
        boolean valid = false;

        while (!valid) {
            Messages.mainMenuText();
            Messages.menuInput();
            try {
                input = scanner.nextLine();
                choice = Integer.parseInt(input);
                if (InputValidator.mainMenuOptionValidator(courseList, choice)) {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                Messages.menuInputInvalid();
            }
        }
        return choice;
    }

    public static int menuInputAcceptor(Scanner scanner, int menuSize, String message) {

        int choice = 0;
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.println(message);
            Messages.menuInput();
            try {
                input = scanner.nextLine();
                choice = Integer.parseInt(input);
                if (choice > 0 && choice < menuSize);
                valid = true;
            } catch (NumberFormatException e) {
                Messages.menuInputInvalid();
            }
        }
        return choice;
    }

    public void createNewEntry(Scanner scanner) {

        EntriesInMemory INSTANCE = EntriesInMemory.getINSTANCE();
        Student student = new Student();
        acceptStudentInfo(scanner, student);
        List<Course> selectedCourses = new ArrayList<>();
        acceptNamesForCourses(scanner, selectedCourses);
        StudentCourse studentCourse = new StudentCourse(selectedCourses, student);
        INSTANCE.push(studentCourse);
    }

    public void acceptStudentInfo(Scanner scanner, Student student) {

        boolean valid = false;
        String input;
        String fullName = "";
        int age = 0;
        String address = "";

        while (!valid) {

            Messages.studentName();
            input = scanner.nextLine();
            if (InputValidator.studentNameValidator(input)) {
                fullName = input;
                valid = true;
            } else
                Messages.studentNameInvalid();
        }

        valid = false;

        while (!valid) {

            try {
                Messages.studentAge();
                input = scanner.nextLine();
                age = Integer.parseInt(input);
                valid = InputValidator.studentAgeValidator(age);
                if (!valid) {
                    Messages.studentAgeInvalid();
                }
            } catch (NumberFormatException e) {
                Messages.studentAgeInvalid();
            }
        }

        Messages.studentAddress();
        input = scanner.nextLine();
        address = input;

        student.setFullName(fullName);
        student.setAge(age);
        student.setAddress(address);
    }

    public void acceptNamesForCourses(Scanner scanner, List<Course> selectedCourses) {

        boolean exit = false;
        String courseName;

        outerLoop:
        while (selectedCourses.size() < courseList.size()) {

            // Displays course names and shows the ones already selected
            Messages.courseMessage();
            for (int i = 0; i < courseList.size(); i++) {
                Messages.displayCourseName(courseList.get(i));
                if (selectedCourses.contains(courseList.get(i))) {
                    Messages.courseSelected();
                }
                System.out.println();
            }

            // if user selected 4 courses option to exit is shown
            if (exit) {
                Messages.exitDisplayCourseName();
            }

            Messages.coursePromptMessage();
            courseName = scanner.nextLine();

            if (InputValidator.validateCourseNameExit(courseName))
                break;

            while (!InputValidator.validateCourseName(courseName, courseList, selectedCourses)) {
                courseName = scanner.nextLine();

                // Allows user to exit input if there is already 4 courses selected
                if (InputValidator.validateCourseNameExit(courseName) && exit)
                    break outerLoop;
            }

            if (selectedCourses.size() == 4) {
                exit = true;
            }

        }
    }

    // Read file courseList.txt and creates list of courses with the names from the file
    public void readCourseListFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                courseList.add(new Course(line));
            }
            br.close();
        } catch (IOException e) {
            Messages.errorReadingFile(fileName);
        }
    }
}
