package javaprojectpizza;

import java.sql.*;
import java.util.ArrayList;

// This class for connectin the project with database
public class DatabaseConnection {

    private ArrayList<Pizza> pizzaObjects = new ArrayList<>();
    private static LoggerInterface logger;

    DatabaseConnection(LoggerInterface logger) {
        this.logger = logger;

    }

    public void writeToDB(String name, String type, String size, String style, double totalPrice) {
        try {
            // Load the Connector/J driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish connection to MySQL
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza",
                    "arwwd", "arwwd201107");
            // Execution statement
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO pizza_order(CustomerName,PizzaType,"
                    + "DoughSize,DoughStyle,Price) "
                    + "VALUES ('" + name + "','" + type + "','" + size + "','" + style + "','" + totalPrice + "')";
            stmt.executeUpdate(query);
            // close connection
            conn.close();
            stmt.close();
            logger.log("Data Has Been Transerred To Database Successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            logger.log(ex.getMessage());
        }
    }

    public void readFromDB() {

        try {
            // Load the Connector/J driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish connection to MySQL
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza",
                    "arwwd", "arwwd201107");
            Statement stmt = conn.createStatement();
            String query = "SELECT OrderNo,CustomerName,PizzaType,DoughSize,DoughStyle,Price"
                    + " FROM pizza_order";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int order = resultSet.getInt("OrderNo");
                System.out.print(order + "\t");
                String name = resultSet.getString("CustomerName");
                System.out.print(name + "\t");
                String type = resultSet.getString("PizzaType");
                System.out.print(type + "\t");
                String size = resultSet.getString("DoughSize");
                System.out.print(size + "\t");
                String style = resultSet.getString("DoughStyle");
                System.out.print(style + "\t");
                double price = resultSet.getDouble("Price");
                System.out.print(price + "\t");
                pizzaObjects.add(new Pizza(new Dough(size, style), type, price));
                System.out.println("");
            }

            stmt.close();
            resultSet.close();
            logger.log("Data Has Been Retrieved From Database Successfully");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            logger.log(ex.getMessage());
        }
    }
}
