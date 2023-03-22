package Data_Project;

import java.util.Scanner;

public class CustomerInfo {

    Scanner input = new Scanner(System.in);
    
    private String firstName, lastName, address;
    private int phoneNb;
    static double orderNb;

    CustomerInfo() {

        firstName = " ";
        lastName = " ";
        address = " ";
        phoneNb = 0;
        orderNb = Math.random() * 1000;

    }

    CustomerInfo(String firstName, String lastName, String address, int phoneNb) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNb = phoneNb;
        orderNb = Math.random() * 1000;

    }

    public Object customer() {

        System.out.print("First Name: ");
        this.firstName = input.next();

        System.out.print("Last Name: ");
        this.lastName = input.next();

        System.out.print("Address: ");
        this.address = input.next();

        System.out.print("Phone Number: ");
        this.phoneNb = input.nextInt();

        return CustomerInfo2(firstName, lastName, address, phoneNb);
    }

    private Object CustomerInfo2(String firstName, String lastName, String address, int phoneNb) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNb = phoneNb;
        orderNb = Math.random() * 1000;

        return firstName + " " + lastName + " " + address + " " + phoneNb + " " + orderNb;
    }

    public void display() {

        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Adress: " + address);
        System.out.println("Phone Number: " + phoneNb);
        System.out.println("Order Number: " + orderNb);

    }
}
