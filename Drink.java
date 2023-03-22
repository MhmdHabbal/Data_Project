package Data_Project;

public class Drink extends Pizza {
    
    String drinkType;
    double price;
    static int count;

    Drink() {
        super();
        drinkType = " ";
        price = 0;
        count = 0;
    }

    Drink(String drinkType, double price) {

        this.drinkType = drinkType;
        this.price = price;
        count++;

    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return drinkType + "\nPrice: $" + price;
    }

}
