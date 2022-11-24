package Data_Project;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class PizzaDelivery extends Drink {
    
    Scanner input = new Scanner(System.in);

    static Node pizzaNode;
    static Node drinksNode;
    boolean drinkOrder = false;

    static CustomerList PizzaList = new CustomerList();
    static CustomerList DrinksList = new CustomerList();

    CustomerList customerList = new CustomerList();
    CustomerInfo customerInfo = new CustomerInfo();

    PizzaDelivery() {
        super();
    }

    public void Menu() {
        
        Pizza p1 = new Pizza("Cheese Pizza", 15);
        Pizza p2 = new Pizza("Veggie Pizza", 20);
        Pizza p3 = new Pizza("Pepperoni Pizza", 25);
        Pizza p4 = new Pizza("Margherita Pizza", 30);
        Pizza p5 = new Pizza("BBQ Chicken Pizza", 35);
        Pizza p6 = new Pizza("Hawaiian Pizza", 40);
        Pizza p7 = new Pizza("Buffalo Pizza", 45);
        Pizza p8 = new Pizza("Supreme Pizza", 50);

        PizzaList.insertAtBack("1. " + p1);
        PizzaList.insertAtBack("2. " + p2);
        PizzaList.insertAtBack("3. " + p3);
        PizzaList.insertAtBack("4. " + p4);
        PizzaList.insertAtBack("5. " + p5);
        PizzaList.insertAtBack("6. " + p6);
        PizzaList.insertAtBack("7. " + p7);
        PizzaList.insertAtBack("8. " + p8);

        Drink d1 = new Drink("Pepsi", 2);
        Drink d2 = new Drink("Coca Cola", 2);
        Drink d3 = new Drink("Mirinda" , 2);
        Drink d4 = new Drink("7 Up", 2);

        DrinksList.insertAtBack("1. " + d1);
        DrinksList.insertAtBack("2. " + d2);
        DrinksList.insertAtBack("3. " + d3);
        DrinksList.insertAtBack("4. " + d4);

    }

    public void Welcome() {

        if(!PizzaIsEmpty()) {
            System.out.println("Welcome to our pizza delivery app!");
        }

        if(!PizzaIsEmpty()) {

            System.out.println("would you like to order now?");
            String answer = input.next();
        
            boolean flag = false;

            while(!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Please type \"yes\" if you want to order now.\nAnd \"no\" if not.");
                answer = input.next();
            }

            if(answer.equals("no")) {

                System.out.println("Thank you for visiting our delivery app! Have a look on the menu.");
                System.out.println();
                System.out.println("Pizzas:");
                System.out.println("------");
                PizzaList.display();
                System.out.println();

                if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

                    System.out.println("Drinks:");
                    System.out.println("------");
                    DrinksList.display();
                    System.out.println();

                }

                String order;

                do {

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

                System.out.println("Pizzas:");
                System.out.println("------");
                PizzaList.display();
                System.out.println();

                if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

                    System.out.println("Drinks:");
                    System.out.println("------");
                    DrinksList.display();
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
                    System.out.println("Thank you for ordering from our delivery app.");
                }

                else if(another.equals("yes")) {
                    Welcome();
                }

            }
        }

        else if(PizzaIsEmpty()) {
            System.out.println("Sorry, but we are closed for today");
        }

    }

    public void order() {

        System.out.println("Enter the number of the pizza you'd like to order:");
        int pizzaNb = input.nextInt();

        while(pizzaNb > PizzaList.getSize() || pizzaNb < 1) {

            System.out.println("The number you entered is not on the menu.\nPlease enter another number:");
            pizzaNb = input.nextInt();

        }

        pizzaNode = PizzaList.removeSpecificNode(pizzaNb - 1);
        Pizza.count--;

        if(DrinksIsEmpty() && !PizzaIsEmpty()) {
            System.out.println("Sorry, We have no drinks left");
            
        }

        else if(!DrinksIsEmpty() && !PizzaIsEmpty()) {

            System.out.println("Would you like a drink with that?");
            String answer = input.next();

            while(!answer.equals("yes") && !answer.equals("no")) {

                System.out.println("Please type \"yes\" if you want a drink.\nAnd \"no\" if not.");
                answer = input.next();

            }

            if(answer.equals("yes")) {

                System.out.println("Enter the number of the drink you'd like to order:");
                int drinkNb = input.nextInt();
    
                while(drinkNb > DrinksList.getSize() || drinkNb < 1) {
    
                    System.out.println("The number you entered is not on the menu.\nPlease enter another number:");
                    drinkNb = input.nextInt();
    
                }
    
                drinksNode = DrinksList.removeSpecificNode(drinkNb - 1);
                Drink.count--;
                drinkOrder = true;
    
            }
    
            else if(answer.equals("no")) {
    
                drinkOrder = false;
    
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

        System.out.println("Pizza detail: " + pizzaNode.data);

        System.out.println();

        if(drinkOrder) {
            System.out.println("Drink detail: " + drinksNode.data);
        }

        if(DrinksIsEmpty()) {
            System.out.println("We ran out of drinks");
        } 

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        System.out.println("\nDate: " + format.format(date) + "\n");
        System.out.println("-------------------------------");
        System.out.println("!Customer Reciept Copy!\n");
    }
}
