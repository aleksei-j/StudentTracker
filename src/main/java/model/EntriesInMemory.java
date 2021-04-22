package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class EntriesInMemory implements Serializable {

    private static EntriesInMemory INSTANCE = new EntriesInMemory();
    private int currentAvailableRoll = 0;
    ArrayList<StudentCourse> list = new ArrayList<>();

    private EntriesInMemory() {
        try {
            EntriesInMemory entriesInMemory = SaveToDrive.readFromFile();
            currentAvailableRoll = entriesInMemory.getCurrentAvailableRoll();
            System.out.println(currentAvailableRoll);
            list = entriesInMemory.getList();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("No file on disk yet.");
        }
    }

    public static EntriesInMemory getINSTANCE() {
        return INSTANCE;
    }

    public int getCurrentAvailableRollAndIncrement() {
        this.currentAvailableRoll += 1;
        return currentAvailableRoll;
    }

    public int getCurrentAvailableRoll() {
        return currentAvailableRoll;
    }

    public void push(StudentCourse studentCourse) {
        list.add(studentCourse);
        list.sort(new Sort.sortByNameAscending());

        for (StudentCourse studentCourse1 : list) {
            System.out.println(studentCourse1.getStudent().getFullName());
        }
    }

    public static void saveToDrive() {
        try {
            SaveToDrive.writeToFile(INSTANCE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<StudentCourse> getList() {
        return list;
    }


}


