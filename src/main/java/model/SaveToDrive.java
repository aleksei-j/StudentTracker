package model;

import java.io.*;
import java.util.ArrayList;

public class SaveToDrive {

    public static void writeToFile(EntriesInMemory entriesInMemory) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("EntriesInMemory.bin"));
        objectOutputStream.writeObject(entriesInMemory);
    }

    public static EntriesInMemory readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("EntriesInMemory.bin"));
        EntriesInMemory entriesInMemory = (EntriesInMemory) objectInputStream.readObject();
        return entriesInMemory;
    }
}
