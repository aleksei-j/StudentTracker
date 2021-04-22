package view;

import input.InputAcceptor;
import model.EntriesInMemory;
import model.Messages;
import model.StudentCourse;

import java.util.Scanner;

public class DeleteUser {

    public static void deleteUserEntry(InputAcceptor inputAcceptor, Scanner scanner) {
        EntriesInMemory INSTANCE = EntriesInMemory.getINSTANCE();

        int choice;
        boolean exit = false;
        String yesNoChoice;

        while (!exit) {
            choice = inputAcceptor.deleteUserRollNumber(scanner);

            if (choice == 0) {
                exit = true;
            }

            if (choice != 0) {
                for (StudentCourse studentCourse : INSTANCE.getList()) {
                    if (studentCourse.getStudent().getStudentRoll() == choice) {
                        yesNoChoice = InputAcceptor.yesNoAcceptor(scanner, Messages.yesNoDeleteUser());
                        if (yesNoChoice.equals("Yes")) {
                            System.out.println(Messages.followingUserWasDeleted());
                            Messages.studentInfoHeader();
                            ViewEntries.printSingleEntry(studentCourse);
                            INSTANCE.getList().remove(studentCourse);
                            break;
                        }
                        exit = true;
                    }
                }
            }
        }
    }
}
