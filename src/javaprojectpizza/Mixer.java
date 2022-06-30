package javaprojectpizza;

import java.io.Serializable;
import java.util.ArrayList;

public class Mixer implements Serializable {

    private static final long serialVersionUID = 1L;
    private double speed; // Rotate Per Minute (RPM)
    private double bowlSize; // quart
    private ArrayList<DoughIngredients> doughIngredients;

    public Mixer(double speed, double bowlSize) {
        this.speed = speed;
        this.bowlSize = bowlSize;
    }

    // Method to mix all dough ingrediets and return ready dough 
    public Dough mixDough(String size, String style, ArrayList<DoughIngredients> doughIngredients) {
        Dough dough = new Dough(size, style);
        System.out.println("Dough Is Ready");
        return dough;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getBowlSize() {
        return bowlSize;
    }

    public void setBowlSize(double bowlSize) {
        this.bowlSize = bowlSize;
    }

    public ArrayList<DoughIngredients> getDoughIngredients() {
        return doughIngredients;
    }

    public void setDoughIngredients(ArrayList<DoughIngredients> doughIngredients) {
        this.doughIngredients = doughIngredients;
    }

    @Override
    public String toString() {
        return "Mixer{" + "speed=" + speed + ", bowlSize=" + bowlSize + ", doughIngredients=" + doughIngredients  + '}';
    }

    

}
