package controller;

import input.InputAcceptor;
import model.EntriesInMemory;
import model.Messages;
import view.DeleteUser;
import view.ViewEntries;
import view.ViewSortedEntries;

import java.util.Scanner;

public class Menu {

    public static void mainMenu() {

        boolean exit = false;
        int choice;
        String yesNoChoice;

        InputAcceptor inputAcceptor = new InputAcceptor();

        try (Scanner scanner = new Scanner(System.in)) {

            while (!exit) {
                choice = inputAcceptor.mainMenuAcceptor(scanner);

                if (choice == 1) {
                    inputAcceptor.createNewEntry(scanner);
                }

                if (choice == 2) {
                    displayUserDetailsMenu(scanner);
                }

                if (choice == 3) {
                    DeleteUser.deleteUserEntry(inputAcceptor, scanner);
                }

                if (choice == 4) {
                    yesNoChoice = InputAcceptor.yesNoAcceptor(scanner, Messages.saveToDrive());
                    if (yesNoChoice.equals("Yes"))
                        EntriesInMemory.saveToDrive();
                }

                if (choice == 5) {
                    exit = true;
                }
            }
        }
    }

    public static void displayUserDetailsMenu(Scanner scanner) {

        ViewEntries.displayUserDetailsByNameAscending();

        int choice;

        boolean exit = false;

        while (!exit) {

            choice = InputAcceptor.menuInputAcceptor(scanner, 2, Messages.displayUserDetailsMenu());

            if (choice == 1) {
                ViewSortedEntries.displaySortedUserDetails(scanner);
            }

            if (choice == 2) {
                exit = true;
            }
        }
    }
}
