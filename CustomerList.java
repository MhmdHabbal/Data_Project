package Data_Project;

public class CustomerList extends LinkedList {
    
    String customer;
    Node first;

    CustomerList(String customer) {
        this.customer = customer;
        first = null;
    }

    CustomerList() {
        super();
    }

    public void enqueue(String customer) {

        super.insertAtBack(customer);
    }

    public String dequeue() {
        
        return super.removeFromFront();
    }

    public void display() {
        super.display();
    }
}
