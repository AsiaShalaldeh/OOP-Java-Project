package javaprojectpizza;

import Exceptions.IngredientsOverFlowException;
import Exceptions.InvalidEnteredValueException;
import Exceptions.PanOverFlowException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Pan implements Serializable {

    private static final long serialVersionUID = 1L;
    private String size;
    private Dough dough;
    private Set<ToppingIngredients> toppingIngredientsList;
    private double capacity; // grams

    public Pan(String size, Dough dough, Set<ToppingIngredients> toppingIngredientsList) {
        this.size = size;
        this.dough = dough;
        this.toppingIngredientsList = toppingIngredientsList;
        this.capacity = 1500;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void pourDough() throws PanOverFlowException {
        if (dough.getSize().equals(size)) {
            System.out.println("Pouring Is Done");
            this.capacity = this.capacity - dough.getCapacity();
        } else {
            throw new PanOverFlowException("The size of the dough does "
                    + "not fit the size of the Pan, Try Again.");
        }
    }

    public void addToppingIngredients() throws IngredientsOverFlowException {
        double weightsOfIngredients = 0;
        for (ToppingIngredients topping : toppingIngredientsList) {
            weightsOfIngredients += topping.getWeight();
        }
        if (weightsOfIngredients > this.capacity) {
            throw new IngredientsOverFlowException("The capacity of ingredients does "
                    + "not fit the remaining capacity of the Pan, Try Again.");
        } else {
            System.out.println("Toppings are added");
        }
    }

    public String getFinalSize(Pizza pizza) {
        return pizza.getDough().getSize();
    }

    public String getIngredients() {
        String allIngredients = "";
        for (ToppingIngredients topping : toppingIngredientsList) {
            allIngredients += topping.getName() + "\t";
        }
        return allIngredients;
    }

    public double getTotalCalories() {
        double total = 0;
        for (ToppingIngredients topping : toppingIngredientsList) {
            total += topping.getIngredientCalories();
        }
        for (int i = 0; i < dough.getDoughIngredientsList().size(); i++) {
            total += dough.getDoughIngredientsList().get(i).getIngredientCalories();
        }
        return total;
    }

    public double cutPizza(String numberOfSlices) throws InvalidEnteredValueException {
        if (numberOfSlices.equals("2") || numberOfSlices.equals("4")  || 
                numberOfSlices.equals("6") || numberOfSlices.equals("8") || 
                numberOfSlices.equals("10")) {
            int value = Integer.valueOf(numberOfSlices);
            double sliceCalories = getTotalCalories() / value;
            return sliceCalories;
        } else {
            throw new InvalidEnteredValueException("Enter Valid Number Of Slices , Try Again.");
        }
    }

    public double getTotalWeights(Pizza pizza) {
        double totalWeights = 0;

        totalWeights += pizza.getDough().getCapacity();

        for (ToppingIngredients topping : pizza.getToppingIngredients()) {
            totalWeights += topping.getWeight();
        }
        return totalWeights;
    }

    @Override
    public String toString() {
        return "Pan{" + "size=" + size + ", dough=" + dough + ", toppingIngredientsList=" + toppingIngredientsList + ", capacity=" + capacity + '}';
    }

}
