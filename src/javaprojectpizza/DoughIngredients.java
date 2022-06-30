package javaprojectpizza;

public class DoughIngredients extends Ingredients {

    // intial weights of each dough ingredients 
    
    private static double waterTotalWeight = 2000;
    private static double flourTotalWeight = 5000;
    private static double yeastTotalWeight = 500;
    private static double oliveOilTotalWeight = 500;
    private static double sugerTotalWeight = 1000;
    private static double saltTotalWeight = 1000;

    public DoughIngredients(String name) {
        super(name);
    }

    public static double getWaterTotalWeight() {
        return waterTotalWeight;
    }

    public static void setWaterTotalWeight(double waterTotalWeight) {
        DoughIngredients.waterTotalWeight = waterTotalWeight;
    }

    public static double getFlourTotalWeight() {
        return flourTotalWeight;
    }

    public static void setFlourTotalWeight(double flourTotalWeight) {
        DoughIngredients.flourTotalWeight = flourTotalWeight;
    }

    public static double getYeastTotalWeight() {
        return yeastTotalWeight;
    }

    public static void setYeastTotalWeight(double yeastTotalWeight) {
        DoughIngredients.yeastTotalWeight = yeastTotalWeight;
    }

    public static double getOliveOilTotalWeight() {
        return oliveOilTotalWeight;
    }

    public static void setOliveOilTotalWeight(double oliveOilTotalWeight) {
        DoughIngredients.oliveOilTotalWeight = oliveOilTotalWeight;
    }

    public static double getSugerTotalWeight() {
        return sugerTotalWeight;
    }

    public static void setSugerTotalWeight(double sugerTotalWeight) {
        DoughIngredients.sugerTotalWeight = sugerTotalWeight;
    }

    public static double getSaltTotalWeight() {
        return saltTotalWeight;
    }

    public static void setSaltTotalWeight(double saltTotalWeight) {
        DoughIngredients.saltTotalWeight = saltTotalWeight;
    }

}
