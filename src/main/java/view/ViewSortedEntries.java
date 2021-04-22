package view;

import input.InputAcceptor;
import model.Messages;

import java.util.Scanner;

public class ViewSortedEntries {

    public static void displaySortedUserDetails (Scanner scanner) {

        int choice;

        boolean exit = false;

        while (!exit) {

            choice = InputAcceptor.menuInputAcceptor(scanner, 9, Messages.displaySortMenu());

            if (choice == 1) {
                ViewEntries.displayUserDetailsByNameAscending();
            }

            if (choice == 2) {
                ViewEntries.displayUserDetailsByNameDescending();
            }

            if (choice == 3) {
                ViewEntries.displayUserDetailsByRollNumberAscending();
            }

            if (choice == 4) {
                ViewEntries.displayUserDetailsByRollNumberDescending();
            }

            if (choice == 5) {
                ViewEntries.displayUserDetailsAgeAscending();
            }

            if (choice == 6) {
                ViewEntries.displayUserDetailsAgeDescending();
            }

            if (choice == 7) {
                ViewEntries.displayUserDetailsAddressAscending();
            }

            if (choice == 8 ) {
                ViewEntries.displayUserDetailsAddressDescending();
            }

            if (choice == 9) {
                exit = true;
            }
        }
    }
}
