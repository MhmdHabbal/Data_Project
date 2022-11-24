package Data_Project;

public class CustomerList {
    
    private Node first;
    private int size;

    CustomerList() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertAtBack(String d) {

        Node node = new Node(d);

        if(isEmpty()) {
            first = node;
        }

        else {
            Node current = first;

            while(current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }

    public String removeFromFront() {

        if(!isEmpty()) {

            String d = first.data;
            first = first.next;
            return d;

        }

        size--;

        return null;
    }

    public Node removeSpecificNode(int d) {

        Node current = first, prev = first;

        if(isEmpty()) {
            return null;
        }

        if(d == 0) {
            first = first.next;
        }

        else {

            for(int i = 0; i < d; i++) {
                prev = current;
                current = current.next;
            }
    
            prev.next = current.next;

        }

        return current;

    }

    public void display() {

        Node current = first;

        while(current != null) {
            System.out.println(current.data);
            System.out.println();
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public void enqueue(String customer) {

        insertAtBack(customer);
    }

    public String dequeue() {
        
        return removeFromFront();
    }

}
