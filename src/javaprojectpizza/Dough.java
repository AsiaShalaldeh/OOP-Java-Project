package javaprojectpizza;

import java.io.Serializable;
import java.util.ArrayList;

public class Dough implements Serializable {

    private static final long serialVersionUID = 1L;
    private String size;
    private String style;
    private static ArrayList<DoughIngredients> doughIngredientsList;
    private double capacity; // this is total weight of all dough ingredients 
    private double price;

    public Dough(String size, String style) {
        this.size = size;
        this.style = style;
        doughIngredientsList = new ArrayList();
    }

    public Dough(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getCapacity() {
        double capacity = 0;
        for (int i = 0; i < doughIngredientsList.size(); i++) {
            capacity += doughIngredientsList.get(i).getWeight();
        }
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() { // six cases of dough 
        if (size.equals("small") && style.equals("Deep-Pan")) {
            price = 10;
        } else if (size.equals("small") && style.equals("Deep-Dish")) {
            price = 15;
        } else if (size.equals("medium") && style.equals("Deep-Pan")) {
            price = 20;
        } else if (size.equals("medium") && style.equals("Deep-Dish")) {
            price = 25;
        } else if (size.equals("large") && style.equals("Deep-Pan")) {
            price = 30;
        } else if (size.equals("large") && style.equals("Deep-Dish")) {
            price = 35;
        }
    }

    public void setDoughIngredientsList(ArrayList<DoughIngredients> doughIngredientsList) {

        this.doughIngredientsList = doughIngredientsList;

    }

    public ArrayList<DoughIngredients> getDoughIngredientsList() {
        return doughIngredientsList;
    }

    @Override
    public String toString() {
        return "Dough{" + "size=" + size + ", style=" + style + ", doughIngredientsList="
                + this.getDoughIngredientsList() + '}';
    }

}
