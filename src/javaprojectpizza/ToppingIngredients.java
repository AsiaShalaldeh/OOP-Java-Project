package javaprojectpizza;

public class ToppingIngredients extends Ingredients {

    private boolean isFresh;
    private double price;
    private static double mushroomTotalWeight = 1000;
    private static double mozzarellaTotalWeight = 2000;
    private static double bellPepperTotalWeight = 2000;
    private static double broccoliTotalWeight = 1000;
    private static double blackOliveTotalWeight = 1000;
    private static double onionTotalWeight = 1000;
    private static double pizzaSauceTotalWeight = 1000;
    private static double oreganoTotalWeight = 2000;
    private static double tomatoTotalWeight = 2000;
    private static double chickenBreastTotalWeight = 1000;
    private static double meatTotalWeight = 1000;

    public ToppingIngredients( String name,boolean isFresh) {
        super(name);
        this.isFresh = isFresh;
    }

    public boolean getIsFresh() {
        return isFresh;
    }

    public void setIsFresh(boolean isFresh) {
        this.isFresh = isFresh;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;

    }

    public static double getMushroomTotalWeight() {
        return mushroomTotalWeight;
    }

    public static void setMushroomTotalWeight(double mushroomTotalWeight) {
        ToppingIngredients.mushroomTotalWeight = mushroomTotalWeight;
    }

    public static void setMozzarellaTotalWeight(double mozzarellaTotalWeight) {
        ToppingIngredients.mozzarellaTotalWeight = mozzarellaTotalWeight;
    }

    public boolean isIsFresh() {
        return isFresh;
    }

    public static double getMozzarellaTotalWeight() {
        return mozzarellaTotalWeight;
    }

    public static double getBellPepperTotalWeight() {
        return bellPepperTotalWeight;
    }

    public static void setBellPepperTotalWeight(double bellPepperTotalWeight) {
        ToppingIngredients.bellPepperTotalWeight = bellPepperTotalWeight;
    }

    public static double getBroccoliTotalWeight() {
        return broccoliTotalWeight;
    }

    public static void setBroccoliTotalWeight(double broccoliTotalWeight) {
        ToppingIngredients.broccoliTotalWeight = broccoliTotalWeight;
    }

    public static double getBlackOliveTotalWeight() {
        return blackOliveTotalWeight;
    }

    public static void setBlackOliveTotalWeight(double blackOliveTotalWeight) {
        ToppingIngredients.blackOliveTotalWeight = blackOliveTotalWeight;
    }

    public static double getOnionTotalWeight() {
        return onionTotalWeight;
    }

    public static void setOnionTotalWeight(double onionTotalWeight) {
        ToppingIngredients.onionTotalWeight = onionTotalWeight;
    }

    public static double getPizzaSauceTotalWeight() {
        return pizzaSauceTotalWeight;
    }

    public static void setPizzaSauceTotalWeight(double pizzaSauceTotalWeight) {
        ToppingIngredients.pizzaSauceTotalWeight = pizzaSauceTotalWeight;
    }

    public static double getOreganoTotalWeight() {
        return oreganoTotalWeight;
    }

    public static void setOreganoTotalWeight(double oreganoTotalWeight) {
        ToppingIngredients.oreganoTotalWeight = oreganoTotalWeight;
    }

    public static double getTomatoTotalWeight() {
        return tomatoTotalWeight;
    }

    public static void setTomatoTotalWeight(double tomatoTotalWeight) {
        ToppingIngredients.tomatoTotalWeight = tomatoTotalWeight;
    }

    public static double getChickenBreastTotalWeight() {
        return chickenBreastTotalWeight;
    }

    public static void setChickenBreastTotalWeight(double chickenBreastTotalWeight) {
        ToppingIngredients.chickenBreastTotalWeight = chickenBreastTotalWeight;
    }

    public static double getMeatTotalWeight() {
        return meatTotalWeight;
    }

    public static void setMeatTotalWeight(double meatTotalWeight) {
        ToppingIngredients.meatTotalWeight = meatTotalWeight;
    }

    public void getClassName(){
        
    }
    @Override
    public String toString() {
        return super.toString() + "ToppingIngredients{" + "isFresh=" + isFresh + ", price=" + price + '}';
    }

    // HashSet repeats objects 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.isFresh ? 1 : 0);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToppingIngredients other = (ToppingIngredients) obj;
        if (this.isFresh != other.isFresh) {
            return false;
        }
        return Double.doubleToLongBits(this.price) == Double.doubleToLongBits(other.price);
    }
    
    

}
