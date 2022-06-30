package javaprojectpizza;

import Exceptions.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ViewMenu {

    private static int orderNo = 1;
    private static Scanner input = new Scanner(System.in);
    private static String name, size, type, style, order, choice, numberOfSlices;
    private static double totalPrice = 0;
    boolean repeat = true, done = false;
    private static String toppingMessage;
    private static String typeMessage;
    private static String styleMessage;
    private static String sizeMessage;
    private static String slicesMessage;
    private static LoggerInterface logger;
    private static Serialization serialization;
    private static DatabaseConnection databaseConnection;
    private static Set<ToppingIngredients> toppingIngredientsList;
    private static ArrayList<DoughIngredients> doughIngredientsList;

    public ViewMenu(LoggerInterface logger) {
        ViewMenu.logger = logger;
        resetAllOptions();
        // I used HashSet for toppings to prevent repetition
        toppingIngredientsList = new HashSet<ToppingIngredients>();
        doughIngredientsList = new ArrayList();
        serialization = new Serialization(logger);
        databaseConnection = new DatabaseConnection(logger);

    }

    public void showOurLogo() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("================================");
        System.out.println("PIZZA PIZZA \n");
    }

    public void showGreeting() {
        try {
            System.out.println("Enter Your Name: ");
            name = input.next();
            if (name.isEmpty()) {
                throw new InvalidEnteredValueException("You Have To Enter Your Name: ");
            } else {
                System.out.print("\nWelcome " + name);
                System.out.println(", Please, Choose Options You Need.");
            }
        } catch (InvalidEnteredValueException ex) {
            System.out.println(ex.getMessage());
            showGreeting();
        }

    }

    public void showToppingsMenu() {

        while (repeat) {
            System.out.println(toppingMessage);
            try {
                choice = input.next();
                switch (choice) {
                    case "1":
                        ToppingIngredients mozzarella = new ToppingIngredients("Mozzarella Cheese", true);
                        double mozzarellaTotalWeight = ToppingIngredients.getMozzarellaTotalWeight();
                        mozzarella.setWeight(200, mozzarellaTotalWeight, size);
                        ToppingIngredients.setMozzarellaTotalWeight(mozzarellaTotalWeight - mozzarella.getWeight());
                        mozzarella.setPrice(0.025 * mozzarella.getWeight());
                        mozzarella.setIngredientCalories(3 * mozzarella.getWeight());
                        toppingIngredientsList.add(mozzarella);
                        break;
                    case "2":
                        ToppingIngredients pizzaSauce = new ToppingIngredients("Pizza Sauce", false);
                        double pizzaSauceTotalWeight = ToppingIngredients.getPizzaSauceTotalWeight();
                        pizzaSauce.setWeight(88, pizzaSauceTotalWeight, size);
                        ToppingIngredients.setPizzaSauceTotalWeight(pizzaSauceTotalWeight - pizzaSauce.getWeight());
                        pizzaSauce.setPrice(0.0038 * pizzaSauce.getWeight());
                        pizzaSauce.setIngredientCalories(0.53 * pizzaSauce.getWeight());
                        toppingIngredientsList.add(pizzaSauce);
                        break;
                    case "3":
                        ToppingIngredients broccoli = new ToppingIngredients("Broccoli", false);
                        double broccoliTotalWeight = ToppingIngredients.getBroccoliTotalWeight();
                        broccoli.setWeight(90, broccoliTotalWeight, size);
                        ToppingIngredients.setBroccoliTotalWeight(broccoliTotalWeight - broccoli.getWeight());
                        broccoli.setPrice(0.013 * broccoli.getWeight());
                        broccoli.setIngredientCalories(0.35 * broccoli.getWeight());
                        toppingIngredientsList.add(broccoli);
                        break;
                    case "4":
                        ToppingIngredients mushroom = new ToppingIngredients("Mushroom", false);
                        double mushroomTotalWeight = ToppingIngredients.getMushroomTotalWeight();
                        mushroom.setWeight(88, mushroomTotalWeight, size);
                        ToppingIngredients.setMushroomTotalWeight(mushroomTotalWeight - mushroom.getWeight());
                        mushroom.setPrice(0.5 * mushroom.getWeight());
                        mushroom.setIngredientCalories(0.48 * mushroom.getWeight());
                        toppingIngredientsList.add(mushroom);
                        break;
                    case "5":
                        ToppingIngredients bellPepper = new ToppingIngredients("Bell Pepper", false);
                        double bellPepperTotalWeight = ToppingIngredients.getBellPepperTotalWeight();
                        bellPepper.setWeight(150, bellPepperTotalWeight, size);
                        ToppingIngredients.setBellPepperTotalWeight(bellPepperTotalWeight - bellPepper.getWeight());
                        bellPepper.setPrice(0.00765 * bellPepper.getWeight());
                        bellPepper.setIngredientCalories(0.38 * bellPepper.getWeight());
                        toppingIngredientsList.add(bellPepper);
                        break;
                    case "6":
                        ToppingIngredients oregano = new ToppingIngredients("Oregano", true);
                        double oreganoTotalWeight = ToppingIngredients.getOreganoTotalWeight();
                        oregano.setWeight(150, oreganoTotalWeight, size);
                        ToppingIngredients.setOreganoTotalWeight(oreganoTotalWeight - oregano.getWeight());
                        oregano.setPrice(0.0031 * oregano.getWeight());
                        oregano.setIngredientCalories(2.7 * oregano.getWeight());
                        toppingIngredientsList.add(oregano);
                        break;
                    case "7":
                        ToppingIngredients blackOlive = new ToppingIngredients("Black Olive", true);
                        double blackOliveTotalWeight = ToppingIngredients.getBlackOliveTotalWeight();
                        blackOlive.setWeight(50, blackOliveTotalWeight, size);
                        ToppingIngredients.setBlackOliveTotalWeight(blackOliveTotalWeight - blackOlive.getWeight());
                        blackOlive.setPrice(0.05 * blackOlive.getWeight());
                        blackOlive.setIngredientCalories(1.05 * blackOlive.getWeight());

                        toppingIngredientsList.add(blackOlive);
                        break;
                    case "8":
                        ToppingIngredients onion = new ToppingIngredients("Onion", false);
                        double onionTotalWeight = ToppingIngredients.getOnionTotalWeight();
                        onion.setWeight(55, onionTotalWeight, size);
                        ToppingIngredients.setOnionTotalWeight(onionTotalWeight - onion.getWeight());
                        onion.setPrice(0.0183 * onion.getWeight());
                        onion.setIngredientCalories(0.58 * onion.getWeight());

                        toppingIngredientsList.add(onion);
                        break;
                    case "9":
                        ToppingIngredients tomato = new ToppingIngredients("Tomato", false);
                        double tomatoTotalWeight = ToppingIngredients.getTomatoTotalWeight();
                        tomato.setWeight(160, tomatoTotalWeight, size);
                        ToppingIngredients.setTomatoTotalWeight(tomatoTotalWeight - tomato.getWeight());
                        tomato.setPrice(0.0041 * tomato.getWeight());
                        tomato.setIngredientCalories(0.18 * tomato.getWeight());

                        toppingIngredientsList.add(tomato);
                        break;
                    case "10":
                        repeat = false;
                        break;
                    default:
                        throw new InvalidEnteredValueException("You Have To Enter Valid Choice, Try Again. ");
                }

            } catch (InvalidEnteredValueException ex) {
                System.out.println(ex.getMessage());
                toppingMessage = "";
                showToppingsMenu();
            } catch (OutOfStockException ex) {
                System.out.println(ex.getMessage());
                System.exit(0);
            }
            toppingMessage = "";
        }
    }

    public void showPizzaTypeMenu() {
        try {
            System.out.println(typeMessage);
            choice = input.next();
            switch (choice) {
                case "1":
                    type = "Simple";
                    break;
                case "2":
                    ToppingIngredients meat = new ToppingIngredients("Meat", false);
                    double meatTotalWeight = ToppingIngredients.getMeatTotalWeight();
                    meat.setWeight(50, meatTotalWeight, size);
                    ToppingIngredients.setMeatTotalWeight(meatTotalWeight - meat.getWeight());
                    meat.setPrice(0.01 * meat.getWeight());
                    meat.setIngredientCalories(3 * meat.getWeight());

                    toppingIngredientsList.add(meat);
                    break;
                case "3":
                    ToppingIngredients chickenBreast = new ToppingIngredients("Chicken Breast", false);
                    double chickenBreastTotalWeight = ToppingIngredients.getChickenBreastTotalWeight();
                    chickenBreast.setWeight(100, chickenBreastTotalWeight, size);
                    ToppingIngredients.setChickenBreastTotalWeight(chickenBreastTotalWeight - chickenBreast.getWeight());
                    chickenBreast.setPrice(0.044 * chickenBreast.getWeight());
                    chickenBreast.setIngredientCalories(2 * chickenBreast.getWeight());
                    toppingIngredientsList.add(chickenBreast);
                    break;
                default:
                    throw new InvalidEnteredValueException("You Have To Enter Valid Choice, Try Again !! ");

            }
        } catch (InvalidEnteredValueException ex) {
            System.out.println(ex.getMessage());
            typeMessage = "";
            showPizzaTypeMenu();
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public void showDoughStyleMenu() {
        try {
            System.out.println(styleMessage);
            choice = input.next();
            switch (choice) {
                case "1":
                    style = "Deep-Pan";
                    break;
                case "2":
                    style = "Deep-Dish";
                    break;
                default:
                    throw new InvalidEnteredValueException("You Have To Enter Valid Choice, Try Again !! ");

            }
        } catch (InvalidEnteredValueException ex) {
            System.out.println(ex.getMessage());
            styleMessage = "";
            showDoughStyleMenu();
        }
    }

    public void showDoughSizeMenu() {
        try {
            System.out.println(sizeMessage);
            choice = input.next();
            switch (choice) {
                case "1":
                    size = "small";
                    break;
                case "2":
                    size = "medium";
                    break;
                case "3":
                    size = "large";
                    break;
                default:
                    throw new InvalidEnteredValueException("You Have To Enter Valid Choice, Try Again !! ");

            }
        } catch (InvalidEnteredValueException ex) {
            System.out.println(ex.getMessage());
            sizeMessage = "";
            showDoughSizeMenu();
        }
    }

    public void createPizza() throws InterruptedException {

        // Prepare dough ingredients 
        setDoughIngredients();
        Mixer mixer = new Mixer(126, 80); // speed = 126 RPM , bowlSize = 80 quart
        serialization.writeObjectToFile(mixer); // write object to file
        TimeUnit.MILLISECONDS.sleep(6000); // wait until dough get prepred
        Dough dough = mixer.mixDough(size, style, doughIngredientsList);
        
        logger.log("The Dough Has Been Mixed");
        dough.setDoughIngredientsList(doughIngredientsList);
        dough.setPrice();
        serialization.writeObjectToFile(dough);
        // calclate total price 
        for (ToppingIngredients topping : toppingIngredientsList) {
            totalPrice += topping.getPrice();
        }
        totalPrice += dough.getPrice();
        // format of calories and price 
        DecimalFormat df = new DecimalFormat("0.00");
        // Show Order 
        order += "\nYou Ordered  ";
        order += size + ", " + style + " and \n" + type + " Pizza With Toppings: \n";
        for (ToppingIngredients topping : toppingIngredientsList) {
            order += topping.getName() + " \\ ";
        }
        order += "\nTotal Price: " + df.format(totalPrice) + " $ \n";
        boolean isDone = false;
        try {
            // start to prepare a pizza 
            Pan pan = new Pan(size, dough, toppingIngredientsList);
            TimeUnit.MILLISECONDS.sleep(6000); // wait until dough is poured 
            pan.pourDough();
            logger.log("Dough Is Poured");
            TimeUnit.MILLISECONDS.sleep(6000); // wait until toppings are added
            if (toppingIngredientsList.isEmpty() == false) {
                pan.addToppingIngredients();
                logger.log("Toppings Are Added");
            }
            serialization.writeObjectToFile(pan);

            Oven oven = new Oven(450, pan); // temperature
            serialization.writeObjectToFile(oven);

            // create pizza object
            Pizza pizza = oven.bakePizza(dough, toppingIngredientsList, totalPrice, type);
            TimeUnit.MILLISECONDS.sleep(6000); // wait until pizza is baked
            logger.log("Pizza Is Baked");
            System.out.println("Pizza Is Baked");
            serialization.writeObjectToFile(pizza);

            order += "Total Calories = " + df.format(pan.getTotalCalories());
            boolean isValid = false;
            // loop while user enter valid number of slices 
            while (!isValid) {
                try {
                    System.out.println(slicesMessage);
                    numberOfSlices = input.next();
                    order += "\nCalories for each slice = " + df.format(pan.cutPizza(numberOfSlices));
                    isValid = true;
                } catch (InvalidEnteredValueException ex) {
                    System.out.println(ex.getMessage());
                    logger.log(ex.getMessage());
                    slicesMessage = "";
                }
            }
            // Show Pizza out
            TimeUnit.MILLISECONDS.sleep(6000);
            logger.log("Order " + (orderNo) + " Is Ready");
            System.out.println("Your Order Is Ready !!"
                    + "\n=================================="
                    + "\nOrder No = " + (orderNo++) + order);

        } catch (PanOverFlowException ex) {
            System.out.println(ex.getMessage());
            logger.log(ex.getMessage());
            tryAgainAfterException();
        } catch (IngredientsOverFlowException ex) {
            System.out.println(ex.getMessage());
            logger.log(ex.getMessage());
            tryAgainAfterException();
        }
    }

    public void setDoughIngredients() {
        // Name, doughSize
        // only flour has calories
        try {
            DoughIngredients water = new DoughIngredients("Water");
            double waterTotalWeight = DoughIngredients.getWaterTotalWeight();
            water.setWeight(320, waterTotalWeight, size); // default weight for large size
            // decrease total weight of the water each time we make a new dough
            DoughIngredients.setWaterTotalWeight(waterTotalWeight - water.getWeight());
            water.setIngredientCalories(0);
            doughIngredientsList.add(water);
            // Flour
            DoughIngredients flour = new DoughIngredients("Flour");
            double flourTotalWeight = DoughIngredients.getFlourTotalWeight();
            flour.setWeight(500, flourTotalWeight, size);
            DoughIngredients.setFlourTotalWeight(flourTotalWeight - flour.getWeight());
            flour.setIngredientCalories(4 * flour.getWeight());
            doughIngredientsList.add(flour);
            // Yeast
            DoughIngredients yeast = new DoughIngredients("Yeast");
            double yeastTotalWeight = DoughIngredients.getYeastTotalWeight();
            yeast.setWeight(7, flourTotalWeight, size);
            DoughIngredients.setYeastTotalWeight(yeastTotalWeight - yeast.getWeight());
            yeast.setIngredientCalories(0);
            doughIngredientsList.add(yeast);
            // Olive Oil
            DoughIngredients oliveOil = new DoughIngredients("Olive Oil");
            double oliveOilTotalWeight = DoughIngredients.getOliveOilTotalWeight();
            oliveOil.setWeight(75, oliveOilTotalWeight, size);
            DoughIngredients.setOliveOilTotalWeight(oliveOilTotalWeight - oliveOil.getWeight());
            oliveOil.setIngredientCalories(0);
            doughIngredientsList.add(oliveOil);
            // Suger
            DoughIngredients suger = new DoughIngredients("Suger");
            double sugerTotalWeight = DoughIngredients.getSugerTotalWeight();
            suger.setWeight(75, sugerTotalWeight, size);
            DoughIngredients.setSugerTotalWeight(sugerTotalWeight - suger.getWeight());
            suger.setIngredientCalories(0);
            doughIngredientsList.add(suger);
            // Salt
            DoughIngredients salt = new DoughIngredients("Salt");
            double saltTotalWeight = DoughIngredients.getSaltTotalWeight();
            suger.setWeight(75, saltTotalWeight, size);
            DoughIngredients.setSaltTotalWeight(saltTotalWeight - salt.getWeight());
            salt.setIngredientCalories(0);
            doughIngredientsList.add(salt);
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
            // loger
        }
    }

    public void tryAgainAfterException() {
        // clear screen
        resetAllOptions();
        toppingIngredientsList.clear();
        doughIngredientsList.clear();
        showDoughSizeMenu();
        showDoughStyleMenu();
        showPizzaTypeMenu();
        showToppingsMenu();
        try {
            createPizza();
            System.out.println("\nHope You Enjoy What We Have Made For You");
            databaseConnection.writeToDB(name, type, size, style, totalPrice);
        } catch (InterruptedException ex) {
            logger.log(ex.getMessage());
            System.out.println("Interrupted Exception !!");
        }

    }

    public void resetAllOptions() {
        name = size = type = style = order = "";
        totalPrice = 0;
        repeat = true;
        done = false;
        toppingMessage = "\nChoose Toppings:"
                + "\n1- Mozzarella Cheese"
                + "\n2- Pizza sauce \n3- Broccoli"
                + "\n4- Mushroom\n5- Bell Pepper\n6- Oregano\n7- Black Olive"
                + "\n8- Onion\n9- Tomato\n10- Next \nEnter A Choice: \n";
        typeMessage = "\nChoose Pizza Type:\n1- Simple\n2- Meat Pizza"
                + "\n3- Chicken Pizza";
        styleMessage = "\nChoose Dough Style:\n1- Deep-Pan Pizza"
                + "\n2- Deep-Dish Pizza";
        sizeMessage = "\nChoose Duogh Size:\n1- Small\n2- Medium\n3- Large";
        slicesMessage = "How Many Slices Do You Want : 2 / 4 / 6 / 8 / 10 : ";

    }

    public void start() {

        while (true) {
            try {
                showOurLogo();
            } catch (InterruptedException ex) {
                System.out.println("Interrupted Exception !!");
            }
            showGreeting();
            showDoughSizeMenu();
            showDoughStyleMenu();
            showPizzaTypeMenu();
            showToppingsMenu();
            try {
                createPizza();
                System.out.println("\nHope You Enjoy What We Have Made For You");
            } catch (InterruptedException ex) {
                System.out.println("Interrupted Exception !!");
            }
            orderDone();
            databaseConnection.writeToDB(name, type, size, style, totalPrice);
            resetAllOptions();
            toppingIngredientsList.clear();
            doughIngredientsList.clear();
        }
    }

    public void orderDone() {

        while (!done) {

            System.out.println("Enter 1 to get your order: ");
            String value = input.next();
            if (value.equals("1")) {
                done = true;
            } else {
                orderDone();
            }

        }
    }
}
