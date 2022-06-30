package javaprojectpizza;

import java.io.Serializable;
import java.util.Set;

public class Oven implements Serializable {

    private static final long serialVersionUID = 1L;
    private double temperature;  // Fahrenheit
    private Pan pan;

    public Oven(double temperature, Pan pan) {
        this.temperature = temperature;
        this.pan = pan;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Pan getPan() {
        return pan;
    }

    public void setPan(Pan pan) {
        this.pan = pan;
    }

    // Create new pizza 
    public Pizza bakePizza(Dough dough, Set<ToppingIngredients> toppingIngredientsList, double totalPrice, String type) {
        Pizza pizza = new Pizza(dough, toppingIngredientsList, totalPrice, type);
        return pizza;
    }

    @Override
    public String toString() {
        return "Oven{" + "temperature=" + temperature + ", pan=" + pan + '}';
    }

}
