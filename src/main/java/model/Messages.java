package model;

import java.util.List;

public class Messages {

    public static void errorReadingFile(String fileName) {
        System.out.println("Error - cannot read from file " + fileName);
    }

    public static void courseMessage() {
        System.out.println("Please select the courses that you wish to enroll in, minimum 4 courses: ");
    }

    public static void coursePromptMessage() {
        System.out.print("Enter your choice: ");
    }

    public static void displayCourseName(Course course) {
        System.out.printf("%s", course.getCourseName());
    }

    public static void courseAlreadySelected(String courseName) {
        System.out.printf("%s - already selected", courseName);
    }

    public static void courseAdded(String courseName) {
        System.out.printf("%s - added to the list\n", courseName);
    }

    public static void courseNameError(String courseName) {
        System.out.printf("%s - is invalid course name\n", courseName);
    }

    public static void exitDisplayCourseName() {
        System.out.println("Enter EXIT to finish adding courses");
    }

    public static void courseSelected() {
        System.out.print(" - selected");
    }

    public static void studentName() {
        System.out.print("Enter student name: ");
    }

    public static void studentNameInvalid() {
        System.out.println("Invalid student name, try again");
    }

    public static void studentAge() {
        System.out.print("Enter student age: ");
    }

    public static void studentAgeInvalid() {
        System.out.println("Enter correct age, it should be positive number, less then 130: ");
    }

    public static void studentAddress() {
        System.out.print("Enter student address: ");
    }

    public static void mainMenuText() {
        System.out.println("1. Add user details");
        System.out.println("2. Display user details");
        System.out.println("3. Delete user details");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
    }

    public static void menuInputInvalid() {
        System.out.println("Error - incorrect input");
    }

    public static void menuInput() {
        System.out.print("Enter number for the option you want to choose: ");
    }

    public static String displayUserDetailsMenu() {
        return "1. Sort \n2. Exit";
    }

    public static void studentInfoHeader() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Name             Roll Number   Age   Address              Courses");
        System.out.println("------------------------------------------------------------------------------");
    }

    public static String displaySortMenu() {
        return "1. Ascending name \n2. Descending name \n3. Ascending roll number \n4. Descending rollnumber" +
                "\n5. Ascending age \n6. Descending age \n7. Ascending address \n8. Descending address \n9. Exit";
    }

    public static String deleteStudentMenu() {
        return "Enter student roll number to delete or type EXIT: ";
    }

    public static String invalidRollNumber() {
        return "No such roll number exists";
    }

    public static String yesNoDeleteUser() { return  "Are you sure you want to delete this user y/n: ";}

    public static String followingUserWasDeleted() { return "Following user was deleted: ";}

    public static String saveToDrive() { return "Do you want to save changes y/n: ";}
}
