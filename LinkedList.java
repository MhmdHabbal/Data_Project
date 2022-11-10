package Data_Project;

public class LinkedList {
    
    private Node first;

    LinkedList() {
        first = null;
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
    }

    public void insertAtFront(String d) {

        Node node = new Node(d);

        if(isEmpty()) {
            first = node;
        }

        else {
            node.next = first;
            first = node;
        }
    }

    public void removeFromBack() {

        if(isEmpty()) {
            System.out.println("The list is empty");
        }

        else {

            Node current = first, prev = first;
            
            while(current.next != null) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
        }
    }

    public void removeFromFront() {

        if(isEmpty()) {
            System.out.println("The list is empty");
        }

        else {
            first = first.next;
        }
    }

    public void insertAtPosition(int pos, String d) {

        Node node = new Node(d);
        Node current = first, prev = first;

        if(pos == 0) {
            node.next = first;
            first = node;
        }

        else {

            for(int i = 0; i < pos; i++) {
            
                prev = current;
                current = current.next;
            }
    
            prev.next = node;
            node.next = current;
        }

    }

    public void display() {

        Node current = first;

        System.out.print("[");
        while(current.next != null) {
            
            System.out.print(current.data + ", ");

            current = current.next;
        }

        System.out.println(current.data + "]");
    }
}
