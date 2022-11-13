package Data_Project;

public class Pizza {

    String pizzaType;
    double price;
    static int count;

    Pizza() {
        pizzaType = " ";
        price = 0;
    }

    Pizza(String pizzaType, double price) {

        this.pizzaType = pizzaType;
        this.price = price;
        count++;

    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return pizzaType + "\nPrice: $" + price;
    }
}
