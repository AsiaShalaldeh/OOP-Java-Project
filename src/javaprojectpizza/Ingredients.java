package javaprojectpizza;

import Exceptions.OutOfStockException;
import java.io.Serializable;

public class Ingredients implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private double weight; // grams 
    private double ingredientCalories;

    // name , weight , calories , doughSize
    public Ingredients(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight, double totalWeight,String doughSize) throws OutOfStockException {
        if (doughSize.equals("small")) {
            this.weight = weight / 3;
        } else if (doughSize.equals("medium")) {
            this.weight = weight / 2;
        } else if (doughSize.equals("large")) {
            this.weight = weight;
        }
        if (this.weight > totalWeight) {
            throw new OutOfStockException("Sorry. No Enough Ingredients"
                    + "To Prepare Your Order. Come Back After 10 Minutes");
        }
    }

    public double getIngredientCalories() {
        return ingredientCalories;
    }

    public void setIngredientCalories(double ingredientCalories) {
        this.ingredientCalories = ingredientCalories;

    }


    @Override
    public String toString() {
        return "Ingredients{" + "name=" + name + ", weight=" + weight + ", ingredientCalories=" + ingredientCalories +  '}';
    }

}
