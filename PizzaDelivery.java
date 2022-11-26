package Data_Project;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class PizzaDelivery extends Drink {
    
    Scanner input = new Scanner(System.in);

    static Node<String> pizzaNode;
    static Node<String> drinksNode;
    static double Pizza_Price;
    static double Drinks_Price;
    static boolean drinkOrder = false;

    static String[] arrayPizza = new String[8];
    static double[] arrayPizza_Price = new double[8];
    static String[] arrayDrinks = new String[4];
    static double[] arrayDrinks_Price = new double[4];

    static CustomerList<String> PizzaList = new CustomerList<>();
    static CustomerList<String> DrinksList = new CustomerList<>();

    static CustomerList<Double> PizzaList_Price = new CustomerList<>();
    static CustomerList<Double> DrinksList_Price = new CustomerList<>();

    CustomerList<String> customerList = new CustomerList<>();
    CustomerInfo customerInfo = new CustomerInfo();

    PizzaDelivery() {
        super();
    }

    public void Menu() {
        
        Pizza p1 = new Pizza("Cheese");
        Pizza p2 = new Pizza("Veggie");
        Pizza p3 = new Pizza("Pepperoni");
        Pizza p4 = new Pizza("Margherita");
        Pizza p5 = new Pizza("Deluxe");
        Pizza p6 = new Pizza("Hawaiian");
        Pizza p7 = new Pizza("Buffalo");
        Pizza p8 = new Pizza("Supreme");

        p1.setPrice(15);
        p2.setPrice(20);
        p3.setPrice(25);
        p4.setPrice(30);
        p5.setPrice(35);
        p6.setPrice(40);
        p7.setPrice(45);
        p8.setPrice(50);

        arrayPizza[0] = p1.getPizzaType();
        arrayPizza[1] = p2.getPizzaType();
        arrayPizza[2] = p3.getPizzaType();
        arrayPizza[3] = p4.getPizzaType();
        arrayPizza[4] = p5.getPizzaType();
        arrayPizza[5] = p6.getPizzaType();
        arrayPizza[6] = p7.getPizzaType();
        arrayPizza[7] = p8.getPizzaType();

        arrayPizza_Price[0] = p1.getPrice();
        arrayPizza_Price[1] = p2.getPrice();
        arrayPizza_Price[2] = p3.getPrice();
        arrayPizza_Price[3] = p4.getPrice();
        arrayPizza_Price[4] = p5.getPrice();
        arrayPizza_Price[5] = p6.getPrice();
        arrayPizza_Price[6] = p7.getPrice();
        arrayPizza_Price[7] = p8.getPrice();

        for(int i = 0; i < arrayPizza.length; i++) {
            
            PizzaList.insertAtBack(arrayPizza[i]);
        }

        for(int i = 0; i < arrayPizza_Price.length; i++) {

            PizzaList_Price.insertAtBack(arrayPizza_Price[i]);
        }

        Drink d1 = new Drink("Pepsi");
        Drink d2 = new Drink("Cola");
        Drink d3 = new Drink("Mirinda");
        Drink d4 = new Drink("7Up");

        d1.setPrice(4);
        d2.setPrice(4);
        d3.setPrice(4);
        d4.setPrice(4);

        arrayDrinks[0] = d1.getDrinkType();
        arrayDrinks[1] = d2.getDrinkType();
        arrayDrinks[2] = d3.getDrinkType();
        arrayDrinks[3] = d4.getDrinkType();

        arrayDrinks_Price[0] = d1.getPrice();
        arrayDrinks_Price[1] = d2.getPrice();
        arrayDrinks_Price[2] = d3.getPrice();
        arrayDrinks_Price[3] = d4.getPrice();

        for(int i = 0; i < arrayDrinks.length; i++) {
            
            DrinksList.insertAtBack(arrayDrinks[i]);
        }

        for(int i = 0; i < arrayDrinks_Price.length; i++) {

            DrinksList_Price.insertAtBack(arrayDrinks_Price[i]);
        }

    }

    public void Welcome() {

        if(!PizzaIsEmpty()) {
            System.out.println("Welcome to our pizza delivery app!");

            System.out.println("would you like to order now?");
            String answer = input.next();
        
            boolean flag = false;

            while(!answer.equals("yes") && !answer.equals("no")) {

                System.out.println();
                System.out.println("Please type \"yes\" if you want to order now.\nAnd \"no\" if not.");
                answer = input.next();
            }

            if(answer.equals("no")) {

                System.out.println("Thank you for visiting our delivery app! Have a look on the menu.");
                System.out.println();
                System.out.println("Pizza:");
                System.out.println("------");
                PizzaList.display(PizzaList_Price);
                System.out.println();

                if(DrinksIsEmpty()) {
                    System.out.println("We ran out of drinks!");
                } 

                else if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

                    System.out.println("Drinks:");
                    System.out.println("------");
                    DrinksList.display(DrinksList_Price);
                    System.out.println();

                }

                String order;

                do {

                    System.out.println();
                    System.out.println("Whenever you are ready to order just type the word \"order\".\nAnd if you want to exit just type the word \"exit\".");
                    order = input.next();

                    if(order.equals("order")) {
                        flag = true;
                        break;
                    }

                    if(order.equals("exit")) {
                        flag = false;
                        break;
                    }

                } while(!answer.equals("yes"));



                if(flag == true || order.equals("order")) {

                    order();

                    System.out.println("Delivery Form");
                    Object customer = customerInfo.customer();
                    customerList.enqueue(String.valueOf(customer));
                    System.out.println();

                    reciept();

                }

                if(flag != false) {

                    System.out.println("Do you want to order more?");
                    String another = input.next();
    
                    if(!another.equals("no") && !another.equals("yes")) {
                        System.out.println();
    
                        do {
    
                            System.out.println("Please type \"yes\" if you want another order.\nAnd \"no\" if not.");
                            another = input.next();
                            
                            if(another.equals("yes")) {
                                Welcome();
                                break;
                            }
    
                            else if(another.equals("no")) {
                                break;
                            }
    
                        } while(!another.equals("yes") || !another.equals("no"));
    
                    }
    
                    else if(another.equals("no")) {
                        System.out.println();
                        System.out.println("Thank you for ordering from our delivery app.");
                    }
    
                    else if(another.equals("yes")) {
                        System.out.println();
                        Welcome();
                    }

                }

            }

            else if(answer.equals("yes")) {

                System.out.println("Here is the menu:");
                System.out.println();
                System.out.println("Pizza:");
                System.out.println("------");
                PizzaList.display(PizzaList_Price);
                System.out.println();

                if(DrinksIsEmpty()) {
                    System.out.println("We ran out of drinks!");
                } 

                else if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

                    System.out.println("Drinks:");
                    System.out.println("------");
                    DrinksList.display(DrinksList_Price);
                    System.out.println();

                }

                order();

                System.out.println("Delivery Form");
                Object customer = customerInfo.customer();
                customerList.enqueue(String.valueOf(customer));
                System.out.println();

                reciept();

                System.out.println("Do you want to order more?");
                String another = input.next();

                if(!another.equals("no") && !another.equals("yes")) {

                    do {

                        System.out.println();
                        System.out.println("Please type \"yes\" if you want another order.\nAnd \"no\" if not.");
                        another = input.next();
                        
                        if(another.equals("yes")) {
                            System.out.println();
                            Welcome();
                            break;
                        }

                        else if(another.equals("no")) {
                            break;
                        }

                    } while(!another.equals("yes") || !another.equals("no"));

                    System.out.println();
                }

                else if(another.equals("no")) {
                    System.out.println("Thank you for ordering from our delivery app.");
                }

                else if(another.equals("yes")) {
                    System.out.println();
                    Welcome();
                }

            }
        }

        else if(PizzaIsEmpty()) {
            System.out.println("Sorry! but we are closed for today");
        }

    }

    public void order() {

        System.out.println("Enter the name of the pizza you'd like to order:");
        String pizzaName = input.next();

        while(!PizzaList.search(pizzaName)) {

            System.out.println();
            System.out.println("Sorry! but we don't have this pizza right now,\nor you might have written somthing wrong.\nPlease enter another name:\n");
            pizzaName = input.next();
        }

        System.out.println();

        pizzaNode = PizzaList.removeSpecificNode(pizzaName);
        Pizza_Price = PizzaList.removeSpecific_PriceNode(PizzaList_Price);
        Pizza.count--;

        if(DrinksIsEmpty() && !PizzaIsEmpty()) {
            drinkOrder = false;
            
        }

        else if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

            System.out.println("Would you like a drink with that?");
            String answer = input.next();

            while(!answer.equals("yes") && !answer.equals("no")) {

                System.out.println();
                System.out.println("Please type \"yes\" if you want a drink.\nAnd \"no\" if not.");
                answer = input.next();

            }

            if(answer.equals("yes")) {

                System.out.println();
                System.out.println("Enter the name of the drink you'd like to order:");
                String drinkName = input.next();
    
                while(!DrinksList.search(drinkName)) {
    
                    System.out.println();
                    System.out.println("Sorry! but we don't have this drink right now,\nor you might have written somthing wrong.\nPlease enter another name:");
                    drinkName = input.next();
    
                }

                System.out.println();
    
                drinksNode = DrinksList.removeSpecificNode(drinkName);
                Drinks_Price = DrinksList.removeSpecific_PriceNode(DrinksList_Price);
                Drink.count--;
                drinkOrder = true;
    
            }
    
            else if(answer.equals("no")) {
    
                drinkOrder = false;
                System.out.println();
    
            }

        }

    }

    public boolean PizzaIsEmpty() {
        
        return Pizza.count == 0;
    }

    public boolean DrinksIsEmpty() {
        
        return Drink.count == 0;
    }

    public void reciept() {

        System.out.println("\nReciept:");
        System.out.println("------------------------------");
        customerInfo.display();
        System.out.println();

        System.out.println("Pizza detail: " + pizzaNode.data + "\nPrice: $" + Pizza_Price);

        System.out.println();

        if(drinkOrder) {
            System.out.println("Drink detail: " + drinksNode.data + "\nPrice: $" + Drinks_Price);
            System.out.println();
            System.out.println("Total Price: " + (Pizza_Price + Drinks_Price));
        }

        else if(!drinkOrder) {
            System.out.println("Total Price: " + Pizza_Price);
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        System.out.println("\nDate: " + format.format(date) + "\n");
        System.out.println("-------------------------------");
        System.out.println("!Customer Reciept Copy!\n");
    }
}
