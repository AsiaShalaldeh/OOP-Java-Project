package javaprojectpizza;

import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class Serialization {

    private static LoggerInterface logger;
    private ArrayList<Object> pizzaObjects = new ArrayList<Object>();

    public Serialization(LoggerInterface logger) {
        Serialization.logger = logger;
    }

    public void writeObjectToFile(Object obj) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("C:\\Users\\Done\\Documents\\AsiaShalaldeh\\JavaProjectPizza\\pizzaObjects.txt", true);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

            // Write objects to file
            outputStream.writeObject(obj);
            outputStream.close();
            fileOutput.close();
            logger.log("Object Has Been Transferred To File Succcessfully [" + obj.getClass().getName() + "]");

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error initializing stream");
        }
    }

    public ArrayList<Object> readObjectFromFile() {
        boolean flag = true;
        try {
            FileInputStream fileInput = new FileInputStream("C:\\Users\\Done\\Documents\\AsiaShalaldeh\\JavaProjectPizza\\pizzaObjects.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);

            // Read objects From file
            while (flag) {
                Object obj = (Object) inputStream.readObject();
                if (obj != null) {
                    pizzaObjects.add(obj);
                } else {
                    flag = false;
                }
            }
            inputStream.close();
            fileInput.close();
            logger.log("Object Has Been Retrieved From File Succcessfully");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pizzaObjects;
    }
}
