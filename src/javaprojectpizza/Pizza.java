package javaprojectpizza;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    private Dough dough;
    private Set<ToppingIngredients> toppingIngredients;
    private double price; // dollar $
    private String pizzaType;
    private String style;
    private Serialization serialization;
    private static LoggerInterface logger;
    private ViewMenu view;

    public Pizza(LoggerInterface logger) {
        this.logger = logger;
        serialization = new Serialization(logger);
        view = new ViewMenu(logger);
    }

    public Pizza(Dough dough, Set<ToppingIngredients> toppingIngredients, double price, String pizzaType) {
        this.dough = dough;
        this.toppingIngredients = toppingIngredients;
        this.price = price;
        this.pizzaType = pizzaType;
        this.style = style;

    }

    public Pizza(Dough dough, String pizzaType, double price) {

    }

    public void pizzaMachineStarted() {
        logger.log("Pizza Machine Started ");
        view.start();
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Set<ToppingIngredients> getToppingIngredients() {
        return toppingIngredients;
    }

    public void setToppingIngredients(Set<ToppingIngredients> toppingIngredients) {
        this.toppingIngredients = toppingIngredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    @Override
    public String toString() {
        return "Pizza{" + "dough=" + dough + ", toppingIngredients=" + toppingIngredients + ", price=" + price + ", pizzaType=" + pizzaType + '}';
    }

}
