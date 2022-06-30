package javaprojectpizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PizzaLogger implements LoggerInterface {

    private static final LocalDateTime currentTime = LocalDateTime.now();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    @Override
    public void log(String message) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Done\\Documents\\AsiaShalaldeh\\JavaProjectPizza\\log.txt", true);
            fileWriter.write("[ " + dateTimeFormatter.format(currentTime) + " ] " + message + "\n\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
